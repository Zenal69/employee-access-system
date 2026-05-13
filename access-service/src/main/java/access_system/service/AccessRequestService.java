package access_system.service;
import access_system.dto.EmployeeDTO;
import access_system.dto.EmployeeRequestSummaryDTO;
import access_system.dto.RequestSummaryDTO;
import access_system.entity.AccessRequest;
import access_system.repository.AccessRequestRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.web.client.RestTemplate;

@Service
public class AccessRequestService {

    private final RestTemplate restTemplate;
    private final AccessRequestRepository repository;

    public AccessRequestService(
            AccessRequestRepository repository,
            RestTemplate restTemplate
    ) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    public AccessRequest create(AccessRequest request) {

        request.setStatus("PENDING");
        request.setRequestDate(LocalDateTime.now());

        return repository.save(request);
    }

    public List<AccessRequest> getAll() {
        return repository.findAll();
    }

    public AccessRequest approve(Long id) {

        AccessRequest request = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found"));

        request.setStatus("APPROVED");

        return repository.save(request);
    }

    public AccessRequest reject(Long id) {

        AccessRequest request = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found"));

        request.setStatus("REJECTED");

        return repository.save(request);
    }

    public List<AccessRequest> getPendingRequests() {

        return repository.findAll()
                .stream()
                .filter(request -> request.getStatus().equals("PENDING"))
                .toList();
    }

    public Map<String, Long> getRequestSummary() {

        return repository.findAll()
                .stream()
                .collect(Collectors.groupingBy(
                        AccessRequest::getStatus,
                        Collectors.counting()
                ));
    }

    public List<RequestSummaryDTO> getRequestSummaryNative() {
        return repository.getRequestSummaryNative();
    }

    public List<EmployeeRequestSummaryDTO> getEmployeeRequestSummary() {
        return repository.getEmployeeRequestSummary();
    }

    public EmployeeDTO getEmployee(Long employeeId) {

        String url = "http://employee-service:8090/employees/" + employeeId;

        return restTemplate.getForObject(url, EmployeeDTO.class);
    }
}
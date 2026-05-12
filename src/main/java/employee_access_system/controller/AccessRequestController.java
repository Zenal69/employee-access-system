package employee_access_system.controller;
import employee_access_system.dto.RequestSummaryDTO;
import employee_access_system.entity.AccessRequest;
import employee_access_system.service.AccessRequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/requests")
public class AccessRequestController {

    private final AccessRequestService service;

    public AccessRequestController(AccessRequestService service) {
        this.service = service;
    }

    @PostMapping
    public AccessRequest create(@RequestBody AccessRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<AccessRequest> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}/approve")
    public AccessRequest approve(@PathVariable Long id) {
        return service.approve(id);
    }

    @PutMapping("/{id}/reject")
    public AccessRequest reject(@PathVariable Long id) {
        return service.reject(id);
    }

    @GetMapping("/pending")
    public List<AccessRequest> getPendingRequests() {
        return service.getPendingRequests();
    }

    @GetMapping("/status-summary")
    public Map<String, Long> getSummary() {
        return service.getRequestSummary();
    }

    @GetMapping("/all-data-summary")
    public List<RequestSummaryDTO> getNativeSummary() {
        return service.getRequestSummaryNative();
    }
}
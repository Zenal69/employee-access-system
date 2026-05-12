package employee_access_system.repository;

import employee_access_system.dto.RequestSummaryDTO;
import employee_access_system.entity.AccessRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccessRequestRepository extends JpaRepository<AccessRequest, Long> {


    @Query(value = """
        SELECT 
            e.name as employeeName,
            ar.application_name as applicationName,
            ar.status as status
        FROM access_requests ar
        JOIN employees e
            ON e.id = ar.employee_id
        """, nativeQuery = true)
    List<RequestSummaryDTO> getRequestSummaryNative();
}
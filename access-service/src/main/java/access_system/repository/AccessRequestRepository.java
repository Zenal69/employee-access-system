package access_system.repository;

import access_system.dto.EmployeeRequestSummaryDTO;
import access_system.dto.RequestSummaryDTO;
import access_system.entity.AccessRequest;
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
            ON e.id = ar. id
        """, nativeQuery = true)
    List<RequestSummaryDTO> getRequestSummaryNative();


    @Query(value = """
    SELECT 
        e.name AS employeeName,
        ar.status AS status,
        COUNT(ar.id) AS totalRequest
    FROM access_requests ar
    JOIN employees e 
        ON e.id = ar. id
    GROUP BY e.name, ar.status
    ORDER BY e.name
""", nativeQuery = true)
    List<EmployeeRequestSummaryDTO> getEmployeeRequestSummary();
}
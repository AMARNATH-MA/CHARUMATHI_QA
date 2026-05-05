package t.com.attendencestudentmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import t.com.attendencestudentmanagement.DHO.Report;

public interface ReportRepo extends JpaRepository<Report,Integer> {
}

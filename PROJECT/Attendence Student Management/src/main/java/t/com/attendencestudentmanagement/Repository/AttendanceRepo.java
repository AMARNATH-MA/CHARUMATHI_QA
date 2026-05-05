package t.com.attendencestudentmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import t.com.attendencestudentmanagement.DHO.Attendance;

@Repository
public interface AttendanceRepo extends JpaRepository<Attendance, Integer> {
}
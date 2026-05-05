package t.com.attendencestudentmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import t.com.attendencestudentmanagement.DHO.Staff;

public interface StaffRepo extends JpaRepository<Staff,Integer> {
}

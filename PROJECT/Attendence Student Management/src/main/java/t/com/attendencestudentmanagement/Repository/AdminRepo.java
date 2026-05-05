package t.com.attendencestudentmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import t.com.attendencestudentmanagement.DHO.Admin;

public interface AdminRepo extends JpaRepository<Admin,Integer> {
}

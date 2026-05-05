package t.com.attendencestudentmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import t.com.attendencestudentmanagement.DHO.Student;

public interface StudentRepo extends JpaRepository<Student,Integer> {
}

package t.com.attendencestudentmanagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import t.com.attendencestudentmanagement.DHO.Student;
import t.com.attendencestudentmanagement.Repository.StudentRepo;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public List<Student> getStudent() {
        return studentRepo.findAll();
    }

    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    public Student updateStudent(int id, Student student) {
        if (studentRepo.existsById(id)) {
            Student existingStudent = studentRepo.getById(id);
            existingStudent.setStudentName(student.getStudentName());
            existingStudent.setDepartment(student.getDepartment());
            existingStudent.setYear(student.getYear());
            existingStudent.setPassword(student.getPassword());
            return studentRepo.save(existingStudent);
        } else {
            throw new RuntimeException("Student not found with id: " + id);
        }
    }

    public String deleteStudent(int id) {
        if (studentRepo.existsById(id)) {
            studentRepo.deleteById(id);
            return "Student deleted successfully";
        } else {
            return "Student not found";
        }
    }
}
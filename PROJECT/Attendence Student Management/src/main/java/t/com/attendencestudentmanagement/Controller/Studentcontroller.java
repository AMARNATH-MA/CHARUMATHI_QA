package t.com.attendencestudentmanagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import t.com.attendencestudentmanagement.DHO.Student;
import t.com.attendencestudentmanagement.Service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/Student")
public class Studentcontroller {
    @Autowired
    private StudentService studentService;
    @GetMapping("/StudentDetails")
    public List<Student> getStudent()
    {
        return studentService.getStudent();
    }
    @PostMapping("/AddStudent")
    public Student addStudent(@RequestBody Student student)
    {
        return studentService.addStudent(student);
    }
    @PutMapping("/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable int id)
    {
        return studentService.updateStudent(id, student);
    }
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id)
    {
        return studentService.deleteStudent(id);
    }
}

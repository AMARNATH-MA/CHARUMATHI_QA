package t.com.attendencestudentmanagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import t.com.attendencestudentmanagement.DHO.Attendance;
import t.com.attendencestudentmanagement.DHO.Student;
import t.com.attendencestudentmanagement.DHO.Staff;
import t.com.attendencestudentmanagement.Repository.AttendanceRepo;
import t.com.attendencestudentmanagement.Repository.StudentRepo;
import t.com.attendencestudentmanagement.Repository.StaffRepo;

import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepo attendanceRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private StaffRepo staffRepo;

    public List<Attendance> getAllAttendance() {
        return attendanceRepo.findAll();
    }

    public Attendance addAttendance(Attendance attendance) {

        int studentId = attendance.getStudent().getStudentId();
        int staffId = attendance.getStaff().getStaffId();

        Student student = studentRepo.getById(studentId);
        Staff staff = staffRepo.getById(staffId);

        staff.setAdminPassword(staff.getAdmin().getAdminPassword());

        attendance.setStudent(student);
        attendance.setStaff(staff);

        return attendanceRepo.save(attendance);
    }

    public Attendance updateAttendance(int id, Attendance attendance) {

        if (attendanceRepo.existsById(id)) {

            Attendance existing = attendanceRepo.getById(id);

            int studentId = attendance.getStudent().getStudentId();
            int staffId = attendance.getStaff().getStaffId();

            Student student = studentRepo.getById(studentId);
            Staff staff = staffRepo.getById(staffId);

            staff.setAdminPassword(staff.getAdmin().getAdminPassword());

            existing.setStudent(student);
            existing.setStaff(staff);
            existing.setStatus(attendance.getStatus());

            return attendanceRepo.save(existing);
        }
        else {
            throw new RuntimeException("Attendance not found");
        }
    }

    public String deleteAttendance(int id) {

        if (attendanceRepo.existsById(id)) {
            attendanceRepo.deleteById(id);
            return "Attendance deleted successfully";
        }
        else {
            return "Attendance not found";
        }
    }
}
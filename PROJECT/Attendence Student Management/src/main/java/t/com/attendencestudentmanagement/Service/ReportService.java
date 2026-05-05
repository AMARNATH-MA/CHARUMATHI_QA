package t.com.attendencestudentmanagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import t.com.attendencestudentmanagement.DHO.Report;
import t.com.attendencestudentmanagement.DHO.Student;
import t.com.attendencestudentmanagement.DHO.Staff;
import t.com.attendencestudentmanagement.Repository.ReportRepo;
import t.com.attendencestudentmanagement.Repository.StudentRepo;
import t.com.attendencestudentmanagement.Repository.StaffRepo;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportRepo reportRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private StaffRepo staffRepo;

    public List<Report> getreport() {
        return reportRepo.findAll();
    }

    public Report addReport(Report report) {

        int studentId = report.getStudent().getStudentId();
        int staffId = report.getStaff().getStaffId();

        Student student = studentRepo.getById(studentId);
        Staff staff = staffRepo.getById(staffId);

        staff.setAdminPassword(staff.getAdmin().getAdminPassword());

        report.setStudent(student);
        report.setStaff(staff);

        return reportRepo.save(report);
    }

    public Report updateReport(int id, Report report) {

        if (reportRepo.existsById(id)) {

            Report existingReport = reportRepo.getById(id);

            int studentId = report.getStudent().getStudentId();
            int staffId = report.getStaff().getStaffId();

            Student student = studentRepo.getById(studentId);
            Staff staff = staffRepo.getById(staffId);

            staff.setAdminPassword(staff.getAdmin().getAdminPassword());

            existingReport.setStudent(student);
            existingReport.setStaff(staff);
            existingReport.setTotal(report.getTotal());
            existingReport.setPresent(report.getPresent());
            existingReport.setAbsent(report.getAbsent());

            return reportRepo.save(existingReport);
        }
        else {
            throw new RuntimeException("Report not found with id: " + id);
        }
    }

    public String deleteReport(int id) {

        if (reportRepo.existsById(id)) {
            reportRepo.deleteById(id);
            return "Report deleted successfully";
        }
        else {
            return "Report not found";
        }
    }
}
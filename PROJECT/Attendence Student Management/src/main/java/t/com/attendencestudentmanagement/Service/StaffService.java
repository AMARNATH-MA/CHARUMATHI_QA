package t.com.attendencestudentmanagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import t.com.attendencestudentmanagement.DHO.Admin;
import t.com.attendencestudentmanagement.DHO.Staff;
import t.com.attendencestudentmanagement.Repository.AdminRepo;
import t.com.attendencestudentmanagement.Repository.StaffRepo;

import java.util.List;

@Service
public class StaffService {

    @Autowired
    private StaffRepo staffRepo;
    @Autowired
    private AdminRepo adminRepo;

    public List<Staff> getStaff() {
        return staffRepo.findAll();
    }

    public Staff addStaff(Staff staff) {
        int adminId = staff.getAdmin().getAdminId();
        Admin admin = adminRepo.getById(adminId);

        staff.setAdmin(admin);
        staff.setAdminPassword(admin.getAdminPassword());

        return staffRepo.save(staff);
    }

    public Staff updateStaff(int id, Staff staff) {
        if (staffRepo.existsById(id)) {
            Staff existingStaff = staffRepo.getById(id);
            existingStaff.setStaffName(staff.getStaffName());
            existingStaff.setDepartment(staff.getDepartment());
            existingStaff.setPassword(staff.getPassword());
            existingStaff.setAdmin(staff.getAdmin());
            return staffRepo.save(existingStaff);
        } else {
            throw new RuntimeException("Staff not found with id: " + id);
        }
    }

    public String deleteStaff(int id) {
        if (staffRepo.existsById(id)) {
            staffRepo.deleteById(id);
            return "Staff deleted successfully";
        } else {
            return "Staff not found";
        }
    }
}
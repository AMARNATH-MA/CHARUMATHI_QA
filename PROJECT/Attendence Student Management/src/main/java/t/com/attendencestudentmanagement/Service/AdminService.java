package t.com.attendencestudentmanagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import t.com.attendencestudentmanagement.DHO.Admin;
import t.com.attendencestudentmanagement.Repository.AdminRepo;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;

    public List<Admin> getadmin() {
        return adminRepo.findAll();
    }

    public Admin addAdmin(Admin admin) {
        return adminRepo.save(admin);
    }

    public Admin updateAdmin(int id, Admin admin) {
        if (adminRepo.existsById(id)) {
            Admin existingAdmin = adminRepo.getById(id);
            existingAdmin.setAdminPassword(admin.getAdminPassword());
            return adminRepo.save(existingAdmin);
        } else {
            throw new RuntimeException("Admin not found with id: " + id);
        }
    }

    public String deleteAdmin(int id) {
        if (adminRepo.existsById(id)) {
            adminRepo.deleteById(id);
            return "Admin deleted successfully";
        } else {
            return "Admin not found";
        }
    }
}
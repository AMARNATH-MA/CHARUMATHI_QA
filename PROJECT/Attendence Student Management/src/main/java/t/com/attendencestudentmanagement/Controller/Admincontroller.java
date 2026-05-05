package t.com.attendencestudentmanagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import t.com.attendencestudentmanagement.DHO.Admin;
import t.com.attendencestudentmanagement.Service.AdminService;

import java.util.List;

@RestController
@RequestMapping("/Admin")
public class Admincontroller {
    @Autowired
    private AdminService adminservice;
    @GetMapping("/AdminDetails")
    public List<Admin> getadmin()
    {
        return adminservice.getadmin();
    }
    @PostMapping("/AddAdmin")
    public Admin addAdmin(@RequestBody Admin admin)
    {
        return adminservice.addAdmin(admin);
    }
    @PutMapping("/{id}")
    public Admin updateAdmin(@RequestBody Admin admin, @PathVariable int id)
    {
        return adminservice.updateAdmin(id, admin);
    }
    @DeleteMapping("/{id}")
    public String deleteAdmin(@PathVariable int id)
    {
        return adminservice.deleteAdmin(id);
    }
}

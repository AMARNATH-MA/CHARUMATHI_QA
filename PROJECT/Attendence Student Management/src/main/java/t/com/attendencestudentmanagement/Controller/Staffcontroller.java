package t.com.attendencestudentmanagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import t.com.attendencestudentmanagement.DHO.Staff;
import t.com.attendencestudentmanagement.Service.StaffService;

import java.util.List;

@RestController
@RequestMapping("/Staff")
public class Staffcontroller {
    @Autowired
    private StaffService staffService;
    @GetMapping("/StaffDetails")
    public List<Staff> getStaff()
    {
        return staffService.getStaff();
    }
    @PostMapping("/AddStaff")
    public Staff addStaff(@RequestBody Staff staff)
    {
        return staffService.addStaff(staff);
    }
    @PutMapping("/{id}")
    public Staff updtaeStaff(@PathVariable int id, @RequestBody Staff staff)
    {
        return staffService.updateStaff(id,staff);
    }
    @DeleteMapping("/{id}")
    public String deleteStaff(@PathVariable int id)
    {
        return staffService.deleteStaff(id);
    }
}

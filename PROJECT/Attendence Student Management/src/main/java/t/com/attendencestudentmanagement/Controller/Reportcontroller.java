package t.com.attendencestudentmanagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import t.com.attendencestudentmanagement.DHO.Report;
import t.com.attendencestudentmanagement.Service.ReportService;

import java.util.List;

@RestController
@RequestMapping("/Report")
public class Reportcontroller {
    @Autowired
    private ReportService reportService;
    @GetMapping("/GetReport")
    public List<Report> getreport()
    {
        return reportService.getreport();
    }
    @PostMapping("/AddReport")
    public Report addReport(@RequestBody Report report)
    {
        return reportService.addReport(report);
    }
    @PutMapping("/{id}")
    public Report updateReport(@PathVariable int id, @RequestBody Report report)
    {
        return reportService.updateReport(id,report);
    }
    @DeleteMapping("/{id}")
    public String deleteReport(@PathVariable int id)
    {
        return reportService.deleteReport(id);
    }
}

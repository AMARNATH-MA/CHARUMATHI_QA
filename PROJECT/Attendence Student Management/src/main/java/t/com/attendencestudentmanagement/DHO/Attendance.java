package t.com.attendencestudentmanagement.DHO;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name="StaffId")
    private Staff staff;
    @ManyToOne
    @JoinColumn(name="StudentId")
    private Student student;
    @Column(name="Status")
    private String status;
}

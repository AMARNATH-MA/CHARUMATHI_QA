package t.com.attendencestudentmanagement.DHO;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name="StaffId")
    private Staff Staff;
    @ManyToOne
    @JoinColumn(name="StudentId")
    private Student Student;
    @Column(name="Total")
    private int Total;
    @Column(name="Present")
    private int Present;
    @Column(name="Absent")
    private int Absent;
}

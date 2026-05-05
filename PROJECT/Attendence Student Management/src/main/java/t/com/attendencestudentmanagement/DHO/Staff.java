package t.com.attendencestudentmanagement.DHO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int StaffId;

    @Column(name="StaffName")
    private String StaffName;

    @Column(name="Department")
    private String Department;

    @Column(name="Password")
    private String Password;

    @ManyToOne
    @JoinColumn(name = "AdminId")
    private Admin Admin;

    @Column(name = "AdminPassword")
    private String AdminPassword;
}
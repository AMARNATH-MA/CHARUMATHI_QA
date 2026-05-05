package t.com.attendencestudentmanagement.DHO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int StudentId;
    @Column(name="StudentName")
    private String StudentName;
    @Column(name="Department")
    private String Department;
    @Column(name="Password")
    private String Password;
    @Column(name="Year")
    private String Year;
}

package testproject.model.entity;

import jakarta.persistence.*;
import lombok.*;
import testproject.model.dto.PatientDto;

import java.time.LocalDate;

@Entity
@Table(name = "patient")
@Getter@Setter@ToString@Builder
@NoArgsConstructor@AllArgsConstructor
public class PatientEntity extends BaseTime{
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientid;
    @Column(columnDefinition = "varchar(50)" , nullable = false)
    private String name;
    @Column(columnDefinition = "DATE" , nullable = false)
    private LocalDate birthdate;
    @Column(columnDefinition = "varchar(20)" , nullable = false, unique = true)
    private String phone;
    @Column(columnDefinition = "varchar(100)" , nullable = false)
    private String address;

    public PatientDto toDto(){
        return PatientDto.builder()
                .patientid(this.patientid)
                .name(this.name)
                .birthdate(this.birthdate)
                .phone(this.phone)
                .address(this.address)
                .createdat(this.getCreatedat() != null ? this.getCreatedat().toString() : "No Date")
                .build();
    }
}

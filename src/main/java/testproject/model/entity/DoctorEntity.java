package testproject.model.entity;

import jakarta.persistence.*;
import lombok.*;
import testproject.model.dto.DoctorDto;

import java.time.LocalDateTime;

@Entity
@Table(name = "doctor")
@Getter@Setter@ToString@Builder
@NoArgsConstructor@AllArgsConstructor
public class DoctorEntity extends BaseTime {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorid;
    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String name;
    @Column(columnDefinition = "varchar(50)" , nullable = false)
    private String specialty;
    @Column(columnDefinition = "varchar(20)" , nullable = false)
    private String phone;
//    @Column(columnDefinition = "timestamp default current_timestamp" , nullable = false)
//    private LocalDateTime createdat;

    public DoctorDto toDto(){
        return DoctorDto.builder()
                .doctorid(this.doctorid)
                .name(this.name)
                .specialty(this.specialty)
                .phone(this.phone)
                .createdat(this.getCreatedat() != null ? this.getCreatedat().toString() : "default value")
                .build();
    }
}

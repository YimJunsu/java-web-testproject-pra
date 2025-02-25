package testproject.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import testproject.model.dto.ReservationDto;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
@Getter@Setter@Builder@ToString
@NoArgsConstructor@AllArgsConstructor
public class ReservaitonEntity extends BaseTime{
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationid;
    @Column(columnDefinition = "DATE" , nullable = false)
    private LocalDate reservaitondate;
    @Column(columnDefinition = "TIME" , nullable = false)
    private LocalDateTime reservationtime;
    @Column(columnDefinition = "boolean")
    @ColumnDefault("false")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "doctorid")
    private DoctorEntity doctorEntity;

    @ManyToOne
    @JoinColumn(name = "patientid")
    private PatientEntity patientEntity;

    public ReservationDto toDto(){
        return ReservationDto.builder()
                .reservationid(this.reservationid)
                .reservaitondate(this.reservaitondate)
                .reservaitontime(this.reservationtime)
                .status(this.status)
                .doctorid(this.doctorEntity.getDoctorid())
                .patientid(this.patientEntity.getPatientid())
                .createdat(this.getCreatedat().toString())
                .build();
    }
}

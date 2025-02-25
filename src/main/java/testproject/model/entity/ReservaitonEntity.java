package testproject.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import testproject.model.dto.ReservationDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "reservation")
@Getter@Setter@Builder@ToString
@NoArgsConstructor@AllArgsConstructor
public class ReservaitonEntity extends BaseTime{
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationid;
    @Column(columnDefinition = "DATE" , nullable = false)
    private LocalDate reservationdate;
    @Column(columnDefinition = "TIME" , nullable = false)
    private LocalTime reservationtime;
    @Column(columnDefinition = "boolean")
    @ColumnDefault("false")
    private boolean status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctorid")
    private DoctorEntity doctorEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patientid")
    private PatientEntity patientEntity;

    public ReservationDto toDto(){
        return ReservationDto.builder()
                .reservationid(this.reservationid)
                .reservationdate(this.reservationdate)
                .reservationtime(this.reservationtime)
                .status(this.status)
                .doctorid(this.doctorEntity.getDoctorid())
                .doctorName(this.doctorEntity.getName())
                .patientid(this.patientEntity.getPatientid())
                .patientName(this.patientEntity.getName())
                .createdat(this.getCreatedat() != null ? this.getCreatedat().toString() : "default value")
                .build();
    }

}

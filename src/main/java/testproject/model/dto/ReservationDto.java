package testproject.model.dto;

import lombok.*;
import testproject.model.entity.BaseTime;
import testproject.model.entity.ReservaitonEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter@Setter@Builder@ToString
@NoArgsConstructor@AllArgsConstructor
public class ReservationDto {
    private int reservationid;
    private LocalDate reservationdate;
    private LocalTime reservationtime;
    private boolean status;
    private int doctorid;
    private int patientid;
    private String createdat;
    private String doctorName;
    private String patientName;

    public ReservaitonEntity toEntity(){
        return ReservaitonEntity.builder()
                .reservationid(this.reservationid)
                .reservationdate(this.reservationdate)
                .reservationtime(this.reservationtime)
                .status(this.status)
                .build();
    }
}

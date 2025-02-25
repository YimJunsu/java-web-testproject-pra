package testproject.model.dto;

import lombok.*;
import testproject.model.entity.BaseTime;
import testproject.model.entity.ReservaitonEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter@Setter@Builder@ToString
@NoArgsConstructor@AllArgsConstructor
public class ReservationDto {
    private int reservationid;
    private LocalDate reservaitondate;
    private LocalDateTime reservaitontime;
    private boolean status;
    private int doctorid;
    private int patientid;
    private String createdat;
    
    public ReservaitonEntity toEntity(){
        return ReservaitonEntity.builder()
                .reservationid(this.reservationid)
                .reservaitondate(this.reservaitondate)
                .reservationtime(this.reservaitontime)
                .status(this.status)
                .build();
    }
}

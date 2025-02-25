package testproject.model.dto;

import lombok.*;
import testproject.model.entity.BaseTime;
import testproject.model.entity.PatientEntity;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {
    private int patientid;
    private String name;
    private LocalDate birthdate;
    private String phone;
    private String address;
    private String createdat;

    public PatientEntity toEntity(){
        return PatientEntity.builder()
                .patientid(this.patientid)
                .name(this.name)
                .birthdate(this.birthdate)
                .phone(this.phone)
                .address(this.address)
                .build();
    }
}

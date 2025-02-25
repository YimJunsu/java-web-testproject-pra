package testproject.model.dto;

import lombok.*;
import testproject.model.entity.BaseTime;
import testproject.model.entity.DoctorEntity;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {
    private int doctorid;
    private String name;
    private String specialty;
    private String phone;
    private String createdat;

    public DoctorEntity toEntity(){
        return DoctorEntity.builder()
                .doctorid(this.doctorid)
                .name(this.name)
                .specialty(this.specialty)
                .phone(this.phone)
                .build();
    }
}

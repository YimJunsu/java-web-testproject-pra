package testproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import testproject.model.dto.ReservationDto;
import testproject.model.entity.PatientEntity;
import testproject.model.entity.ReservaitonEntity;
import testproject.model.repository.ReservationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired private ReservationRepository reservationRepository;

    public boolean uplaod(ReservationDto reservationDto){
        ReservaitonEntity reservaitonEntity = reservationDto.toEntity();
        ReservaitonEntity save = reservationRepository.save(reservaitonEntity);
        if(save.getReservationid()>0){
            return true;
        }else {
            System.out.println("등록실패(예약)");
            return false;
        }
    }
    public List<ReservationDto> viewAll(){
        List<ReservaitonEntity> reservaitonEntityList = reservationRepository.findAll();
        List<ReservationDto> reservationDtoList = new ArrayList<>();
        reservaitonEntityList.forEach(obj->{
            reservationDtoList.add(obj.toDto());
        });
        return reservationDtoList;
    }
    public ReservationDto view(int reservationid){
        Optional<ReservaitonEntity> optional = reservationRepository.findById(reservationid);
        if(optional.isPresent()){
            ReservaitonEntity reservaitonEntity = optional.get();
            ReservationDto reservationDto = reservaitonEntity.toDto();
            return reservationDto;
        }
        return null;
    }
    @Transactional
    public boolean change(ReservationDto reservationDto){
        ReservaitonEntity updateEntity = reservationRepository.findByReservationid(reservationDto.getReservationid());
        if (reservationDto.getReservationid() > 0) {
            updateEntity.setStatus(reservationDto.isStatus());
            return true;
        }
        return false;
    }
    @Transactional
    public boolean remove(int reservationid) {
        reservationRepository.deleteById(reservationid);
        return true;
    }
    // 의사 예약 조회
    public List<ReservationDto> viewAllDoctor(int doctorid){
        List<ReservaitonEntity> reservaitonEntityList = reservationRepository.findByDoctorEntity_Doctorid(doctorid);
        List<ReservationDto> reservationDtoList = new ArrayList<>();
        reservaitonEntityList.forEach(obj->{
            reservationDtoList.add(obj.toDto());
        });
        return reservationDtoList;
    }
    // 환자 예약 조회
    public List<ReservationDto> viewAllPatient(int patientid){
        List<ReservaitonEntity> reservaitonEntityList = reservationRepository.findByPatientEntity_Patientid(patientid);
        List<ReservationDto> reservationDtoList = new ArrayList<>();
        reservaitonEntityList.forEach(obj->{
            reservationDtoList.add(obj.toDto());
        });
        return reservationDtoList;
    }
}

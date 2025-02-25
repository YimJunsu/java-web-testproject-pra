package testproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import testproject.model.dto.PatientDto;
import testproject.model.entity.PatientEntity;
import testproject.model.repository.PatientRepository;
import testproject.model.repository.ReservationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired private PatientRepository patientRepository;
    @Autowired private ReservationRepository reservationRepository;
    public boolean upload(PatientDto patientDto){
        PatientEntity patientEntity = patientDto.toEntity();
        PatientEntity save = patientRepository.save(patientEntity);
        if(save.getPatientid()>0){
            return true;
        }else {
            System.out.println("등록실패");
            return false;
        }
    }

    public List<PatientDto> viewAll(){
        List<PatientEntity> patientEntityList = patientRepository.findAll();
        List<PatientDto> patientDtoList = new ArrayList<>();
        patientEntityList.forEach(obj->{
            patientDtoList.add(obj.toDto());
        });
        return patientDtoList;
    }

    public PatientDto view(int patientid){
        Optional<PatientEntity> optional = patientRepository.findById(patientid);
        if(optional.isPresent()){
            PatientEntity patientEntity = optional.get();
            PatientDto patientDto = patientEntity.toDto();
            return patientDto;
        }
        return null;
    }

    @Transactional
    public boolean change(PatientDto patientDto){
        PatientEntity updateEntity = patientRepository.findByPatientid(patientDto.getPatientid());
        if(patientDto.getPatientid()>0){
            updateEntity.setAddress(patientDto.getAddress());
            updateEntity.setPhone(patientDto.getPhone());
            return true;
        }
        return false;
    }

    @Transactional
    public boolean remove(int patientid){
        reservationRepository.deleteByPatientEntity_Patientid(patientid);
        patientRepository.deleteById(patientid);
        return true;
    }
}

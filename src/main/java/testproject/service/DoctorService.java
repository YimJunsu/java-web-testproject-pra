package testproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import testproject.model.dto.DoctorDto;
import testproject.model.entity.DoctorEntity;
import testproject.model.repository.DoctorRepositoy;
import testproject.model.repository.ReservationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired private DoctorRepositoy doctorRepositoy;
    @Autowired private ReservationRepository reservationRepository;

    public boolean upload(DoctorDto doctorDto){
        DoctorEntity doctorEntity = doctorDto.toEntity();
        DoctorEntity save = doctorRepositoy.save(doctorEntity);
        if(save.getDoctorid()>0){
            return true;
        }else {
            System.out.println("등록실패(의사)");
            return false;
        }
    }
    public List<DoctorDto> viewAll(){
        List<DoctorEntity> doctorEntityList = doctorRepositoy.findAll();
        List<DoctorDto> doctorDtoList = new ArrayList<>();
        doctorEntityList.forEach(obj->{
            doctorDtoList.add(obj.toDto());
        });
        return doctorDtoList;
    }
    public DoctorDto view(int doctorid){
        Optional<DoctorEntity> optional = doctorRepositoy.findById(doctorid);
        if(optional.isPresent()){
            DoctorEntity doctorEntity = optional.get();
            DoctorDto doctorDto = doctorEntity.toDto();
            return doctorDto;
        }
        return null;
    }
    @Transactional
    public boolean change(DoctorDto doctorDto){
        DoctorEntity updateEntity = doctorRepositoy.findByDoctorid((doctorDto.getDoctorid()));
        if(doctorDto.getDoctorid()>0){
            updateEntity.setName(doctorDto.getName());
            updateEntity.setSpecialty(doctorDto.getSpecialty());
            return true;
        }
        return false;
    }
    public boolean remove(int doctorid){
        reservationRepository.deleteByDoctorEntity_Doctorid(doctorid);
        doctorRepositoy.deleteById(doctorid);
        return true;
    }
}

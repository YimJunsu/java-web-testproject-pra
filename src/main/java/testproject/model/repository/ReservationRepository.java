package testproject.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import testproject.model.entity.ReservaitonEntity;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservaitonEntity, Integer> {

    ReservaitonEntity findByReservationid(int reservationid);

    List<ReservaitonEntity> findByDoctorEntity_Doctorid(int doctorid);
    List<ReservaitonEntity> findByPatientEntity_Patientid(int patientid);

    void deleteByPatientEntity_Patientid(int patientid);
    void deleteByDoctorEntity_Doctorid(int doctorid);
}

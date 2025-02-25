package testproject.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import testproject.model.entity.ReservaitonEntity;

@Repository
public interface ReservationRepository extends JpaRepository<ReservaitonEntity, Integer> {

    ReservaitonEntity findByReservationid(int reservationid);

    void deleteByPatientEntity_Patientid(int patientid);
    void deleteByDoctorEntity_Doctorid(int doctorid);
}

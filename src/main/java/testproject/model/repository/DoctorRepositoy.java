package testproject.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import testproject.model.entity.DoctorEntity;

@Repository
public interface DoctorRepositoy extends JpaRepository<DoctorEntity,Integer> {
    DoctorEntity findByDoctorid(int doctorid);
}

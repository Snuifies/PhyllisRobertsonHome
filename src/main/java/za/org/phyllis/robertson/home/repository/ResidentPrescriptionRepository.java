package za.org.phyllis.robertson.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import za.org.phyllis.robertson.home.entity.ResidentPrescription;

import java.util.List;

public interface ResidentPrescriptionRepository  extends JpaRepository<ResidentPrescription, Long> {

    @Query(value = "select t from ResidentPrescription t join t.resident r where r.idNumber = :idNumber")
    public List<ResidentPrescription> findByResidentIdNumber(@Param("idNumber") String idNumber);

}

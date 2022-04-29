package za.org.phyllis.robertson.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.org.phyllis.robertson.home.entity.Resident;
import za.org.phyllis.robertson.home.entity.Role;

import java.util.Optional;

/**
 * @author snuif
 */
public interface ResidentRepository extends JpaRepository<Resident, Long> {

    public Optional<Resident> findByIdNumber(String idNumber);

    public Optional<Resident> findByNickName(String nickName);
}

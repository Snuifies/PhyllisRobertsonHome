package za.org.phyllis.robertson.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.org.phyllis.robertson.home.entity.ResidentMeal;

@Repository
public interface ResidentMealRepository extends JpaRepository<ResidentMeal, Long> {

}

package coffee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coffee.model.Drink;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long> {

}

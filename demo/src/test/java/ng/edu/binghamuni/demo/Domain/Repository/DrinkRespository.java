package ng.edu.binghamuni.demo.Domain.Repository;

import ng.edu.binghamuni.demo.Domain.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface DrinkRespository extends JpaRepository<Drink, Long> {
}

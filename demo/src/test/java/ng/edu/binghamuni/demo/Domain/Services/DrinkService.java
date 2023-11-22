package ng.edu.binghamuni.demo.Domain.Services;

import ng.edu.binghamuni.demo.Domain.Drink;
import java.util.List;

public interface DrinkService {
    Drink saveDrink(Drink drink);
    Drink getDrinkById(long id);
    List<Drink>getAllDrink();
    Drink updateDrink(long id);

    Drink updateDrink(Drink drink);

    void deleteDrink(long id);
}

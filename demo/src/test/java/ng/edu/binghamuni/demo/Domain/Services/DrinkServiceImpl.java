package ng.edu.binghamuni.demo.Domain.Services;

import ng.edu.binghamuni.demo.Domain.Drink;
import ng.edu.binghamuni.demo.Domain.Repository.DrinkRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;

@Service
public class DrinkServiceImpl implements DrinkService{

    @Autowired
    DrinkRespository drinkRespository;
    @Override
    public Drink saveDrink(Drink drink) {
        return drinkRespository.save(drink);
    }

    @Override
    public Drink getDrinkById(long id) {
        Optional<Drink> drink = drinkRespository.findById(id);

        Drink emptyDrink = null;
        if (drink.isPresent()){

            emptyDrink = drink.get();
            return emptyDrink;
        }else {
            throw new RuntimeException("Drink Not Found");
        }
    }

    @Override
    public List<Drink> getAllDrink() {
        return drinkRespository.findAll();
    }

    @Override
    public Drink updateDrink(long id) {
        return null;
    }

    @Override
    public Drink updateDrink(Drink drink) {
        Optional<Drink> optionalDrink = drinkRespository.findById(drink.getId());

        if (optionalDrink.isPresent()){
        Drink updateDrink = new Drink();
        updateDrink.setCapacity(drink.getCapacity());
        updateDrink.setColour(drink.getColour());
        updateDrink.setCompany(drink.getCompany());
        updateDrink.setName(drink.getName());
        updateDrink.setType(drink.getType());
        updateDrink.setId(drink.getId());
        updateDrink.setIngredients(drink.getIngredients());

        drinkRespository.save(updateDrink);
    }else{
        throw new RuntimeException("Drink does not exist");
    }
        return null;
    }

    @Override
    public void deleteDrink(long id) {
        drinkRespository.deleteById(id);
    }
}

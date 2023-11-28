package ng.edu.binghamuni.demo.Domain.Controller.API;


import ng.edu.binghamuni.demo.Domain.Drink;
import ng.edu.binghamuni.demo.Domain.Repository.DrinkRespository;
import ng.edu.binghamuni.demo.Domain.Services.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
public class DrinkAPIController {
    @Autowired
    DrinkRespository drinkRespository;

    @Autowired
    DrinkService drinkService;

    @RequestMapping("/drinks")
    @GetMapping("/drinks")
    public ResponseEntity<List<Drink>> getAllDrinks(){
        return ResponseEntity.ok().body(drinkRespository.findAll());
    }

    @RequestMapping("/drink/{id}")
    @GetMapping
    public ResponseEntity<Drink> getDrinkById(@PathVariable long id) {
        return ResponseEntity.ok().body(drinkService.getDrinkById(id));
    }

    @PostMapping("/drink")
    public ResponseEntity<Drink> createDrink(@RequestBody Drink drink){
        return ResponseEntity.ok().body(drinkService.saveDrink(drink));
    }

    @PutMapping("/drink/{id}")
    public ResponseEntity<Drink> updateDrink(@PathVariable long id,  @RequestBody Drink drink){
        return ResponseEntity.ok().body(drinkService.updateDrink(drink));
    }

    @DeleteMapping("/drink/{id}")
    public HttpStatus deleteDrink(@PathVariable long id){
        drinkService.deleteDrink(id);
        return HttpStatus.OK;
    }
}


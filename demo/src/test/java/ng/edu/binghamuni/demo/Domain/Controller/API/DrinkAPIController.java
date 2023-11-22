package ng.edu.binghamuni.demo.Domain.Controller.API;


import ng.edu.binghamuni.demo.Domain.Drink;
import ng.edu.binghamuni.demo.Domain.Repository.DrinkRespository;
import ng.edu.binghamuni.demo.Domain.Services.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
}

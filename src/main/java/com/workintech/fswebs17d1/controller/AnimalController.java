package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entities.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {
    private Map<Integer, Animal> animals;

    @PostConstruct
    public void init() {
        this.animals = new HashMap<>();
        animals.put(1, new Animal(1, "Maymun"));
    }


    @GetMapping("/")
    public List<Animal> getAnimalList(){
        return animals.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Animal getAnimal(@PathVariable Integer id){
        return animals.get(id);
    }

    @PostMapping("/")
    public Animal saveAnimal(@RequestBody Animal animal){
        return animals.put(animal.getId(), animal);
    }

    @PutMapping("/{id}")
    public Animal update(@PathVariable Integer id, @RequestBody Animal animal){
        this.animals.replace(id, animal);
        return this.animals.get(id);
    }

    @DeleteMapping("/{id}")
    public Animal deleteAnimal(@PathVariable Integer id){
        return animals.remove(id);
    }
}

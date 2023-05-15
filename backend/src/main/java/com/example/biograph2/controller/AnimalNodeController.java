package com.example.biograph2.controller;

import com.example.biograph2.model.AnimalNode;
import com.example.biograph2.model.AnimalNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animal-nodes")
public class AnimalNodeController {

    private final AnimalNodeService animalNodeService;

    @Autowired
    public AnimalNodeController(AnimalNodeService animalNodeService) {
        this.animalNodeService = animalNodeService;
    }

    @PostMapping
    public AnimalNode createAnimalNode(@RequestBody AnimalNode animalNode) {
        return animalNodeService.createAnimalNode(animalNode);
    }

    @GetMapping("/{id}")
    public AnimalNode getAnimalNode(@PathVariable String id) {
        return animalNodeService.getAnimalNode(id);
    }

    // Outros métodos REST para atualização, exclusão, consulta de todos os nós, etc.
}

package com.example.emploidutemps.controller;

import com.example.emploidutemps.model.Cours;
import com.example.emploidutemps.service.CoursService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cours")
public class CoursController {

    private final CoursService service;

    public CoursController(CoursService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cours> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Cours getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Cours create(@RequestBody Cours cours) {
        return service.save(cours);
    }

    @PutMapping("/{id}")
    public Cours update(@PathVariable Long id, @RequestBody Cours cours) {
        cours.setId(id);
        return service.save(cours);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

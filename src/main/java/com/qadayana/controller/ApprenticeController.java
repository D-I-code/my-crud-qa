package com.qadayana.controller;

import com.qadayana.entity.Apprentice;
import com.qadayana.repository.ApprenticeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApprenticeController {

    @Autowired
    private ApprenticeRepo apprenticeRepository;

    @PostMapping("/apprentice/{id}")
    public Apprentice saveApprentice(@RequestBody Apprentice apprentice) {
        return apprenticeRepository.save(apprentice);
    }

    @GetMapping("/apprentice/{id}")
    public Apprentice getApprentice(@PathVariable("id")String apprenticeId) {
        return apprenticeRepository.getApprenticeById(apprenticeId);
    }

    @PutMapping("/apprentice/{id}")
    public String updateApprentice(@PathVariable("id")String apprenticeId, @RequestBody Apprentice apprentice) {
        return apprenticeRepository.update(apprenticeId, apprentice);
    }

    @DeleteMapping("/apprentice/{id}")
    public String deleteApprentice(@PathVariable("id")String apprenticeId) {
        return apprenticeRepository.delete(apprenticeId);
    }
}

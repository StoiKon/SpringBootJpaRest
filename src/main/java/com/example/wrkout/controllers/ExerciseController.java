package com.example.wrkout.controllers;


import com.example.wrkout.Entities.Exercise;
import com.example.wrkout.repositories.ExceriseRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {
    private final ExceriseRepository exRepo;

    @Autowired
    public ExerciseController(ExceriseRepository exRepo) {
        this.exRepo = exRepo;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Exercise>> getExercises() {
        return ResponseEntity.ok(exRepo.findAll().stream().toList());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Exercise> get(@PathVariable Long id) {
        return ResponseEntity.ok(exRepo.findById(id).get());
    }

    @RequestMapping(value = "/new", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<?> addExercise(@RequestBody Exercise exerciseToBeAdded) {
        if (validateExercise(exerciseToBeAdded)) {
            return ResponseEntity.ok(exRepo.save(exerciseToBeAdded));
        }
        return ResponseEntity.badRequest().body("bad object input");
    }

    private boolean validateExercise(Exercise ex) {
        return ex != null && ex.getName() != null && !ex.getName().equals("");// && ex.getDate()!=null;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Exercise> deleteExercise(@RequestBody Exercise exerciseToBeDeleted) {
        exRepo.deleteById(exerciseToBeDeleted.getId());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Exercise> deleteExerciseById(@PathVariable Long id) {
        exRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

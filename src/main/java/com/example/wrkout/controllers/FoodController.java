package com.example.wrkout.controllers;



import com.example.wrkout.Entities.Food;
import com.example.wrkout.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/food")
public class FoodController {
    private final FoodRepository foodRepo;
    @Autowired
    public FoodController(FoodRepository foodRepo) {
        this.foodRepo = foodRepo;
    }

    
    
    @GetMapping("/all")
    public ResponseEntity<Iterable<Food>> getFoods(){
        return ResponseEntity.ok(foodRepo.findAll());
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Food> get(@PathVariable Long id){
        return ResponseEntity.ok(foodRepo.findById(id).get());
    }
    @RequestMapping(value="/new",method = {RequestMethod.POST,RequestMethod.PUT})
    public ResponseEntity<?> addFood(@RequestBody Food foodToBeAdded) {
        if(validateExercise(foodToBeAdded)){
            return ResponseEntity.ok(foodRepo.save(foodToBeAdded));
        }
        return ResponseEntity.badRequest().body("bad object input");
    }
    private boolean validateExercise(Food ex){
        return ex!=null && ex.getName()!=null && !ex.getName().equals("");
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Food> deleteExercise(@RequestBody Food foodToBeDeleted){
        foodRepo.delete(foodToBeDeleted);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Food> deleteExerciseById(@PathVariable Long id){
        foodRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

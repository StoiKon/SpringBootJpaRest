package com.example.wrkout.Entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.boot.registry.selector.spi.StrategyCreator;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
@Entity
@NoArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @CreatedDate
    private LocalDate date;
    private String name;
    private int calories;

    public Food(LocalDate date, String name, int calories) {
        this.date = date;
        this.name = name;
        this.calories = calories;
    }
    public Food( String name, int calories) {
        this.name = name;
        this.calories = calories;
    }
    @PrePersist
    void onCreate(){
        this.setDate(LocalDate.now());
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "Food{" +
                "date=" + date +
                ", name='" + name + '\'' +
                ", calories=" + calories +
                '}';
    }
}

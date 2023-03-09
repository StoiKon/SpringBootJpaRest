package com.example.wrkout.Entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @CreatedDate
    private LocalDate date;
    private String name;
    private int totalreps;
    private int sets;

    public Exercise(Long id, LocalDate date, String name, int totalreps, int sets) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.totalreps = totalreps;
        this.sets = sets;
    }

    public Exercise(LocalDate date, String name, int totalreps, int sets) {
        this.date = date;
        this.name = name;
        this.totalreps = totalreps;
        this.sets = sets;
    }

    public Exercise( String name, int totalreps, int sets) {

        this.name = name;
        this.totalreps = totalreps;
        this.sets = sets;
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

    public int getTotalreps() {
        return totalreps;
    }

    public void setTotalreps(int totalreps) {
        this.totalreps = totalreps;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "date=" + date +
                ", name='" + name + '\'' +
                ", totalreps=" + totalreps +
                ", sets=" + sets +
                '}';
    }

    public Long getId() {
        return id;
    }
}

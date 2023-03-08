package com.example.wrkout.repositories;


import com.example.wrkout.Entities.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
@Repository
public interface ExceriseRepository extends JpaRepository<Exercise, Long> {

}

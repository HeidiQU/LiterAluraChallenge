package com.heidiquinones.LiterAluraChallenge.repository;

import com.heidiquinones.LiterAluraChallenge.modelos.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrosRepository extends JpaRepository<Libro,Long> {
}

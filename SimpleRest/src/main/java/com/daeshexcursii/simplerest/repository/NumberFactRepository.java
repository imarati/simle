package com.daeshexcursii.simplerest.repository;

import com.daeshexcursii.simplerest.model.NumberFact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NumberFactRepository extends JpaRepository<NumberFact, Long> {
    Optional<NumberFact> findByNumber(int number);
}

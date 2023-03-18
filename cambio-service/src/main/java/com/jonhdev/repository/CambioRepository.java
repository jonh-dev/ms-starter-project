package com.jonhdev.repository;

import com.jonhdev.entities.Cambio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CambioRepository extends JpaRepository<Cambio, Long> {

        Cambio findByFromAndTo(String from, String to);
}

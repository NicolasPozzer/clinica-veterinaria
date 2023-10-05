package com.ejercicio2.clinicaveterinaria.repository;

import com.ejercicio2.clinicaveterinaria.model.Duenio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDuenioRepository extends JpaRepository<Duenio, Long> {
}

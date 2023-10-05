package com.ejercicio2.clinicaveterinaria.repository;

import com.ejercicio2.clinicaveterinaria.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMascotaRepository extends JpaRepository<Mascota, Long> {
}

package com.ejercicio2.clinicaveterinaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Duenio {

    @Id
    private Long id_duenio;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int dni;
    private String nombre;
    private String apellido;
    private int celular;

    public Duenio() {
    }

    public Duenio(Long id_duenio, int dni, String nombre, String apellido, int celular) {
        this.id_duenio = id_duenio;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
    }
}

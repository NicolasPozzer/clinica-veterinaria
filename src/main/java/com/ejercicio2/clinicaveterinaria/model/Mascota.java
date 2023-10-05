package com.ejercicio2.clinicaveterinaria.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Mascota {

    @Id
    private Long id;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nombre;
    private String especie;
    private String raza;
    private String color;
    @OneToOne
    @JoinColumn(name = "un_duenio_id_duenio",
            referencedColumnName = "id_duenio")
    private Duenio unDuenio;

    public Mascota() {
    }

    public Mascota(Long id, String nombre, String especie, String raza, String color, Duenio unDuenio) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.color = color;
        this.unDuenio = unDuenio;
    }
}

package com.ejercicio2.clinicaveterinaria.dto;

import com.ejercicio2.clinicaveterinaria.model.Duenio;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MascotaDuenioDTO {

    private String nombreMascota;
    private String nombreEspecie;
    private String nombreRaza;
    private String nombre_duenio;
    private String apellido_duenio;

    public MascotaDuenioDTO() {
    }

    public MascotaDuenioDTO(String nombreMascota, String nombreEspecie,
                            String nombreRaza, String nombre_duenio,
                            String apellido_duenio) {

        this.nombreMascota = nombreMascota;
        this.nombreEspecie = nombreEspecie;
        this.nombreRaza = nombreRaza;
        this.nombre_duenio = nombre_duenio;
        this.apellido_duenio = apellido_duenio;
    }
}

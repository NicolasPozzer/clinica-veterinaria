package com.ejercicio2.clinicaveterinaria.controller;

import com.ejercicio2.clinicaveterinaria.model.Duenio;
import com.ejercicio2.clinicaveterinaria.service.IDuenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DuenioController {

    @Autowired //Primero de todo Hacemos que el Controller llame -> Service
    private IDuenioService duenServ;

    /*EndPoints*/


    /*EndPoints*/
    @PostMapping    ("/duenios/crear")
    public String saveDuenio (@RequestBody Duenio duenio){
        duenServ.saveDuenio(duenio);

        return "La mascota fue agregada correctamente";
    }

}

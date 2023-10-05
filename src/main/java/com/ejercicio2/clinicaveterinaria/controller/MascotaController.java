package com.ejercicio2.clinicaveterinaria.controller;

import com.ejercicio2.clinicaveterinaria.dto.MascotaDuenioDTO;
import com.ejercicio2.clinicaveterinaria.model.Mascota;
import com.ejercicio2.clinicaveterinaria.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MascotaController {

    @Autowired //Primero de todo Hacemos que el Controller llame -> Service
    private IMascotaService mascoServ;

    /*Declaramos cada uno de los EndPoints de mi CRUD*/
    @GetMapping("/mascotas/traer")/*<- esto que va del url se llama path*/
    public List<Mascota> getMascotas(){
        return mascoServ.getMascotas();
    }

    @PostMapping("/mascotas/crear")
    public String saveMascota(@RequestBody Mascota masco){/*Usamos @RequestBody ya que la */
        mascoServ.saveMascota(masco);                  /*persona a crear llega mediante JSON*/
        return "La Mascota fue creada correctamente";
    }

    @DeleteMapping("/mascotas/borrar/{id}")
    public String deleteMascota(@PathVariable Long id){
        mascoServ.deleteMascota(id);
        return "la mascota fue eliminada correctamente";
    }

    //4-Obtener los datos de la mascota y su duenio utilizando DTO
    @GetMapping ("/mascotas/datos/{id}")
    public MascotaDuenioDTO mascoDuenDTO (@PathVariable Long id) {
        return mascoServ.mascoDuenDTO(id);

    }




    //5-Obtener todos las Mascotas que sean Perros y de Raza "Caniche"
    /*==================================================
     * =======================DTO========================
     * ==================================================*/
    @GetMapping ("/mascotas/caniches")
    public List<Mascota> getCaniches () {
        return mascoServ.getCaniches();

    }

    @PutMapping ("/mascotas/editar/{idOriginal}")/*requiered es si necesita!
    osea si hay un cambio de id va a mostrar por la url*/
    public Mascota editMascota(@PathVariable Long idOriginal,
                               @RequestParam(required = false,
                                       name = "id")Long idNueva,
                               @RequestParam(required = false,
                                       name = "nombre")String nuevoNombre,
                               @RequestParam(required = false,
                                       name = "especie")String nuevoEspecie,
                               @RequestParam(required = false,
                                       name = "raza")String nuevaRaza,
                               @RequestParam(required = false,
                                       name = "raza")String nuevoColor){

        mascoServ.editMascota(idOriginal, idNueva,nuevoNombre,
                nuevoEspecie, nuevaRaza, nuevoColor);


        Mascota masco = mascoServ.findMascota(idNueva);
        return masco;
    }

    /*Asignar una mascota a una persona*/
    /*Este obtiene el body de el editar persona
     * y asigna una mascota a la persona*/

    /*CODIGO EN POSTMAN PARA ASIGNAR*/
    /*
        Hay que completar con los datos verdaderos de una persona
        existente para poder asignarle una mascota, ej:
    {
          "id": 2,
          "nombre" : "Matias",
          "apellido" : "Rodriguez",
           "edad" : 26,
           "unaMascota" : {
                "id_mascota": 52
            }
        }*/

    @PutMapping ("/mascotas/editar")
    public Mascota editMascota(@RequestBody Mascota masc){
        mascoServ.editMascota(masc);

        return mascoServ.findMascota(masc.getId());
    }

}

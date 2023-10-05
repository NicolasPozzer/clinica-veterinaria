package com.ejercicio2.clinicaveterinaria.service;

import com.ejercicio2.clinicaveterinaria.model.Duenio;

import java.util.List;

public interface IDuenioService {

    /*==============================================================
    *           Declaramos todos los metodos CRUD Abstactos
    *           ya que es una interfaz y Siempre van
    *           metodos abstractos!
    ================================================================*/


    /*Metodo para traer a todas las personas */
    //Lectura
    public List<Duenio> getDuenios();

    /*Metodo para el alta - recibe una persona y la guarda*/
    /*Alta*/
    public void saveDuenio(Duenio duen);

    /*Baja*/
    public void deleteDuenio(Long id_duenio);

    /*Lectura de un solo objeto - osea busca un solo objeto*/
    public Duenio findDuenio(Long id_duenio);


    /*Modificacion - PUT*/  //Declaramos idOriginal para buscar a la persona
    //* y otros parametros en el caso de cambiar la id
    public void editDuenio(Long idOriginal, Long id_nueva,
                            int nuevoDNI, String nuevoNombre,
                            String nuevoApellido, int nuevoCelular);



}



package com.ejercicio2.clinicaveterinaria.service;

import com.ejercicio2.clinicaveterinaria.model.Duenio;
import com.ejercicio2.clinicaveterinaria.model.Mascota;
import com.ejercicio2.clinicaveterinaria.repository.IDuenioRepository;
import com.ejercicio2.clinicaveterinaria.repository.IMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuenioService implements IDuenioService{

    /*Inyeccion de dependencia a mano!*/
    @Autowired
    private IDuenioRepository repoDuenio;

    @Override
    public List<Duenio> getDuenios() {
        /*Obtener la lista de todas las personas y
        retornarlas al controller cuando haga la consulta*/
        List<Duenio> listaDuenios = repoDuenio.findAll();

        return listaDuenios;
    }

    @Override
    public void saveDuenio(Duenio duen) {
        //Alta de persona
        repoDuenio.save(duen);
    }

    @Override
    public void deleteDuenio(Long id_duenio) {
        repoDuenio.deleteById(id_duenio);
    }

    @Override
    public Duenio findDuenio(Long id_duenio) {
        /*Hay que crear el objeto ya que como tiene
         * return devuelve algo*/
        //Si no encuentra a la persona devuelve null
        Duenio duen = repoDuenio.findById(id_duenio).orElse(null);
        return duen;
    }

    @Override
    public void editDuenio(Long idOriginal, Long id_nueva,
                           int nuevoDNI, String nuevoNombre,
                           String nuevoApellido, int nuevoCelular) {

        //Busco el objeto original primero
        /*Usamos this. ya que de esta clase
         * usamos el metodo findPersona de arriba*/
        Duenio duen = this.findDuenio(idOriginal);

        duen.setId_duenio(id_nueva);
        duen.setDni(nuevoDNI);
        duen.setNombre(nuevoNombre);
        duen.setApellido(nuevoApellido);
        duen.setCelular(nuevoCelular);

        /*guardar los cambios (para esto usamos la funcion
         * que ya tenemos arriba-> savePersona)*/
        this.saveDuenio(duen);

    }
}

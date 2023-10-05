package com.ejercicio2.clinicaveterinaria.service;

import com.ejercicio2.clinicaveterinaria.dto.MascotaDuenioDTO;
import com.ejercicio2.clinicaveterinaria.model.Mascota;
import com.ejercicio2.clinicaveterinaria.repository.IMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MascotaService implements IMascotaService {

    /*Inyeccion de dependencia a mano!*/
    @Autowired
    private IMascotaRepository repoMasco;

    @Override
    public List<Mascota> getMascotas() {
        /*Obtener la lista de todas las personas y
        retornarlas al controller cuando haga la consulta*/
        List<Mascota> listaMascotas = repoMasco.findAll();

        return listaMascotas;
    }

    @Override
    public void saveMascota(Mascota masco) {
        //Alta de persona
        repoMasco.save(masco);
    }

    @Override
    public void deleteMascota(Long id) {
        repoMasco.deleteById(id);
    }

    @Override
    public Mascota findMascota(Long id) {
        /*Hay que crear el objeto ya que como tiene
         * return devuelve algo*/
        //Si no encuentra a la persona devuelve null
        Mascota masco = repoMasco.findById(id).orElse(null);
        return masco;
    }

    @Override
    public void editMascota(Long idOriginal, Long idNueva,
                            String nuevoNombre, String nuevaEspecie,
                            String nuevaRaza, String nuevoColor) {

        //Busco el objeto original primero
        /*Usamos this. ya que de esta clase
         * usamos el metodo findPersona de arriba*/
        Mascota masco = this.findMascota(idOriginal);

        masco.setId(idNueva);
        masco.setNombre(nuevoNombre);
        masco.setEspecie(nuevaEspecie);
        masco.setRaza(nuevaRaza);
        masco.setColor(nuevoColor);

        /*guardar los cambios (para esto usamos la funcion
         * que ya tenemos arriba-> savePersona)*/
        this.saveMascota(masco);

    }

    @Override
    public void editMascota(Mascota masc) {
        this.saveMascota(masc);
    }

    @Override
    public List<Mascota> getCaniches() {
        String especie = "Perro";
        String caniche = "Caniche";
        String textoComparar;
        String textoCompararCaniche;

        List<Mascota> listaMascotas = this.getMascotas();
        List<Mascota> listaCaniches = new ArrayList<Mascota>();

        for (Mascota masco : listaMascotas) {
            //Variables locales
            textoComparar = masco.getEspecie();
            textoCompararCaniche = masco.getRaza();

            //Comparacion true o false para cada variable:
            boolean contieneEspecie = textoComparar.contains(especie);
            boolean contieneCaniche = textoCompararCaniche.contains(caniche);

            //Pregunta si hay caniches  y agrega a listaCaniches
            if (contieneEspecie == true && contieneCaniche == true) {
                listaCaniches.add(masco);
            }
        }
        return listaCaniches;
    }


    /*==================================================
    * =======================DTO========================
    * ==================================================*/
    @Override
    public MascotaDuenioDTO mascoDuenDTO(Long id) {
        MascotaDuenioDTO mascoDuenDTO = new MascotaDuenioDTO ();
        Mascota masco = this.findMascota(id);
        mascoDuenDTO.setNombreMascota(masco.getNombre());
        mascoDuenDTO.setNombreEspecie(masco.getEspecie());
        mascoDuenDTO.setNombreRaza(masco.getRaza());
        mascoDuenDTO.setNombre_duenio(masco.getUnDuenio().getNombre());
        mascoDuenDTO.setApellido_duenio(masco.getUnDuenio().getApellido());

        return mascoDuenDTO;
    }
}

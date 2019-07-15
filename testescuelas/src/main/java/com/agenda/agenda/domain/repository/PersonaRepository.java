package com.agenda.agenda.domain.repository;


import com.agenda.agenda.domain.Persona;
import com.agenda.agenda.response.PersonaResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona, String> {
    void save(PersonaResponse persona);

    Persona findByNombre(String nombre);

    Persona findByNombreAndEdad(String nombre, Integer edad);

    List<Persona> findAll();

    Persona findByNombreAndPassword(String name, String password);

    Persona findById(Long id);

    //Persona findByNombreAndPasswordAndIsTeacher(String , String );
}

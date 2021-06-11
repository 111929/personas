package com.example.proyecto.persona.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.proyecto.persona.bo.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Long> {
	
	@Query(value="from Persona p where p.nroDocumento like %:dni%")
	public Persona findNroDocumento(@Param("dni") String dni);
	
}

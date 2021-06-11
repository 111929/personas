package com.example.proyecto.persona.service;

import java.util.List;

import com.example.proyecto.persona.bo.Persona;
import com.example.proyecto.persona.rest.Usuario;

public interface PersonaService   {
	public Persona buscarPersonaPorId(Long id);
	public Long altaPersona(Persona persona);	
	public void borrarPersona(Long idpersona);
	public void actualizar(Persona persona);
	public Persona buscarPorDni(String dni);
	public Usuario buscarUsuarioPorDni(String dni);
 }

package com.example.proyecto.persona.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.proyecto.persona.bo.Persona;

import com.example.proyecto.persona.repository.PersonaRepository;
import com.example.proyecto.persona.rest.Usuario;
@Service
@Transactional
public class PersonaServiceImp implements PersonaService{

	@Autowired
	private PersonaRepository personaRepository;
	@Value("${key.usuario}")
	private String url;
	@Autowired
	private RestTemplate usuarioTem;
	
	public Persona buscarPersonaPorId(Long id) {
		
		return personaRepository.findById(id).get();
	}

	@Override
	public Long altaPersona(Persona persona) {
		personaRepository.save(persona);
		return persona.getId();
	}

	@Override
	public void borrarPersona(Long idpersona) {
		personaRepository.deleteById(idpersona);
		
	}

	@Override
	public void actualizar(Persona persona) {
		personaRepository.save(persona);
		
	}

	@Override
	public Persona buscarPorDni(String dni) {
	
		return personaRepository.findNroDocumento(dni);
	}

	public Usuario buscarUsuarioPorDni(String dni) {
		Usuario usuario= usuarioTem.getForObject(this.url+dni , Usuario.class);
		return usuario;
	}
	
	

}

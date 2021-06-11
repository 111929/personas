package com.example.proyecto.persona.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.proyecto.persona.bo.Persona;

import com.example.proyecto.persona.service.PersonaService;

@RestController
@RequestMapping(value="/persona")
	public class PersonaRestController {
	
   @Autowired 
   private PersonaService personaService;
   
   @GetMapping
   public ResponseEntity<PersonaDTO> recuperarPersonaPorId(@RequestParam Long id){
	   Persona persona= personaService.buscarPersonaPorId(id);//este es mas largo
	   PersonaDTO personaDTO= new PersonaDTO(persona);
	   return ResponseEntity.ok(personaDTO);   	  
   }  
   @PostMapping
   public ResponseEntity<PersonaDTO> altaProyecto(@Validated @RequestBody PersonaDTO persona){
	   Persona nuevaPersona= new Persona();
	   try {		   
		   nuevaPersona.setNombre(persona.getNombre());
		   nuevaPersona.setApellido(persona.getApellido());
		   nuevaPersona.setSexo(persona.getSexo());
		   nuevaPersona.setNroDocumento(persona.getNroDocumento());
		 
		   personaService.altaPersona(nuevaPersona);		   
		   return ResponseEntity.status(HttpStatus.CREATED).body(new PersonaDTO(nuevaPersona));
	   }catch(Exception e) {
		   throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage(),e);
	   }
   }
   @PutMapping
   public ResponseEntity<PersonaDTO> actualizarPersona(@RequestParam Long id) {
    	Persona persona= personaService.buscarPersonaPorId(id);
    	Usuario usuario= personaService.buscarUsuarioPorDni(persona.getNroDocumento());
    	persona.setNivelUsuario(usuario.getNivelUsuario());
    	persona.setUserID(usuario.getUserId());
    	persona.setProyecto(usuario.getProyecto());
    	personaService.actualizar(persona);
    	return ResponseEntity.ok(new PersonaDTO(persona));
    	//aqui se sumaran los datos pasados de otra api a mi persona con el id que pase a postman antes creado;
    }
   @DeleteMapping
   public ResponseEntity borrarPersona(@RequestParam Long id) {
    	personaService.borrarPersona(id);
    	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
   @GetMapping(path="/dni")
   public ResponseEntity<PersonaDTO> buscarPorDni(@RequestParam String nroDocumento){
    	//este se resume mejor.
    	PersonaDTO persona= new PersonaDTO(personaService.buscarPorDni(nroDocumento));
    	return ResponseEntity.ok(persona);
    }   
}

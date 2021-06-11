package com.example.proyecto.persona.rest;

import java.util.Date;

import com.example.proyecto.persona.bo.Persona;

  public class PersonaDTO {
    private Long idPersona;
	private String nombre;
	private String apellido;
	private String nroDocumento;
    private String sexo;
    private String userId;
    private String nivelUsuario;
    private String proyecto;
		
	public PersonaDTO() {
		
	}

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public PersonaDTO(Persona persona) {
		this.idPersona=persona.getId();
		this.nombre = persona.getNombre();
		this.apellido = persona.getApellido();
		this.nroDocumento = persona.getNroDocumento();
		this.sexo=persona.getSexo();		
		this.nivelUsuario=persona.getNivelUsuario();
		this.userId=persona.getUserID();
		this.proyecto=persona.getProyecto();
	}

	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNivelUsuario() {
		return nivelUsuario;
	}

	public void setNivelUsuario(String nivelUsuario) {
		this.nivelUsuario = nivelUsuario;
	}

	public String getProyecto() {
		return proyecto;
	}

	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getNroDocumento() {
		return nroDocumento;
	}
	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	
	
	
}

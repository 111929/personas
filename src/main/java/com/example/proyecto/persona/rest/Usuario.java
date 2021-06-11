package com.example.proyecto.persona.rest;



public class Usuario {

	private String userId;
	private String nivelUsuario;
	private String proyecto;
	
	
	public Usuario() {
		
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
		
}

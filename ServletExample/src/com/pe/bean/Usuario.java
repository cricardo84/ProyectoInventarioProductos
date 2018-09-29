package com.pe.bean;

public class Usuario {
	
	private long id;
	private String nombre;
	private String apellidos;
	private String usuario;
	private String contraseña;
	
	public long getId(){
		return id;
	}
	public void setId(long id) {
		this.id=id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos=apellidos;
	}
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario=usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña=contraseña;
	}

}

package com.pe.service;

import com.pe.bean.Usuario;

public interface UsuarioService {
	
	void registrarUsuario(Usuario usuario) throws Exception;
	boolean validarUsuario(String usuario, String contraseña) throws Exception;

}

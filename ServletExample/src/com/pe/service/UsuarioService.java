package com.pe.service;

import com.pe.bean.Usuario;

public interface UsuarioService {
	
	void registrarUsuario(Usuario usuario) throws Exception;
	boolean validarUsuario(Usuario usuario) throws Exception;
	/*int nivelUsuario(Usuario usuario) throws Exception;*/

}

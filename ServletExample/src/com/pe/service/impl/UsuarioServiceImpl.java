package com.pe.service.impl;

import com.pe.bean.Usuario;
import com.pe.db.util.DataBaseConnection;
import com.pe.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {
	
	@Override
	public void registrarUsuario(Usuario usuario) throws Exception{
		try {
			DataBaseConnection db = new DataBaseConnection();
			db.registroUsuario(usuario);
		} catch(Exception e) {
			throw e;
		}
	}
	
	public boolean validarUsuario(String usuario, String contrase�a) throws Exception {
		try {
			DataBaseConnection db = new DataBaseConnection();
			db.autenticacion(usuario, contrase�a);
			return true;
		} catch(Exception e) {
			throw e;
		}
	}

}

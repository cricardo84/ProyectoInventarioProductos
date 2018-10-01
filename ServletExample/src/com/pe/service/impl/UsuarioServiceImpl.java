package com.pe.service.impl;

import com.pe.bean.Usuario;
import com.pe.db.util.DataBaseConnection;
import com.pe.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {
	
	@Override
	public void registrarUsuario(Usuario usuario) throws Exception{
			DataBaseConnection db = new DataBaseConnection();
			db.registroUsuario(usuario);
	}
	
	public boolean validarUsuario(Usuario usuario) throws Exception {
			DataBaseConnection db = new DataBaseConnection();
			return db.autenticacion(usuario);		
	}

}

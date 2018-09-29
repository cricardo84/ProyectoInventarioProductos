package com.pe.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pe.bean.Usuario;
import com.pe.service.UsuarioService;
import com.pe.service.impl.UsuarioServiceImpl;


@WebServlet("/registroUsuario")
public class RegistroUsuarioServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String nombreUsuario = (String)request.getParameter("nombreUsuario");
			String apellidosUsuario = (String)request.getParameter("apellidosUsuario");
			String usuarioUsuario = (String)request.getParameter("usuarioUsuario");
			String contraseñaUsuario = (String)request.getParameter("contraseñaUsuario");
			
			Usuario usuario = new Usuario();
			usuario.setNombre(nombreUsuario);
			usuario.setApellidos(apellidosUsuario);
			usuario.setUsuario(usuarioUsuario);
			usuario.setContraseña(contraseñaUsuario);
			
			UsuarioService usuarioService = new UsuarioServiceImpl();
			usuarioService.registrarUsuario(usuario);
			
			response.sendRedirect("index.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

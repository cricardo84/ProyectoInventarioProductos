package com.pe.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pe.bean.Usuario;
import com.pe.service.ProductoService;
import com.pe.service.UsuarioService;
import com.pe.service.impl.ProductoServiceImpl;
import com.pe.service.impl.UsuarioServiceImpl;

@WebServlet("/validarUsuario")
public class ValidarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			String usuario = (String)request.getParameter("usuario");
			String contraseña = (String)request.getParameter("contraseña");
			
			Usuario usuarios = new Usuario();
			usuarios.setUsuario(usuario);
			usuarios.setContraseña(contraseña);
			
			UsuarioService usuarioService = new UsuarioServiceImpl();
			boolean validacion = usuarioService.validarUsuario(usuarios);
			
			HttpSession sesion = request.getSession();
			
			if (validacion) {
				
				sesion.setAttribute("usuario", usuario);
				sesion.setMaxInactiveInterval(2*60);
				ProductoService productoService = new ProductoServiceImpl();
				request.setAttribute("productosActivos", productoService.obtenerProductosActivos());
				request.getRequestDispatcher("index.jsp").forward(request, response);							
			
			}else {
				String error = "La cuenta ingresada no existe";
				request.setAttribute("mensajeError", error);
				request.getRequestDispatcher("/validarUsuario.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}

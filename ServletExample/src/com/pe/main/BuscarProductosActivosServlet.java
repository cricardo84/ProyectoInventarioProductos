package com.pe.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pe.service.ProductoService;
import com.pe.service.impl.ProductoServiceImpl;

@WebServlet("/buscarProductosActivos")
public class BuscarProductosActivosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			ProductoService productoService = new ProductoServiceImpl();
			request.setAttribute("productosActivos", productoService.obtenerProductosActivos());
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (Exception e) {
			
		}
		
	}


}

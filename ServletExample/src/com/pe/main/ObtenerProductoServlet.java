package com.pe.main;

import java.awt.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pe.bean.Producto;
import com.pe.service.ProductoService;
import com.pe.service.impl.ProductoServiceImpl;

@WebServlet("/obtenerProducto")
public class ObtenerProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			ProductoService productoService = new ProductoServiceImpl();
			Producto producto = productoService.obtenerProducto(Integer.parseInt(request.getParameter("id")));
			
			request.setAttribute("producto", producto);
			request.getRequestDispatcher("editarProducto.jsp").forward(request, response);
			
		} catch (Exception e) {

		}
		
		
	}

}

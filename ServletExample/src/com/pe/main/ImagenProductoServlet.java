package com.pe.main;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pe.bean.Producto;
import com.pe.service.ProductoService;
import com.pe.service.impl.ProductoServiceImpl;

/**
 * Servlet implementation class ImagenProductoServlet
 */
@WebServlet("/obtenerImagen")
public class ImagenProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int productoId = Integer.parseInt(request.getParameter("id"));
			
			ProductoService productoService = new ProductoServiceImpl();
			Producto producto = productoService.obtenerProducto(productoId);
			
			response.setContentType("image/gif");
			OutputStream outputStream = response.getOutputStream();
			outputStream.write(producto.getImagen());
			outputStream.flush();
			outputStream.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

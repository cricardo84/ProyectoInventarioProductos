package com.pe.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pe.bean.Producto;
import com.pe.service.ProductoService;
import com.pe.service.impl.ProductoServiceImpl;

@WebServlet("/registroProducto")
public class RegistroProductoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//Obtener informacion del formulario
			String nombreProducto = (String)request.getParameter("nombreProducto");
			String descripcionProducto = (String)request.getParameter("descripcionProducto");
			String cantidadProducto = (String)request.getParameter("cantidadProducto");
			String imagenProducto = (String)request.getParameter("imagenProducto");

			//Setear informacion del formulario en un Bean
			Producto producto = new Producto();
			producto.setNombre(nombreProducto);
			producto.setDescripcion(descripcionProducto);
			producto.setCantidad(Integer.parseInt(cantidadProducto));
			producto.setImagen(imagenProducto.getBytes());
		
			//Registrar el producto
			ProductoService productoService = new ProductoServiceImpl();
			productoService.registrarProducto(producto);
			
			//Mostrar la pagina inicial
			response.sendRedirect("index.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

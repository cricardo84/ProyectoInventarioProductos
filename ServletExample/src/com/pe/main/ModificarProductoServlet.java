package com.pe.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pe.bean.Producto;
import com.pe.service.ProductoService;
import com.pe.service.impl.ProductoServiceImpl;

@WebServlet("/modificarProducto")
public class ModificarProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String idProducto = (String)request.getParameter("idProducto");
			String nombreProducto = (String)request.getParameter("newNombre");
			String descripcionProducto = (String)request.getParameter("newDescripcion");
			String cantidadProducto = (String)request.getParameter("newCantidad");
			
			Producto producto = new Producto();
			producto.setId(Long.parseLong(idProducto));
			producto.setNombre(nombreProducto);
			producto.setDescripcion(descripcionProducto);
			producto.setCantidad(Integer.parseInt(cantidadProducto));
			
			ProductoService productoService = new ProductoServiceImpl();
			productoService.modificarProducto(producto);
			
			List<Producto> listadoProductos= productoService.buscarProductos();
			request.setAttribute("listadoProductos", listadoProductos);
			request.getRequestDispatcher("buscar.jsp").forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}

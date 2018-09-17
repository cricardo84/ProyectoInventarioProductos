package com.pe.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pe.bean.Producto;
import com.pe.service.ProductoService;
import com.pe.service.impl.ProductoServiceImpl;

@WebServlet("/buscarProducto")
public class BuscarProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			//Se instancia la clase que implementa la interface
			ProductoService productoService = new ProductoServiceImpl();
			
			//Devuelve un listado de elementos Producto
			List<Producto> listadoProductos = productoService.buscarProductos();
			
			//Cargo al request y le asigno un nombre 
			request.setAttribute("listadoProductos", listadoProductos);
			//Para direccionar al jsp
			request.getRequestDispatcher("buscar.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

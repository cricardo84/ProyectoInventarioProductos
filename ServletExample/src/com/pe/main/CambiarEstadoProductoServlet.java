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

@WebServlet("/cambiarEstadoDelProducto")
public class CambiarEstadoProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String productoId = (String)request.getParameter("id");
			
			ProductoService productoService = new ProductoServiceImpl();
			
			//Actualizar el estado del producto
			productoService.cambiarEstadoProduto(Integer.parseInt(productoId));
			
			//Obtener listado de productos actualizado
			List<Producto> listadoProductos = productoService.buscarProductos();
			request.setAttribute("listadoProductos", listadoProductos);
			request.getRequestDispatcher("buscar.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

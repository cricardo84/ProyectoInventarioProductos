package com.pe.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

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
			//String nombreProducto = (String)request.getParameter("nombreProducto");
			//String descripcionProducto = (String)request.getParameter("descripcionProducto");
			//String cantidadProducto = (String)request.getParameter("cantidadProducto");
						
			//Setear informacion del formulario en un Bean
			Producto producto = new Producto();
			//producto.setNombre(nombreProducto);
			//producto.setDescripcion(descripcionProducto);
			//producto.setCantidad(Integer.parseInt(cantidadProducto));
			
			//Setear la imagen al Producto
			FileItemFactory itemFactory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(itemFactory);
			List<FileItem> items = upload.parseRequest(new ServletRequestContext(request));
			
			for(FileItem item : items){
				
				
				
				if(item.getFieldName().equals("nombreProducto")){
					producto.setNombre(new String(item.get()));
				}else if(item.getFieldName().equals("descripcionProducto")){
					producto.setDescripcion(new String(item.get()));
				}else if(item.getFieldName().equals("cantidadProducto")){
					producto.setCantidad(Integer.parseInt(new String(item.get())));
				}else if(item.getFieldName().equals("imagenProducto")){
					String contentType = item.getContentType();
					if(contentType != null){
						if(contentType.equals("image/png") || 
								   contentType.equals("image/jpg") ||
								   contentType.equals("image/jpeg")){
									
							producto.setImagen(item.get());
									
						}
					}
				}
			}
		
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

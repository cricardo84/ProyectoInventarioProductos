<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.pe.bean.Producto"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="principal/componentes/head.jsp" %>
<link href="principal/css2/bootstrap.min.css">
<title>Buscar Productos</title>
</head>
<body>
	
<%@ include file="principal/componentes/navegacion.jsp" %>
<br>
	<div class="container">
		<h2 style="text-align:center;">Listado de productos</h2>
		<br>
		<table class="table table-bordered">
			<tr>
				<th class="text-center">ID</th>
				<th class="text-center">NOMBRE</th>
				<th class="text-center">DESCRIPCIÓN</th>
				<th class="text-center">CANTIDAD</th>
				<th class="text-center">ACCIONES</th>
			</tr>  
			<% List<Producto> listadoProducto = (ArrayList<Producto>)request.getAttribute("listadoProductos");
				 for(Producto producto : listadoProducto){ %>
			<tr>
				<td class="text-center"><%= producto.getId() %></td>
				<td class="text-center"><%= producto.getNombre() %></td>
				<td class="text-center"><%= producto.getDescripcion() %></td>
				<td class="text-center"><%= producto.getCantidad() %></td>
				<td class="text-center">
					<a href="#" class="btn btn-warning btn-sm">Editar</a>
					<a class="btn btn-danger btn-sm">Eliminar</a>
				</td>
			</tr>
			<%
			}
			%>
			
		</table>
		<br>
	</div>

<%@ include file="principal/componentes/footer.jsp" %>
<%@ include file="principal/componentes/scripts.jsp" %>

</body>
</html>
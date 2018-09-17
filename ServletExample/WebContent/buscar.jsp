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
<title>Buscar Productos</title>
</head>
<body>
	
<%@ include file="principal/componentes/navegacion.jsp" %>

	<div>
		<h2>Listado de productos</h2>
		<table>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Descripción</th>
				<th>Cantidad</th>
			</tr>  
			<% List<Producto> listadoProducto = (ArrayList<Producto>)request.getAttribute("listadoProductos");
				for(Producto producto : listadoProducto){ %>
			<tr>
				<td><%= producto.getId() %></td>
				<td><%= producto.getNombre() %></td>
				<td><%= producto.getDescripcion() %></td>
				<td><%= producto.getCantidad() %></td>
			</tr>
			<%
			}
			%>
			
		</table>
	</div>

<%@ include file="principal/componentes/footer.jsp" %>
<%@ include file="principal/componentes/scripts.jsp" %>

</body>
</html>
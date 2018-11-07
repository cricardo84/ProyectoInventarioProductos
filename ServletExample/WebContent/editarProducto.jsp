<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.pe.bean.Producto"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="principal/componentes/head.jsp" %>
<link rel="stylesheet" type="text/css" href="principal/css/formulario.css">
<title>Modificar Producto</title>
</head>
<body>

<%@ include file="principal/componentes/navegacion.jsp" %>

<div class="container" style="text-align: right;">
	<p style="color:#A4A4A4;">Bienvenido: <%= request.getSession().getAttribute("usuario") %></p>
	<a href="/ServletExample/CerrarSesionServlet">Cerrar Sesión</a>
</div>

<form action="modificarProducto"  method="post" class="form-register">
	<h2 class="form-titulo">Modificar Producto</h2>
	
	<div class="contenedor-inputs">
	
	<% Producto producto = (Producto)request.getAttribute("producto"); %>

		<input value=<%= producto.getId() %> name="idProducto" type="hidden"/>
		<input value=<%= producto.getNombre() %> type="text" name="newNombre" placeholder="Nombre" class="input-100" required/>
		<input value=<%= producto.getDescripcion() %> type="text" name="newDescripcion" placeholder="Descripción" class="input-100" required/>
		<input value=<%= producto.getCantidad() %> type="text" name="newCantidad" placeholder="Cantidad" class="input-100" required/>
		<input type="submit" value="Actualizar" class="btn-enviar"/>

	</div>
</form>

<%@ include file="principal/componentes/footer.jsp" %>
<%@ include file="principal/componentes/scripts.jsp" %>

</body>
</html>
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
<title>Editar Producto</title>
</head>

<body>

<h2 style="text-align:center;">Información de producto seleccionado</h2>
	<br>
	<form action="modificarProducto"  method="post" class="form-register">
	
	<% Producto producto = new Producto(); %>
	
	<div class="contenedor-inputs">

		<input type="text" readonly="" name="id" class="input-100" values="<%= producto.getId() %>"/>
		<input type="text" name="nombreProducto" placeholder="Nombre" class="input-100" values="<%= producto.getNombre() %>" required/>
		<input type="text" name="descripcionProducto" placeholder="Descripción" class="input-100" values="<%= producto.getDescripcion() %>" required/>
		<input type="text" name="cantidadProducto" placeholder="Cantidad" class="input-100"  values="<%= producto.getCantidad() %>" required/>
		<input type="file" name="imagenProducto" values="<%= producto.getImagen()%>"/>
		<input type="submit" value="Modificar" class="btn-enviar"/>

</body>
</html>
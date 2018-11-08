<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="principal/componentes/head.jsp" %>
<link rel="stylesheet" type="text/css" href="principal/css/formulario.css">
<title>Registro de producto</title>
</head>
<body>

<%@ include file="principal/componentes/navegacion.jsp" %>

<div class="container" style="text-align: right;">
	<p style="color:#A4A4A4;">Bienvenido: <%= request.getSession().getAttribute("usuario") %></p>
	<a href="/ServletExample/CerrarSesionServlet">Cerrar Sesión</a>
</div>

<form action="registroProducto"  method="post" class="form-register" enctype="multipart/form-data">
	<h2 class="form-titulo">Ingresar Producto</h2>
	
	<div class="contenedor-inputs">

		<input type="text" name="nombreProducto" placeholder="Nombre" class="input-100" required/>
		<input type="text" name="descripcionProducto" placeholder="Descripción" class="input-100" required/>
		<input type="text" name="cantidadProducto" placeholder="Cantidad" class="input-100" required/>
		<input type="file" name="imagenProducto" required/>
		<input type="submit" value="Enviar" class="btn-enviar"/>

	</div>
</form>

<%@ include file="principal/componentes/footer.jsp" %>
<%@ include file="principal/componentes/scripts.jsp" %>

</body>
</html>
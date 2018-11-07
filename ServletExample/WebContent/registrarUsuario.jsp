<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="principal/componentes/head.jsp" %>
<link rel="stylesheet" type="text/css" href="principal/css/formulario.css">
<title>Registro de Usuario</title>

</head>

<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="index.jsp">Megos Ventas</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
       </div>
</nav>

	<form action="registroUsuario" method="post" class="form-register">
		<h2 class="form-titulo">Registrar Usuario</h2>
	
		<div class="contenedor-inputs">
	
			<input type="text" name="nombreUsuario" placeholder="Nombre" class="input-100" required>
			<input type="text" name="apellidosUsuario" placeholder="Apellidos" class="input-100" required>
			<input type="text" name="usuarioUsuario" placeholder="Usuario" class="input-100" required>
			<input type="password" name="contraseñaUsuario" placeholder="Contraseña" class="input-100" required>
	
			<input type="submit" value="Registrar" class="btn-enviar">
	
		</div>
	
	</form>

<%@ include file="principal/componentes/footer.jsp" %>
<%@ include file="principal/componentes/scripts.jsp" %>

</body>
</html>
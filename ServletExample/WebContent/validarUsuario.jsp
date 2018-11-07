<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="javax.servlet.http.HttpServletRequest" %>
 <%@ page import="com.pe.db.util.DataBaseConnection" %>
 <%@ page session="true" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="principal/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="principal/css/estilo.css">
<title>Ingresar Usuario</title>
<script type="text/javascript">
window.onload = function () {
    if (typeof history.pushState === "function") {
        history.pushState("jibberish", null, null);
        window.onpopstate = function () {
            history.pushState('newjibberish', null, null);
            // Handle the back (or forward) buttons here
            // Will NOT handle refresh, use onbeforeunload for this.
        };
    }
    else {
        var ignoreHashChange = true;
        window.onhashchange = function () {
            if (!ignoreHashChange) {
                ignoreHashChange = true;
                window.location.hash = Math.random();
                // Detect and redirect change here
                // Works in older FF and IE9
                // * it does mess with your hash symbol (anchor?) pound sign
                // delimiter on the end of the URL
            }
            else {
                ignoreHashChange = false;   
            }
        };
    }
}
</script>

</head>

<body>

<div class="container well" id="containerLogin">

	<center><img src="principal/imagenes/usuario.png"></center>
	
<form action="validarUsuario" method="post" id="formularioLogin">
  <div class="form-group">
    <input type="text" name="usuario" class="form-control" id="exampleInputEmail1" placeholder="Usuario">
  </div>
  <div class="form-group">
    <input type="password" name="contraseña" class="form-control" id="exampleInputPassword1" placeholder="Contraseña">
  </div>
  
    <label>
      <input type="checkbox"> Recordar cuenta <a href="registrarUsuario.jsp">Aún no tienes una cuenta?</a>
      <p style="color:red; text-align:center;"> <% if(request.getAttribute("mensajeError")!=null) out.println(request.getAttribute("mensajeError"));%></p>
    </label>
    <button type="submit" name="btnIngresar" class="btn btn-primary" id="botonLogin">Ingresar</button>

</form>
</div>

</body>
</html>
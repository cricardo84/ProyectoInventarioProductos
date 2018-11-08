<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page session="true" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="principal/componentes/head.jsp" %>
<%@ page session="true" %>
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
<title>Megos Ventas</title>
</head>
<body style="background: #204862;">

<%@ include file="principal/componentes/navegacion.jsp" %>
<div class="container" style="text-align: right;">
	<p style="color:#A4A4A4;">Bienvenido: <%= request.getSession().getAttribute("usuario") %></p>
	<a href="/ServletExample/CerrarSesionServlet">Cerrar Sesión</a>
</div>


<%@ include file="principal/componentes/paginacontenido.jsp" %>
<%@ include file="principal/componentes/footer.jsp" %>
<%@ include file="principal/componentes/scripts.jsp" %>

</body>
</html>
<%@ page import="com.pe.bean.Producto"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>


    <div class="container">

      <div class="row">

        <div class="col-lg-3">

          <h1 class="my-4">Género:</h1>
          <div class="list-group">
            <a href="#CategoriaHombre" class="list-group-item">Hombre</a>
            <a href="#CategoriaMujer" class="list-group-item">Mujer</a>
            <a href="#CategoriaNiños" class="list-group-item">Niños</a>
          </div>

        </div>

        <div class="col-lg-9">

          <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
            <ol class="carousel-indicators">
              <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
              <div class="carousel-item active">
                <img class="d-block img-fluid" src="principal/imagenes/img1.jpg" alt="First slide">
              </div>
              <div class="carousel-item">
                <img class="d-block img-fluid" src="principal/imagenes/img2.jpg" alt="Second slide">
              </div>
              <div class="carousel-item">
                <img class="d-block img-fluid" src="principal/imagenes/img3.jpg" alt="Third slide">
              </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="sr-only">Next</span>
            </a>
          </div>
          
         </div>
         
        </div>
          
          <% List<Producto> listadoProducto = (ArrayList<Producto>)request.getAttribute("productosActivos");
          		for(Producto producto : listadoProducto){%>

          <div style="margin: auto; margin-top:60px; margin-bottom:25px; width:100%; height:1500px;">

            <div style="width: 250px; height: 450px; border: 1pz solid black; padding-right: 25px; padding-top:20px; display: inline-block; float: left;">
              <div class="card h-100">
                <img style="width: 100%; height:40%;" src="obtenerImagen?id=<%=producto.getId()%>">
                <div class="card-body">
                  <h4 class="card-title" style="text-align: center;">
                    <p style="#2E64FE;"><%= producto.getNombre() %></p>
                  </h4>
                  <h5>Cantidad: <%= producto.getCantidad() %></h5>
                  <p class="card-text"><%= producto.getDescripcion() %></p>
                </div>
                <div class="card-footer">
                  <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                </div>
              </div>
            </div>
              <%
          		}
              %>
   
         </div>
         
              <footer class="py-5 bg-dark">
        		<p class="m-0 text-center text-white">Copyright &copy; Your Website 2018</p>
 	 		  </footer>
    </div>
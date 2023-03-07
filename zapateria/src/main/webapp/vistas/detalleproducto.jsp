<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalle producto</title>
</head>
<body>
<div class="container">	
	<jsp:include page="menu.jsp"/>
	<div class="row">	
		<div class="col-10">
			<div class="page-header m-4">
		    	<h1>Detalle producto</h1>
		  	</div>
		  	<div class="row">
	     	  <ul class="list-group m-4">
	     	  	<li class="list-group-item">
		     	  	<h2>
		      			${producto.nombre}
		      		</h2>
				</li>
			    <li class="list-group-item"><b>Descripción:</b> ${producto.descripcion}</li>
			    <li class="list-group-item"><b>Precio:</b> ${producto.precio}€</li>
			    <li class="list-group-item"><b>Stock:</b> ${producto.stock}</li>
			    <li class="list-group-item"><b>ID:</b> ${producto.idProducto}</li>
			  </ul>
			</div>	
		</div>	
		<div class="col-2">
			<jsp:include page="carrito.jsp"/>
		</div>
	</div>
</div>
</body>
</html>




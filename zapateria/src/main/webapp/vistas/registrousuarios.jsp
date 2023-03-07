<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrarse</title>

</head>
<body>
<div class="container">	
	<jsp:include page="menu.jsp"/>
	<div class="row">	
		<div class="col-10">
			<div class="page-header m-4">
		    	<h1>${mensaje}</h1>
		  	</div>
		  	<div class="row">
			<form action="/usuarios/alta/${action}" method="post" class="m-auto" style="width:500px">
			  <div class="form-group">
			    <label for="nombre">Nombre:</label>
			    <input type="text" placeholder="Nombre" name="nombre" class="form-control" >
			  </div>
			  <div class="form-group">
			    <label for="apellido">Apellido:</label>
			    <input type="text" placeholder="Apellido" name="apellido" class="form-control">
			  </div>
			  <div class="form-group">
			    <label for="password">Contraseña:</label>
			    <input type="password" placeholder="Contraseña" name="password" class="form-control">
			  </div>
			  <div class="form-group">
			    <label for="email">Email:</label>
			    <input type="email" placeholder="email" name="email" class="form-control">
			  </div>
			  <div class="form-group">
			    <label for="telefono">Teléfono:</label>
			    <input type="tel" placeholder="teléfono" name="telefono" class="form-control">
			  </div>
			  <button type="submit" class="btn btn-primary">Registrarse</button>
			</form>
			</div>	
		</div>	
		<div class="col-2">
			<jsp:include page="carrito.jsp"/>
		</div>
	</div>
</div>

</body>
</html>
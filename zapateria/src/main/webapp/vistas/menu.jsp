<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menú de inicio</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<sec:authentication property="name"/>
<sec:authorize access="hasAuthority('Administrador')">Eres ADMON</sec:authorize>
<sec:authorize access="hasAuthority('Cliente')">Eres Cliente</sec:authorize>
<a class="nav-link" href="/logout">Cerrar Sesión</a>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
			<li><a class="nav-link"
				href="/logout">Cerrar Sesión</a></li>
			<li><a href="/inicio/">Iniciar Sesión</a></li>
			<li><a href="/productos/todos">Productos</a></li>
			<li><a href="/">Registrar Tarjeta</a></li>
			<li><a href="/">Registrar Dirección</a></li>
			<li><a href="/usuarios/registro/cliente">Resgistrar Nuevo Cliente</a></li>
			<li><a href="/usuarios/registro/administrador">Resgistrar Nuevo Administrador</a></li>
		</ul>
	</div>
	
	
	
	
	
	
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="/">A Dar Zapatilla</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav" >
    <ul class="navbar-nav">
      		<li class="nav-item"><a href="/productos/todos" class="nav-link btn btn-outline-info">Catálogo</a></li>
      		<li class="nav-item"><a href="/usuarios/registro/cliente" class="nav-link btn btn-outline-info">Resgistrase</a></li>
      		<li class="nav-item"><a href="/usuarios/registro/administrador" class="nav-link btn btn-outline-info">Registrar Nuevo Administrador</a></li> 
   			<sec:authorize access="hasAuthority('Administrador')">
				<li class="nav-item"><a href="/inicio/" class="nav-link btn btn-outline-info">Iniciar Sesión</a></li>
				<li class="nav-item"><a href="/logout" class="nav-link btn btn-outline-info">Cerrar Sesión</a></li>
				<!-- esto debería ser para el cliente con condicion de access="isAuthenticated()" -->
				<li class="nav-item"><a href="/" class="nav-link btn btn-outline-info">Registrar Tarjeta</a></li>
				<li class="nav-item"><a href="/" class="nav-link btn btn-outline-info">Registrar Dirección</a></li>
				
				  
       		</sec:authorize>   
    </ul>  
  </div>
</nav>
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>
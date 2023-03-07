<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menú de inicio</title>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>

<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <!-- Brand -->
    <a class="navbar-brand" href="/">A Dar Zapatilla</a>
  <!-- Toggler/collapsibe Button -->
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <!-- Navbar links -->
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      		<li class="nav-item"><a href="/productos/todos" class="nav-link">Catálogo</a></li>
      		<li class="nav-item"><a href="/usuarios/registro/cliente" class="nav-link">Resgistrase</a></li>
      		<li class="nav-item"><a href="/usuarios/registro/administrador" class="nav-link">Registrar Nuevo Administrador</a></li> 
   			<sec:authorize access="hasAuthority('Administrador')">
				<li class="nav-item"><a href="/inicio/" class="nav-link">Iniciar Sesión</a></li>
				<li class="nav-item"><a href="/logout" class="nav-link">Cerrar Sesión</a></li>
				<!-- esto debería ser para el cliente con condicion de access="isAuthenticated()" -->
				<li class="nav-item"><a href="/" class="nav-link">Registrar Tarjeta</a></li>
				<li class="nav-item"><a href="/" class="nav-link">Registrar Dirección</a></li>  
       		</sec:authorize>  
    </ul>
  </div>
</nav>

<sec:authentication property="name"/>
<sec:authorize access="hasAuthority('Administrador')">Usuario ADMON</sec:authorize>
<sec:authorize access="hasAuthority('Cliente')">Usuario CLIENTE</sec:authorize>
<sec:authorize access="isAuthenticated()">
	<a class="nav-link" href="/logout">Cerrar Sesión</a>
</sec:authorize>

</body>
</html>
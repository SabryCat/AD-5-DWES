<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestión producto</title>
</head>
<body>

<h2>${mensaje}</h2>
 	<form method="post">
		<input type="text" placeholder="Nombre" name="nombre" value="${producto.nombre}">
		<input type="text" placeholder="Descripción" name="descripcion" value="${producto.descripcion}">
		<input type="number" placeholder="Precio" name="precio" step=".01" value="${producto.precio}">
		<input type="text" placeholder="Categoría" name="categoria" value="${producto.categoria}">
		<input type="number" placeholder="Stock" name="stock" value="${producto.stock}">
		<input type="submit" value="Enviar"/>
	</form>
	<h2>${info}</h2>
		<h2><a href="/productos/todos">Volver</a></h2>
</body>
</html>
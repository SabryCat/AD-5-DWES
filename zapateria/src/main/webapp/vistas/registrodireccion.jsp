<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nueva direcci�n</title>
</head>
<body>
	<h1>Registre nueva direcci�n</h1>
		<form action="" method="post">
				<input type="text" placeholder="C�digo postal" name="cp">
				<input type="text" placeholder="Localidad" name="localidad">
				<input type="text" placeholder="Calle" name="calle">
				<input type="number" placeholder="N�mero" name="numero">
				<input type="submit" value="Enviar"/>
		</form>
	
	<h2>${mensaje}</h2>
	<h2><a href="/menu">Volver</a></h2>
</body>
</html>
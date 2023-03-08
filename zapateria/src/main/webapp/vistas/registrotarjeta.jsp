<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Registre nueva tarjeta</h1>
		<form action="" method="post">
				<input type="text" placeholder="Titular" name="titular">
				<input type="number" placeholder="Número tarjeta" name="numero" min="1" max="99999999">
				<input type="submit" value="Enviar"/>
		</form>
	<h2><a href="/menu">Volver</a></h2>
</body>
</html>
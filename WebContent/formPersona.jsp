<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Personas formulario</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<h2>Formulario persona</h2>
	<form method="post" action="personas">
		
		<input type="text" name="txtNombre" placeholder="Nombre" class="form-control">
		<br>
		<input type="text" name="txtEdad" placeholder="Edad" class="form-control">
		<br>
		<input type="text" name="txtCarrera" placeholder="Carrera" class="form-control">
		<br>
		<input type="submit" value="Ingresar datos" class="btn btn-success">
	</form>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>
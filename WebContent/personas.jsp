<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Personas</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Id persona</th>
				<th>Nombre</th>
				<th>Edad</th>
				<th>Carrera</th>
				<th>Fecha</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="persona" items="${listPersona}">
			<tr>
				<td>${persona.getIdPersona()}</td>
				<td>${persona.getNombre()}</td>
				<td>${persona.getEdad()}</td>
				<td>${persona.getCarrera()}</td>
				<td>${persona.getFecha()}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>


	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>
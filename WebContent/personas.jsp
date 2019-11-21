<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Personas </title>
</head>
<body>
	<c:forEach var="persona" items="${listPersona}">
	<div>
		<h4>${persona.getIdPersona()}</h4>
		<p>${persona.getNombre()}</p>
		<p>${persona.getEdad()}</p>
		<p>${persona.getCarrera()}</p>
		<p>${persona.getFecha()}</p>
	</div>
		
	</c:forEach>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenue client !</title>
</head>
<body>
	<a href ="form.html"> faire virement</a>
	<h1>Liste des clients</h1>
	<div>
		<c:forEach var="client" items="${clients}">
		<div class ="client">
		<h2>
		${client.firstname}
		<a href="delete.html?id=${client.id}"> X</a>
		</h2>
		</div>
		</c:forEach>
	</div>
	

</body>
</html>
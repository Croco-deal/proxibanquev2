<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenue client !</title>
</head>
<body style="color: #FF1493;">
	<a href ="virement.html"> faire virement</a>
	<h1>Liste des clients</h1>
	<div>
		<c:forEach var="client" items="${clients}">
		<div class="client" title="${client.id}">
		<h2>
		${client.firstname}
		<a href="editer.html?id=${client.id}"> EDITER</a>
		</h2>
		</div>
		</c:forEach>
	</div>
	

</body>
</html>
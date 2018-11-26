<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clients</title>
</head>
<body style="color: #FF1493;">
	<h1> Liste des clients :</h1>
	<div> 

		<c:forEach var ="client" items="${clients}">	
			<div class="article" title="${client.id}">
				<h2>
					${article.firstname}
				</h2>
				<p>${article.lastname}</p>
			</div>
		</c:forEach>
	</div>
</body>
</html>
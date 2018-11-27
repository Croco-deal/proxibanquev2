<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<c:forEach var="account" items="${accounts}">
			<div class="account">
				<h2>
					${account.balance} <a href="delete.html?id=${account.number}"> X</a>
				</h2>
				<p>${account.number}</p>
			</div>
		</c:forEach>
	</div>
</body>
</html>
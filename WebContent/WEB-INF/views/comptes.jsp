<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form>
		<div>
			<label for="number">Numéro de compte</label> <input id="number"
				name="number" value="${account.number}">
		</div>
		<div>
			<label for="balance">Crédit </label> <input id="balance" name="balance"
				value="${account.balance}">
		</div>

	</form>


</body>
</html>
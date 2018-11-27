<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<div>
		<form method="post" action="">
			<div>
				<label for="id_emetteur">EMETTEUR </label> <input id="id_emetteur"
					name="id_emetteur" value="${account.id_emetteur}">
			</div>
			<div>
				<label for="id_receveur">REVECEUR</label> <input id="id_receveur"
					name="id_receveur" value="${account.id_receveur}">
			</div>
			<div>
				<label for="amount">MONTANT </label> <input id="amount"
					name="amount" value="${account.amount}">
									<button>Envoyer</button>
			</div>

		</form>
	</div>
</body>
</html>
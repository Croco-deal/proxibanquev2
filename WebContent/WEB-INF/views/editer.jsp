<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EDITER</title>
</head>
<body style="color: #FF1493;">	
	<h1>Modifier Client</h1>
		<form method="post" action="">
		<fieldset>
				<legend>Modification nom</legend>
			<div>
				<label for="lastname">Nom </label>
				<input id="lastname" name="lastname">
			</div>
		</fieldset>
		<fieldset>
				<legend>Modification prénom</legend>
			<div>
				<label for="firstname">Prénom </label>
				<input id="firstname" name="firstname">
			</div>
		</fieldset>
			<fieldset>
				<legend>Modification Adresse</legend>
			<div>
				<label for="address">Adresse </label>
				<input id="address" name="address">
			</div>
		</fieldset>
			<fieldset>
				<legend>Modification email</legend>
			<div>
				<label for="email">Email </label>
				<input id="email" name="email">
			</div>
		</fieldset>

		<button>Envoyer</button>
		</form>
	</body>
</html>
		
		
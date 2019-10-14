<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pokemon Trainers</title>
</head>
<body>
	<h2>Pokemon Trainers:</h2>
	<form method = "post" action = "navigationServelt">
		<table>
			<c:forEach items = "${requestScope.allParties}" var = "currentParty">
				<tr>
					<td><input type = "radio" name = "id" value = "${currentParty.partyId}"></td>
					<td><h2>${currentParty.getTrainer().getTrainer_Name()}</h2></td>
					
				</tr>
				<c:forEach var = "pokemonVal" items = "${currentParty.pokemonParty}">
				<tr><td></td><td colspan ="3">
					Pokemon: ${pokemonVal.name} Type: ${pokemonVal.type} Level: ${pokemonVal.level} HP:${pokemonVal.hp}
					</td>
				</tr>
		</c:forEach>
			</c:forEach>
		</table>
		 <br /> <input type ="submit" value = "delete trainer" name="formAction">
	</form>
	<a href = "index.html">Go Back Home</a>
</body>
</html>
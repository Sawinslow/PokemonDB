<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Pokemon</title>
</head>
<body>
<h2>All Pokemon:</h2>

<!-- TODO: Make Edit servlet, edit/delete functionality -->
	<form method = "post" action = "navigationServelt">
		<table>
			<c:forEach items = "${requestScope.allPokemon}" var = "currentPokemon">
				<tr>
					<td><input type = "radio" name = "id" value = "${currentPokemon.id}">
					<td>Name: ${currentPokemon.name}</td>
					<td>Type: ${currentPokemon.type}</td>
					<td>Level: ${currentPokemon.level}</td>
					<td>HP: ${currentPokemon.hp}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="edit">
	</form>
</body>
</html>
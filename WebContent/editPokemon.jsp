<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit a list</title>
</head>
<body>
	<form action="editPokemonServlet" method="post">
		Pokemon Name: <input type="text" name="pokemonName"
			value="${pokemonToEdit.name}"><br /> 
			Pokemon Type: <input type="text" name="pokemonType"
			value="${pokemonToEdit.type}"><br /> 
		Pokemon Level: <input type="text" name="pokemonLevel"
			value="${pokemonToEdit.level}"><br /> 
			Pokemon Health: <input type="text" name="pokemonHealth"
			value="${pokemonToEdit.hp}"><br /> 
			<input type="submit" value="Edit Pokemon">
			<input type="hidden" name="id" value="${pokemonToEdit.id}">
	</form>
	<a href="index.html">Go add new items instead.</a>
</body>

</html>
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
			value="${ThePokemon.listName}"><br /> 
			Pokemon Type: <input type="text" name="pokemonType]"
			value="${ThePokemon.listName}"><br /> 
			 <input type="hidden" name="id" value="${ThePokemon.id}"> Current
		Pokemon Level: <input type="text" name="pokemonLevel"
			value="${ThePokemon.listName}"><br /> 
			Pokemon Health: <input type="text" name="pokemonHealth"
			value="${ThePokemon.listName}"><br /> 
	</form>
	<a href="index.html">Go add new items instead.</a>
</body>

</html>
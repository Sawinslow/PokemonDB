<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addTrainerServlet" method="post">
		Trainer Name: <input type="text" name="TrainerName"><br />
		
		Trainer Birthday: <input type="text" name="month" placeholder="mm" size="4"> <input type="text" name="day" placeholder="dd" size="4">,  <input type="text" name="year" placeholder="yyyy" size="4"> <br />
		Number of Badges: <input type="text" name="numOfbadges"><br />
		Available Pokemon:<br />
		 
		 <select name="allPokemonToAdd" multiple size="8">
			<c:forEach items="${requestScope.allPokemon}" var="currentitem">
			<tr><td></td><td colspan ="3">
				<option value="${currentitem.id}">Name: ${currentitem.name} Type: ${currentitem.type}
					Level: ${currentitem.level} HP: ${currentitem.hp}</option>
					</td>
				</tr>
			</c:forEach>
		</select> <br /> <input type="submit" value="Create Trainer">
	</form>
	<a href="index.html">Go add new items instead.</a>
</body>
</html>
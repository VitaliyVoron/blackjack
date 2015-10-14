<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html">
<html>
<head>
<title>Black</title>
</head>
<body bgcolor="yellow">
<c:out value="${message}"/>
	<form method = POST>
		<input type="number" name = "id"> <input type="number" name = "money"> 
		<button type="submit" value="Enter">Start new game</button>
	</form>
	</form>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html">
<html>
<head>
<title>Black</title>
</head>
<div align=center>
	Your balance: <c:out value="${balance}"/><br>
	Enter number of chips you want to buy: 
	<br>
	<form method=POST>
		<input type="text" name="chips">
		<input type="submit" value="Buy Chips">
	</form>	
</div>
</body>
</html>
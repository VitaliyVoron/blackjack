<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html">
<html>
<head>
<title>Black</title>
</head>
<body>
<div align=center>
	<c:out value="${message}" /><br>
	Your balance: <c:out value="${balance}"/><br>
	<c:if test="${balance > 0 }">
	<form method=POST action="start">
		<input type="submit" value="Start Game">
	</form>		
	<br>
	</c:if>
	<form method=POST action="add_money">
		<input type="submit" value="Buy Chips">
	</form>	
</div>
</body>
</html>
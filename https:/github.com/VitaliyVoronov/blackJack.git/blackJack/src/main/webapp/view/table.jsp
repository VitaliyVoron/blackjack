<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html">
<html>
<head>
<title>Black Jack</title>
</head>
<body bgcolor="yellow">
	Hello!
	<c:forEach items="${players}" var="player">
		<table>
			<tr>
				<td><c:out value="${player.number }" /> hand:</td>
				<c:forEach items="${player.cards }" var="card">
					<td><c:out value="${card.title}" /></td>
					<td><c:out value="${card.suit}" /></td>
				</c:forEach>
				<td>Money: <c:out value="${player.money }" /></td>
				<td>Point: <c:out value="${player.sumNumber }" /></td>
			</tr>
		</table>
	</c:forEach>
	<%-- <c:out value="${player.number}" />
			<c:out value="${player.money}" /> --%>
	<form method=POST action="more">
		<button type="submit" value="Enter">More</button>
	</form>
	<form method=POST action="stay">
		<button type="submit" value="Enter">Stay</button>
	</form>
</body>
</html>
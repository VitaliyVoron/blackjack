<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html">
<html>
<head>
<title>Black Jack</title>
</head>
<body>

	<div id="players" style="width: 300px; float: left">
		<table>
			<tr>
				<td><c:out value="${user.number}" /></td>
				<td><c:out value="${user.money}" /></td>
			</tr>
			<tr>
				<td><c:if test="${!inProgress}">
						Make your bet:
							<form method="post">
							<input type="text" name="bet"> <br> <input
								type="submit" value="start!">
						</form>
					</c:if> <c:if test="${inProgress}">
						<c:out
							value="${bet}" />
					</c:if></td>
			</tr>
		</table>
	</div>

	<div id="game" style="width: 500px; float: left">
			<c:forEach items="${players}" var="player">
				<table>
					<tr>
						<td><c:out value="${player.number }" /> hand:</td>
						<c:forEach items="${player.cards }" var="card">
							<td><c:out value="${card.title}" /> </td>
						</c:forEach>
						<td>Sum: <c:out value="${player.sumNumber }" /></td>
					</tr>
				</table>
			</c:forEach>
			<table>

				<tr>
					<td><c:if test="${inProgress}">
							<form method="post" action="hit">
								<input type="submit" value="hit">
							</form>
							<form method="post" action="stay">
								<input type="submit" value="stay">
							</form>
						</c:if></td>
				</tr>
			</table>
		<c:out value="${message}" />
	</div>
	
</body>
</html>
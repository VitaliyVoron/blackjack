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
			<c:out value="${player.number}" />
			<c:out value="${player.money}" />
</body>
</html>
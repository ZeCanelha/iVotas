<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>iVotas</title>
</head>
<body>

	<c:choose>
		<c:when test="${session.loggedin == true}">
			<p>Welcome, ${session.username}.</p>
		</c:when>
		<c:otherwise>
			<p>Welcome, anonymous user. Say HEY to someone.</p>
		</c:otherwise>
	</c:choose>
	
	<!-- -->
	
	<ul>
		<c:forEach items="${heyBean.allElections}" var="value">
			<li>
				
				<a href="votar.jsp?electionid=${value.value}">
					<c:out value="${value.key}" />
				</a>
			</li>
		</c:forEach>
	</ul>
	

	<p><a href="<s:url action="index" />">Start</a></p>

</body>
</html>
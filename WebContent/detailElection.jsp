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


	<c:forEach items="${heyBean.electionDetails}" var="value">
		<c:out value="${value.key}"/>
		<c:out value="${value.value}"/>
		<br>
	</c:forEach>
	
	
	<p><a href="<s:url action="pagvoto" />">Votar</a></p>
	<p><a href="<s:url action="backcliente" />">P�gina Inicial</a></p>
	
	
</body>
</html>
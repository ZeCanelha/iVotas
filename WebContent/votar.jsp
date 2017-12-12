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
	
	
	<form action="votar" method="post">
		<c:forEach items="${heyBean.electionLists}" var="value">
			<c:out value="${value.value}"/>
			<br>
		</c:forEach>
			<p>Branco</p>
			<p>Nulo</p>
		<s:text name="Opção pretendida: " />
		<s:textfield name="votevalue" /><br>
		<s:submit />
	</form>
	
	
</body>
</html>
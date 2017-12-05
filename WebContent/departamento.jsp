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
		<s:form action="createdep" method="post">
			<s:text name="Nome do departamento:" />
			<s:textfield name="depname" /><br>
			<s:text name="ID da faculdade"/>
			<s:textfield name="idfac"/><br>
			<s:submit />
		</s:form>
	

</body>
</html>
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
		<s:form action="createelection" method="post">
			<s:text name="Título" />
			<s:textfield name="title" /><br>
			<s:text name="Descrição"/>
			<s:textfield name="description"/><br>
			<s:text name="Departamento"/>
			<s:textfield name="dep"/><br>
			<s:text name="Tipo"/>
			<s:textfield name="type"/><br>
			<s:text name="Inicio"/>
			<s:textfield name="begin"/><br>
			<s:text name="Fim"/>
			<s:textfield name="end"/><br>
			<s:submit />
		</s:form>
	

</body>
</html>
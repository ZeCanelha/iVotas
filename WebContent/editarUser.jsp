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

<style>
	form {
		position: relative;
		z-index: 1;
		background: #ffffff;
		max-width: 360px;
		margin: 0 auto auto;
		padding: 35px;
		text-align: center;
		box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
	}
	
	form input {
		outline: 0;
		background: #f2f2f2;
		width: 100%;
		border: 0;
		margin: 15px 0 15px;
		padding: 15px;
		box-sizing: border-box;
	}

</style>

<body>


		<c:choose>
		<c:when test="${session.loggedin == true}">
			
			<s:form action="editaruser" method="post">
			<s:text name="ID de utilizador" />
			<s:textfield name="iduser" /><br>
			<s:text name="Nome" />
			<s:textfield name="nome" /><br>
			<s:text name="Password"/>
			<s:textfield name="password"/><br>
			<s:text name="Departamento"/>
			<s:textfield name="departamento"/><br>
			<s:text name="Telefone"/>
			<s:textfield name="telefone"/><br>
			<s:text name="Morada"/>
			<s:textfield name="morada"/><br>
			<s:text name="Numero CC"/>
			<s:textfield name="numcc"/><br>
			<s:text name="Validade CC"/>
			<s:textfield name="validadecc"/><br>
			<s:text name="Tipo"/>
			<s:textfield name="tipo"/><br>
			<s:submit />
		</s:form>
	
		</c:when>
		<c:otherwise>
			<p>Login necessário.</p>
		</c:otherwise>
	</c:choose>
		
	

</body>
</html>
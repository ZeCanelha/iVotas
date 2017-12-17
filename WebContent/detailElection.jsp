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
	#tcss {
    		font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    		border-collapse: collapse;
    		width: 100%;
	}

	#tcss td, #customers th {
	    border: 1px solid #ddd;
	    padding: 8px;
	}
	
	#tcss tr:nth-child(even){background-color: #f2f2f2;}
	
	#tcss tr:hover {background-color: #ddd;}
	
	#tcss th {
	    padding-top: 12px;
	    padding-bottom: 12px;
	    text-align: left;
	    background-color: grey;
	    color: white;
}
</style>

<body>


	<c:choose>
		<c:when test="${session.loggedin == true}">
			
			<center>
		<h1>Detalhes da eleição</h1>
	</center>
	
	<table id="tcss">
		<tr>
			<th>Número de votos válidos</th>
			<th>Título da eleiçao</th>
			<th>Descrição da eleição</th>
			<th>Número de votos em branco</th>
		</tr>
		
		<tr>
			<c:forEach items="${heyBean.electionDetails}" var="value">
			<td>
				<c:out value="${value.value}"/>
			</td>
			</c:forEach>
		</tr>
		
	</table>
	
	
	
	
	<p><a href="<s:url action="pagvoto" />">Votar</a></p>
	<p><a href="<s:url action="backcliente" />">Página Inicial</a></p>
	
		</c:when>
		<c:otherwise>
			<p>Login necessário.</p>
		</c:otherwise>
	</c:choose>

	
	
	
</body>
</html>
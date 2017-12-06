<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>iVotas!</title>
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
	
	

	<div class = "menu">
		<ul>
			<li>
				<a href ="faculdade">Criar faculdade</a>
			</li>
			<li>
				<a href ="departamento">Criar departamento</a>
			</li>
			<li>
				<a href ="eleicao">Criar eleição</a>
			</li>
			<li>
				<a href ="lista">Criar listas de candidatos</a>
			</li>
			<li>
				<a href ="registo">Registar utilizadores</a>
			</li>
			<li>
				<a href ="associar">Associar mesa de voto</a>
			</li>
			<li>
				<a href ="editarEleicao">Editar Eleição</a>
			</li>
			<li>
				<a href ="editarUtilizador">Editar utilizador</a>
			</li>
			<li>
				<a href ="gerir">Gerir membros da mesa de voto</a>
			</li>
			<li>
				<a href ="consultar">Consultar detalhes de uma eleição</a>
			</li>
			
			<li>
				<a href="consultarvoto">Consultar detalhes de voto de um utilizador</a>
			</li>
			
		</ul>
	</div>
	
	
	
	
	<p><a href="<s:url action="index" />">Start</a></p>

</body>
</html>
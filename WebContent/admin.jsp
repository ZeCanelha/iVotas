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

<style>
	ol {
	    counter-reset: li; /* Initiate a counter */
	    list-style: none; /* Remove default numbering */
	    *list-style: decimal; /* Keep using default numbering for IE6/7 */
	    font: 15px 'trebuchet MS', 'lucida sans';
	    padding: 0;
	    margin-bottom: 4em;
	    text-shadow: 0 1px 0 rgba(255,255,255,.5);
	}

	.rectangle-list a{
    position: relative;
    display: block;
    padding: .4em .4em .4em .8em;
    *padding: .4em;
    margin: .5em 0 .5em 2.5em;
    background: #ddd;
    color: #444;
    text-decoration: none;
    transition: all .3s ease-out;   
}

.rectangle-list a:hover{
    background: #eee;
}   

.rectangle-list a:before{
    content: counter(li);
    counter-increment: li;
    position: absolute; 
    left: -2.5em;
    top: 50%;
    margin-top: -1em;
    background: #fa8072;
    height: 2em;
    width: 2em;
    line-height: 2em;
    text-align: center;
    font-weight: bold;
}

.rectangle-list a:after{
    position: absolute; 
    content: '';
    border: .5em solid transparent;
    left: -1em;
    top: 50%;
    margin-top: -.5em;
    transition: all .3s ease-out;               
}

.rectangle-list a:hover:after{
    left: -.5em;
    border-left-color: #fa8072;             
}

</style>

<body>

	<c:choose>
		<c:when test="${session.loggedin == true}">
			<h1>Bem-vindo, ${session.username}.</h1>
		</c:when>
		<c:otherwise>
			<p>Welcome, anonymous user. Say HEY to someone.</p>
		</c:otherwise>
	</c:choose>
	
	

	
	<ol class="rectangle-list">
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
		
	</ol>
	
	
	<p><a href="<s:url action="index" />">Start</a></p>

</body>
</html>
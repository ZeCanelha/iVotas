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
			<p>Bem-vindo, ${session.username}.</p>
			<p>Por favor, escolha uma das seguintes eleições.</p>
			<ol class="rectangle-list">
				<c:forEach items="${heyBean.allElections}" var="value">	
					<li>
						<a href="<s:url action="escolheeleicao">
							<s:param name="electionid">${value.value}
							</s:param>
						</s:url>"><c:out value="${value.key}" /><br></a>
					</li>
						
				</c:forEach>
			</ol>
			
			<p><a href="<s:url action="associateface"/>">Associar conta ao facebook</a></p>
			
			<p>
			<a href="
			<s:url action="unassociateface"/>
			<c:set var="register" value="${true}" scope="session" />">Desassociar conta do facebook</a>
			</p>
			
			<p><a href="<s:url action="logout" />">Sair</a></p>
		</c:when>
		<c:otherwise>
			<p>Login necessário.</p>
		</c:otherwise>
	</c:choose>
	
	<!-- -->
	
	
	

</body>
</html>
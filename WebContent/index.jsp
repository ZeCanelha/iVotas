<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>iVotas</title>
</head>
<style>
	#formStyle {
		position: relative;
		z-index: 1;
		background: #ffffff;
		max-width: 360px;
		margin: 0 auto auto;
		padding: 35px;
		text-align: center;
		box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
	}
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
	<s:form id="formStyle" action="login" method="post">
		<s:text name="Id de utilizador:" />
		<s:textfield name="userid" /><br>
		<s:text name="Username:" />
		<s:textfield name="username" /><br>
		<s:text name="Password:" />
		<s:password name="password" label="Password"/><br>
		<s:submit />
	</s:form>
	
	<s:form action="facelogin" method="post">
  		<input type="image" src="http://www.pvhc.net/img48/oalmmtxqytqyhhjvmamr.png" alt="Submit">
	</s:form>
	
	
	
	
	
	
	
</body>
</html>
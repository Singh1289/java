<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <style type="text/css">
	        .errormsg {
	            color: red;
	        }
	    </style>

<title>Insert title here</title>
</head>
<body>
<div align="center">
	<h2>User Login Form</h2>
	<form:form action="loginUser" method="post" modelAttribute="user">
	
	Enter Email-Id: <form:input path="email"/>
	<small><form:errors path="email" cssClass="errormsg"></form:errors>
	
	<br><br>
	
	Enter password: <form:input path="password"/><br><br>
	<small><form:errors path="password" cssClass="errormsg"/></small>
	<form:button>Login</form:button>
	</form:form>
</div>
</body>
</html>
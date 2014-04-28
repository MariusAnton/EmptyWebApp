<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<sec:authorize access="isAnonymous()">
		<p>Login using any credentials: "test" and "test"</p>
		
		<form:form action="${pageContext.request.contextPath}/j_spring_security_check"	method="POST" commandName="login" >
	              <input id="username" name="j_username" type="text" value="" />
	              <input id="password" name="j_password" type="password" value="" />
	              <input type="submit" value="Login" />
		</form:form>
	</sec:authorize>
	
	<sec:authorize access="hasRole('USER')">
	    Now change a java class and hit refresh .... 
	    <br />
	    <a href="/jrebelbreaks/j_spring_security_logout">log out</a>
	</sec:authorize>
		
</body>
</html>
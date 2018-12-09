<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h2>Please Login</h2>
<div id="login" align="center">

	<form:form method="POST" class="form-horizontal" modelAttribute="user" action="login" align="center">	
	<div class="form-group" align="center">${message}</div>
	<div class="form-group" align="center">
		<form:label path="username" class="control-label col-xs-2">User Name:</form:label>
		<div class="col-xs-2" align="center">
			<form:input path="username" class="form-control" minlength="3" maxlength="10" required="required"/><form:errors path="username"/>
		</div>
	</div>
	<div class="form-group" align="center">
		<form:label path="password" class="control-label col-xs-2">Password:</form:label>
		<div class="col-xs-2" align="center">
			<form:input path="password" class="form-control" minlength="3" maxlength="10" required="required"/><form:errors path="password"/>
		</div>
	</div>
	<div class="form-group" align="center">
		<input type="submit" value="Login" class="btn btn-primary"/>
	</div>
	<br/>
	<form:errors path="*"/>
	</form:form>	
</div>
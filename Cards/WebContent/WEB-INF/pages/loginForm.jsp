<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	<style>
		h2{background-color:#00ffff}
		body{background-color:#00ffff}
	</style>
	<spring:url value="/resources/css/main.css" var="mainCss"/>
	<link href="${mainCss}" rel="stylesheet"/>
	<h2>Login</h2>
	<form:form method="POST" modelAttribute="user" action="login" >
		<table>
			<tr>				
				<td>${message}</td>
			</tr>
			<tr>				
				<td><form:label path="username">User Name:</form:label></td>
				<td><form:errors path="username"/></td>
				<td><form:input path="username" minlength="3" maxlength="10" required="required"/></td>
			</tr>
			<tr>
				<td><form:label path="password">Password:</form:label></td>
				<td><form:errors path="username"/></td>
				<td><form:input path="password"  minlength="3" maxlength="10" required="required" /></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" value="Login"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<a href="register">New User</a>
				</td>
			</tr>
		</table>
		<br/>
	</form:form>
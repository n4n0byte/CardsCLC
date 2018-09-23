<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

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
		</table>
		<br/>
	</form:form>
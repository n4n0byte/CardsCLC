<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

	<h2>Login</h2>
	<form:form method="POST" modelAttribute="user" action="addUser">
		<table>
			<tr>
				<td><form:label path="username">User Name:</form:label></td>
				<td><form:input path="username"/></td>
			</tr>
			<tr>
				<td><form:label path="Password">Password:</form:label></td>
				<td><form:input path="Password" type="Password"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Login"/>
				</td>
			</tr>
		</table>
		<br/>
		<form:errors path="*"/>
	</form:form>
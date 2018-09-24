<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form method="POST" modelAttribute="user" action="addUser">
<label>${registration.message}</label>>
		<table>
			<tr>
				<td><form:label path="username">User Name:</form:label></td>
				<td><form:input path="username"required minlength=3 maxlenth=10/></td>
			</tr>
			<tr>
				<td><form:label path="email">Email Address:</form:label></td>
				<td><form:input type="email"required path="email"required minlength=3 maxlenth=10/></td>
			</tr>
			<tr>
				<td><form:label path="firstName">First Name:</form:label></td>
				<td><form:input path="firstName"required minlength=3 maxlenth=10/></td>
			</tr>
			<tr>
				<td><form:label path="LastName">Last Name:</form:label></td>
				<td><form:input path="LastName"required minlength=3 maxlenth=10/></td>
			</tr>
			<tr>
				<td><form:label path="Password">Password:</form:label></td>
				<td><form:input type="password"required path="Password"required minlength=3 maxlenth=10/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Register"/>
				</td>
			</tr>
		</table>
		<br/>
		<form:errors path="*"/>
	</form:form>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<ul>
	<li><a href="/Card">Login</a></li>
</ul>

<br/>
<br/>
<br/>

<form:form method="POST" modelAttribute="user" action="register">
<div align="center" class="table responsive">	
		<table class="table">
			<tr>				
				<td>${message}</td>
			</tr>
			<tr>
				<td><form:label path="username">User Name:</form:label></td>
				<td><form:input path="username" minlength="1" maxlength="10" required="required" /></td>
			</tr>
			<tr>
				<td><form:label path="email">Email Address:</form:label></td>
				<td><form:input type="email" path="email" minlength="3" maxlength="20" required="required" /></td>
			</tr>
			<tr>
				<td><form:label path="firstName">First Name:</form:label></td>
				<td><form:input path="firstName" minlength="1" maxlength="10" required="required" /></td>
			</tr>
			<tr>
				<td><form:label path="LastName">Last Name:</form:label></td>
				<td><form:input path="lastName" minlength="1" maxlegnth="10" required="required" /></td>
			</tr>
			<tr>
				<td><form:label path="Password">Password:</form:label></td>
				<td><form:input type="password" path="password" minlength="3" maxlength="10" required="required"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Register"/>
				</td>
			</tr>
		</table>
		<br/>
		<form:errors path="*"/>
</div>		
	</form:form>

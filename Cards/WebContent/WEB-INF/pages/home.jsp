<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

	<h2>Login Response</h2>
	<table>
	<tr>
		<th><label>First Name</label></th>
		<th><label>Last Name</label></th>
	</tr>
	<tr>
		<td><label>${user.firstName}</label></td>
		<td><label>${user.lastName}</label></td>
	</tr>
	<tr>
		<td colspan="2">
			<a href="login">Log Out</a>
		</td>
	</tr>
	</table>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"    %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<h2>Login Response</h2>
	<table>
	<tr>
		<td><label> Welcome ${user.username}</label></td>
	</tr>
	<tr>
		<td colspan="2">
			<a href="/Card">Log Out</a>
		</td>
	</tr>
	</table>

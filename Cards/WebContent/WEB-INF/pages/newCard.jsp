<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<ul>
		<li><a href="/Home">Home</a></li>
		<li><a href="/diplayDecks">View Decks</a></li>
		<li><a href="/newCard">Create Cards</a></li>
		<li><a href="/displayCards">View Cards</a></li>
	</ul> <br/>
	<h2>Create New Card</h2>
	<form:form method="POST" modelAttribute="card" action="addCard">
		<table>
			<tr>
				<td><form:label path="title">Card Title:</form:label></td>
				<td><form:input path="title"/></td>
			</tr>
			<tr>
				<td><form:label path="description">Description:</form:label></td>
				<td><form:input path="description"/></td>
			</tr>
			<tr>
				<td><form:label path="health">Health:</form:label></td>
				<td><form:input path="health"/></td>
			</tr>
			<tr>
				<td><form:label path="damage">Damage:</form:label></td>
				<td><form:input path="damage"/></td>
			</tr>
			<tr>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Submit"/>
				</td>
			</tr>
		</table>
		<br/>
		<form:errors path="*"/>
	</form:form>
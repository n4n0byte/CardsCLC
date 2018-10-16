<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<ul>
	<li><a href="/Card/home">Home</a></li>
</ul>
		
<div align="center">	
	<h2>Add Card To Deck</h2>
	<form:form method="POST" modelAttribute="cardWithDeckTitle" action="/Card/addCard">
		
		<table>
			<tr>
				<td><form:label path="card.title">Title:</form:label></td>
				<td><form:errors path="card.title"/></td>								
				<td><form:input path="card.title"/></td>			
			</tr>
			<tr>
				<td><form:label path="card.description">Description:</form:label></td>
				<td><form:errors path="card.description"/></td>
				<td><form:input path="card.description"/></td>				
			</tr>
			<tr>
				<td><form:label path="card.health">Health:</form:label></td>
				<td><form:errors path="card.health"/></td>
				<td><form:input path="card.health"/></td>				
			</tr>
			<tr>
				<td><form:label path="card.damage">Damage:</form:label></td>
				<td><form:errors path="card.damage"/></td>
				<td><form:input path="card.damage"/></td>				
			</tr>			
			<tr>
				<td colspan="2">
					<input type="submit" value="Submit"/>
				</td>
			</tr>
		</table>
		<br/>
		<form:hidden path="deckTitle" />
		<form:errors path="*" />
	</form:form>
</div>
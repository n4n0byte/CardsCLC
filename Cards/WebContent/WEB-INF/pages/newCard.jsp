<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<ul>
	<li><a href="/Card/home">Home</a></li>
</ul>
		
<div align="center">	
	<h2>Add Card To Deck</h2>
	<form:form method="POST" modelAttribute="cardWithDeckTitle" action="/Card/addCard" class="form-horizontal">
	<div class="table-responsive">
		<table class="table-hover">
			<tr>
				<td><form:label path="card.title">Title:</form:label></td>
				<td><form:errors path="card.title"/></td>								
				<td><form:input path="card.title" minlength="3" maxlength="10" required="required"/></td>			
			</tr>
			<tr>
				<td><form:label path="card.description">Description:</form:label></td>
				<td><form:errors path="card.description"/></td>
				<td><form:input path="card.description" minlength="3" maxlength="10" required="required"/></td>				
			</tr>
			<tr>
				<td><form:label path="card.health">Health:</form:label></td>
				<td><form:errors path="card.health"/></td>
				<td><form:input path="card.health" type="number" min="0" max="9999" required="required"/></td>				
			</tr>
			<tr>
				<td><form:label path="card.damage">Damage:</form:label></td>
				<td><form:errors path="card.damage"/></td>
				<td><form:input path="card.damage" type="number" min="0" max="9999" required="required" /></td>				
			</tr>			
			<tr>
				<td colspan="2">
					<input type="submit" value="Submit"/>
				</td>
			</tr>
		</table>
	</div>
		<br/>
		<form:hidden path="deckTitle" />
		<form:errors path="*" />
	</form:form>
</div>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"    %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	
	<ul>
		<li><a href="/Card/home">Home</a></li>
		<li><a href="/Card/diplayDecks">View Decks</a></li>
		<li><a href="/Card/newCard">Create Cards</a></li>
		<li><a href="/Card/displayCards">View Cards</a></li>
	</ul>
	<br/>

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
	<h3>List of Decks</h3>
	<table>
		<tr>
			<th><label>Title</label></th>
			<th><label>Description</label></th>
			<th><label>Add Card</label></th>
		</tr>
		<c:forEach var="deck" items="${decks}">
			<tr>
				<td><label>${deck.title}</label></td>
				
				<td><label>${deck.description}</label></td>
				<td>
					<label><a href="newCard/${deck.title}">Add</a></label>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="2">
				<a href="/Card/newDeck">Add a Deck</a>
			</td>
		</tr>
	</table>

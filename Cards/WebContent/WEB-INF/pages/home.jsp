<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<ul>
	<li><a href="/Card">Log Out</a></li>
	<li><a href="/Card/updateDeck">Update</a></li>
</ul>

<br/>

<div align="center">
	<h2>Welcome ${user.username}</h2>
	<h3>List of Decks</h3>
	<table>
		<tr>
			<th><label>Title</label></th>
			<th><label>Description</label></th>
			<th><label>Add Card</label></th>
		</tr>
		<c:forEach var="deck" items="${decks}">
			<tr>
				<td><label><a href="/Card/displayDeck/${deck.deckId}">${deck.title}</a></label></td>
				<td><label>${deck.description}</label></td>
				<td>
					<label><a href="/Card/newCard/${deck.title}">Add</a></label>
				</td>
				<td>
					<label><a href="/Card/deleteDeck/${deck.title}">Delete</a></label>
				</td>
				<td>
					<label><a href="/Card/updateDeck/${deck.title}">Update</a></label>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="2">
				<a href="/Card/newDeck">Add a Deck</a>
			</td>
		</tr>
	</table>
</div>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"    %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	
	<ul>
		<li><a href="/home">Home</a></li>
		<li><a href="/diplayDecks">View Decks</a></li>
		<li><a href="/newCard">Create Cards</a></li>
		<li><a href="/displayCards">View Cards</a></li>
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
			<th><label>Cards</label></th>
		</tr>
		<c:forEach var="deck" items="${decks}">
			<tr>
				<td><label>${decks.title}</label></td>
				<td><label>${decks.description}</label></td>
				<c:forEach var="card" items="${decks}">
					<td><label>${decks.cards}</label><td>
				</c:forEach>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="2">
			<a href="add">Add a User</a>
			</td>
		</tr>
	</table>
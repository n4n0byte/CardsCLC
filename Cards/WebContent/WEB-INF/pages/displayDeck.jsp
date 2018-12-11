<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<nav class="navbar navbar-default">
		
	<div class="navbar-header">
		
		<button data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
			<span class="sr-only">Toggle</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="/Card">Card CLC</a>
				
	</div>
	
	<div id="navbarCollapse" class="collapse navbar-collapse">
				
    	<ul class="nav navbar-nav">
      		<li><a href="/Card/home">Home</a></li>      		
	    </ul>
	</div>
</nav>


<div class="container">
<h2>List of Cards in Deck: ${deck.title} </h2>
	<div class="table-hover table-responsive">

	<table class="table panel panel-default">
		<tr>
			<th><label>Title</label></th>
			<th><label>Description</label></th>
			<th><label>Damage</label></th>
			<th><label>Health</label></th>
		</tr>
		<c:forEach var="card" items="${deck.cards}">
			<tr>
				<td><label>${card.title}</label></td>
				<td><label>${card.description}</label></td>
				<td><label>${card.damage}</label></td>
				<td><label>${card.health}</label></td>
			</tr>
		</c:forEach>
	</table>
</div>
</div>
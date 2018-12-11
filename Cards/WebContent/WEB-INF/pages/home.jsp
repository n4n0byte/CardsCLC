<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	
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


<script type="text/javascript">

	// wait until page is ready
	$(function() {
	
		// initialize hidden confirmation dialog
		$('#deleteConfirmation').dialog({
			modal: true,
			width: 300,
			height: 200,
			autoOpen: false
		})		
				
		// assign click eventhandler in delete to confirmation dialog
		$('.delete').click(function(event) {
			
			// bind this to current item
			var currentItem = $(this)
			
			// add buttons to dialog 
			$('#deleteConfirmation').dialog('option','buttons',[
				{
					text: "Ok",
					click: function(){
						// go to delete link with deck id
						var deckTitle = currentItem.find("input").attr("value");
						window.location.href = "/Card/deleteDeck/" + deckTitle;
					},
				},
				{
					text: "Cancel",
					click: function(){
						// close dialog
						$("#deleteConfirmation").dialog("close");
					},
				}
			
			])
			$("#deleteConfirmation").html("Are You Sure?").dialog();
			$("#deleteConfirmation").dialog("open");
			
		})
		
	})
	
</script>			


<div class="container">
	
	<div id="deleteConfirmation"></div>
	<div class="panel panel-default">
			
	<h2>Welcome ${user.username}</h2>
	<h3>List of Decks</h3>
	
	
	<div class="table-hover table-responsive">
		<table class="table">
		
		<tr>
			<th><label>Title</label></th>
			<th><label>Description</label></th>
			<th><label>Add Card</label></th>
			<th><label>Delete Card</label></th>
			<th><label>Update Deck</label></th>
			
		</tr>
		
		<c:forEach var="deck" items="${decks}">
			
			<tr>
				
				<td class="col-xs-3">
					<label><a href="/Card/displayDeck/${deck.deckId}">${deck.title}</a></label>
				</td>
				<td><label>${deck.description}</label></td>
				<td>
					<label><a href="/Card/newCard/${deck.title}">Add</a></label>
				</td>
				<td>
					<label class="delete">
						<input type="hidden" class="name" name="x" value="${deck.title}"> 
						<a href="#" >Delete</a>
					</label>
				</td>
				<td>
					<label><a href="/Card/updateDeck/${deck.title}">Update</a></label>
				</td>
			</tr>
		</c:forEach>
	</table>
		
	</div>
	<div class="col-offset-sm-3 col-sm-12">
		<a href="/Card/newDeck"><button>Add a Deck</button></a>		
	</div>
</div>
	
</div>
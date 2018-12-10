<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	

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
		
<ul>
	<li><a href="/Card">Log Out</a></li>
</ul>


	
<br/>


<div align="center">
	<h2>Welcome ${user.username}</h2>
	<h3>List of Decks</h3>
	<div id="deleteConfirmation"></div>
	
	
	
	<table>
		<tr>
			<th><label>Title</label></th>
			<th><label>Description</label></th>
			<th><label>Add Card</label></th>
		</tr>
		<c:forEach var="deck" items="${decks}">
			
			<tr>
				
				<td>
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
		<tr>
			<td colspan="2">
				<a href="/Card/newDeck">Add a Deck</a>
			</td>
		</tr>
	</table>
</div>
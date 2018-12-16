<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
      		<li><a href="/Card/register">Register</a></li>      		
	    </ul>
	</div>
</nav>


<div id="login">
	
	<div class="container">
	
	<form:form method="POST" class="panel panel-default margin col-sm-offset-4 col-sm-4 form-horizontal"  modelAttribute="user" action="login">	
	
		<h2>Login</h2>
		<script>
		
		$(function() {
			if ("${msg}" !== ""){
				// Some error notification
				$("body").overhang({
				  type: "error",
				  message: "You could not be logged in at this time.",
				  closeConfirm: "true"
				});
			}
			
		})

		</script>
		
		<div id="loginForm" class="form-group">
			
			<div class="col-sm-12">
				<form:input  path="username" placeholder="Username" class="form-control" minlength="3" maxlength="10" required="required"/>						
			</div>
			
			<div class="col-sm-12">
				<form:errors class="control-label" path="username"/>
			</div>
			
		</div>		
		
		<div class="form-group">
			<div class="col-sm-12">
				<form:password path="password" placeholder="Password" class="form-control"  minlength="3" maxlength="10" required="required" />
			</div>
			<div class="col-sm-12">
				<form:errors class="form-label" path="password"/>		
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-12">
				<input type="submit" class="col-sm-offset-3 col-sm-6 btn btn-default" value="Login"/>			
			</div>
		</div>
		
		
	</form:form>	
</div>

</div>

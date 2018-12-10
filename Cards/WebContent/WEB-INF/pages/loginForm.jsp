<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<ul>
	<li><a href="/Card/register">Register</a></li>
</ul> 


<div id="login">
	
	<div class="container">
	
	<form:form method="POST" class="margin col-sm-offset-4 form-horizontal"  modelAttribute="user" action="login" align="center">	
	
		
		<h2>
			${message}
		</h2>	
		
		<div id="loginForm" class="form-group col-md-offset-5 form-horizontal">
			
			<div class="col-sm-6">
				<form:input  path="username" placeholder="Username" class="form-control" minlength="3" maxlength="10" required="required"/>						
			</div>
			
			<div class="col-sm-6">
				<form:errors class="form-label" path="username"/>
			</div>
			
		</div>		
		
		<div class="form-group">
			<div class="col-sm-6">
				<form:password path="password" placeholder="Password" class="form-control"  minlength="3" maxlength="10" required="required" />
			</div>
			<div class="col-sm-6">
				<form:errors class="form-label" path="password"/>		
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-6">
				<input type="submit" class="col-sm-offset-3 col-sm-6 btn btn-default" value="Login"/>			
			</div>
		</div>
		
		
	</form:form>	
</div>
</div>

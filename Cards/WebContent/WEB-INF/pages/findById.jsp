<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form method="POST" modelAttribute="Deck" action="findById" class="form-horizontal">
	<div class="form-horizontal">
		<table class="table">
			<tr>
				<td><form:label path="title">Title:</form:label></td>
				<td><form:errors path="title"/></td>								
				<td><form:input path="title" minlength="3" maxlength="10" required="required" class="control-label col-xs-2"/></td>			
			</tr>
			<tr>
				<td><form:label path="description">Description</form:label></td>
				<td><form:errors path="description"/></td>
				<td><form:input path="description" minlength="3" maxlength="10" required="required" class="control-label col-xs-2" /></td>				
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Submit"/>
				</td>
			</tr>
		</table>
	</div>
		<br/>
		<form:errors path="*"/>
	</form:form>
</body>
</html>
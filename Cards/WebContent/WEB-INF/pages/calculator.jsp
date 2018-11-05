<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:form method="POST" modelAttribute="calculator" action="calculate">
	
	<form:input path="lhs"></form:input>
	<form:input path="rhs"></form:input>	
	<form:select path="operator">
		<form:options items="${operators}"/>
	</form:select>
	<input type="submit" />
		
</form:form>

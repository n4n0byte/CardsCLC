<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
	<spring:url value="/resources/css/main.css" var="mainCss" />
	<link href="${mainCss}" rel="stylesheet" />
	<script type="text/javascript" src="/Card/resources/external/jquery/jquery.js"></script>
	<script type="text/javascript" src="/Card/resources/jquery-ui.js"></script>
	<link href="/Card/resources/jquery-ui.css" rel="stylesheet">	
	<!-- 
	<spring:url value="/resources/bootstrap-3.3.7-dist/css/bootstrap.css" var="bootstrapCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
	<spring:url value="/resources/bootstrap-3.3.7-dist/js/bootstrap.js" var="bootstrapJs" />
	<link href="${bootstrapJs}" rel="stylesheet" />
	 -->
	
	
    <title>Cards CLC</title>
    
</head>

<body>

	<!-- Header -->
	<tiles:insertAttribute name="header" />

	<!-- Body Page -->
	<tiles:insertAttribute name="body" />

	<!-- Footer Page -->
	<tiles:insertAttribute name="footer" />
</body>

</html>
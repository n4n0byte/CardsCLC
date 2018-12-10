<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
	<title>Card CLC</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">	
	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">
	<link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.2.0/css/responsive.dataTables.css">
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="//cdn.datatables.net/responsive/2.2.0/js/dataTables.responsive.js"></script>
	<style type="text/css">.bs-example { margin: 20px; }></style>
	
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
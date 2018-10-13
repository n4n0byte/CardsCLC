<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

x<html>
<head>
	<spring:url value="/resources/main.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />

    <title>Cards CLC</title>
    
</head>

<body>

	<!-- Header -->
	<tiles:insertAttribute name="header" />

	<!-- Body Page -->
	<div align="center">
		<tiles:insertAttribute name="body" />
	</div>

	<!-- Footer Page -->
	<tiles:insertAttribute name="footer" />
</body>

</html>
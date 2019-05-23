<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html">
<link rel="stylesheet" type="text/css"
	href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">
<script
	src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"/>"></script>
<script
	src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"/>"></script>
<link href="<c:url value="/resources/css/bootstrap.min.css" /> "
	rel="stylesheet" />
<link href="<c:url value="/resources/css/bootstrap.css" /> "
	rel="stylesheet" />
<link
	href="<c:url value="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" /> "
	rel="stylesheet" />
<script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<style>
.jumbotron{
	height: 70%;
}

#mySidenav a {
	position: absolute;
	left: -80px;
	transition: 0.3s;
	padding: 15px;
	width: 100px;
	text-decoration: none;
	font-size: 20px;
	color: white;
	border-radius: 0 5px 5px 0;
}

#mySidenav a:hover {
	left: 0;
}

#about {
	top: 220px;
	background-color: #4CAF50;
}

#blog {
	top: 280px;
	background-color: #2196F3;
}

#projects {
	top: 340px;
	background-color: #f44336;
}

#contact {
	top: 400px;
	background-color: #555
}

.col-centered {
	float: none;
	margin: 0 auto;
}
</style>
</head>
<body>
	<div class="container">
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>

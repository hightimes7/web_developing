<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%> 
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="${contextPath}/resources/css/animate.css">
    
    <link rel="stylesheet" href="${contextPath}/resources/css/owl.carousel.min.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/magnific-popup.css">
    
    <link rel="stylesheet" href="${contextPath}/resources/css/flaticon.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/style.css">
<title><tiles:insertAttribute name="title" /></title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
	*{
	font-family: 'Noto Sans KR', sans-serif;
	}
</style>
</head>
<body>
	<div id="container">
		<div id="header">
			<tiles:insertAttribute name="header" />
		</div>
		<div id="content">
			<tiles:insertAttribute name="body" />
		</div>
		<div id="footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
  <script src="${contextPath}/resources/js/jquery.min.js"></script>
  <script src="${contextPath}/resources/js/jquery-migrate-3.0.1.min.js"></script>
  <script src="${contextPath}/resources/js/popper.min.js"></script>
  <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  <script src="${contextPath}/resources/js/jquery.easing.1.3.js"></script>
  <script src="${contextPath}/resources/js/jquery.waypoints.min.js"></script>
  <script src="${contextPath}/resources/js/jquery.stellar.min.js"></script>
  <script src="${contextPath}/resources/js/owl.carousel.min.js"></script>
  <script src="${contextPath}/resources/js/jquery.magnific-popup.min.js"></script>
  <script src="${contextPath}/resources/js/jquery.animateNumber.min.js"></script>
  <script src="${contextPath}/resources/js/scrollax.min.js"></script>
  <script src="${contextPath}/resources/js/main.js"></script>
</body>
</html>
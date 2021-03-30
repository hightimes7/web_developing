<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Lora:ital,wght@0,400;0,500;0,600;0,700;1,400;1,500;1,600;1,700&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="css/animate.css">

<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="css/magnific-popup.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.min.css">

<link rel="stylesheet" href="css/flaticon.css">
<link rel="stylesheet" href="css/style.css">
<meta charset="UTF-8">
<title>전문가 리스트(관리자 전용)</title>
<style>
#sailorTableArea {
	max-height: 800px;
	overflow-x: auto;
	overflow-y: auto;
	padding: 2%;
}

#sailorTable {
	white-space: normal;
}

tbody {
	display: block;
	height: 330px;
	overflow: auto;
}

thead, tbody tr {
	display: table;
	width: 100%;
	table-layout: fixed;
}

#sailorTable>tbody>tr>td {
	height: 60px;
}

#sailorTable>tbody>tr>td>a.btn.btn-info.btn-xs {
	height: 20px;
	width: 30px;
	font-size: 5px;
	line-height: 20px;
	margin: 0;
	padding: 0;
}

#sailorTable>tbody>tr>td.text-center>a.btn.btn-danger.btn-xs {
	height: 20px;
	width: 30px;
	font-size: 5px;
	margin: 0;
	padding: 0;
	line-height: 20px;
}

#sailorTable {
	height: 100px;
}
#sailorTableArea
</style>
</head>
<body>
	<div class="container">
		<div class="table-responsive" id="sailorTableArea">
		<h2>등록되지 않은 제조업체 목록</h2>
			<table id="sailorTable" class="table table-striped table-bordered"
				width="100%">
				<a href="${contextPath}/expert/expertListFormo.do"
					class="btn btn-primary pull-right" style="margin: 5px;"><b>+</b>더보기</a>
				<br>
				<tr>
					<th>아이디</th>
					<th>회사이름</th>
					<th>이메일</th>
					<th>업종</th>
					<th>전화번호</th>
					<th>커리어</th>
					<th>권한</th>
					<th class="text-center">정보 수정</th>
				</tr>
				<c:choose>
					<c:when test="${expertList.isEmpty()}">
						<tr align="center">
							<td>
								<p align="center">
									<b><span style="font-size: 9pt;">등록된 글이 없습니다.</span></b>
								</p>
							</td>
						</tr>
					</c:when>
					<c:when test="${expertList != null}">
						<c:forEach var="expertVO" items="${expertList}">
							<c:if test="${expertVO.expAuth=='o'}">

								<tr align="center">
									<td>${expertVO.id}</td>
									<td>${expertVO.expName}</td>
									<td>${expertVO.expEmail}</td>
									<td>${expertVO.expBizField}</td>
									<td>${expertVO.expTel}</td>
									<td>${expertVO.expCareer}</td>
									<td>${expertVO.expAuth}</td>
									<td class="text-center"><a class='btn btn-info btn-xs'
										href="${contextPath}/expert/expertSelectForm.do?id=${expertVO.id}">
											<span class="glyphicon glyphicon-edit"></span>수정
									</a> <a
										href="${contextPath}/expert/deleteexpert.do?id=${expertVO.id}"
										class="btn btn-danger btn-xs"> <span
											class="glyphicon glyphicon-remove"> </span>삭제
									</a></td>

								</tr>
							</c:if>
						</c:forEach>
					</c:when>
				</c:choose>
			</table>
			<!--  등록된 전문가     -->
		</div>



		<div class="table-responsive" id="sailorTableArea">
		<h2>등록되지 않은 제조업체 목록</h2>
			<table id="sailorTable" class="table table-striped table-bordered">
				<a href="${contextPath}/expert/expertListFormx.do"
					class="btn btn-primary btn-xs pull-right" style="margin: 5px;"><b>+</b>더보기</a>
				<tr>
					<th>아이디</th>
					<th>회사이름</th>
					<th>이메일</th>
					<th>업종</th>
					<th>전화번호</th>
					<th>커리어</th>
					<th>권한</th>
					<th class="text-center">정보 수정</th>
				</tr>
				<c:choose>
					<c:when test="${expertList.isEmpty()}">
						<tr align="center">
							<td>
								<p align="center">
									<b><span style="font-size: 9pt;">등록된 글이 없습니다.</span></b>
								</p>
							</td>
						</tr>
					</c:when>
					<c:when test="${expertList != null}">
						<c:forEach var="expertVO" items="${expertList}">
							<c:if test="${expertVO.expAuth=='x'}">
								<tr align="center">
									<td>${expertVO.id}</td>
									<td>${expertVO.expName}</td>
									<td>${expertVO.expEmail}</td>
									<td>${expertVO.expBizField}</td>
									<td>${expertVO.expTel}</td>
									<td>${expertVO.expCareer}</td>
									<td>${expertVO.expAuth}</td>
									<td class="text-center">
									<a class='btn btn-info btn-xs' href="${contextPath}/expert/expertSelectFormx.do?id=${expertVO.id}">
									<span class="glyphicon glyphicon-edit">등록</span></a> 
									<!-- <a href="${contextpath}/plt/list/deleteexpert.do?id=${expertVO.id}" class="btn btn-danger btn-xs">
									삭제</a> -->
									</td>
								</tr>
							</c:if>
						</c:forEach>
					</c:when>
				</c:choose>

			</table>
			<!--  비 등록된 전문가     -->
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/jquery-migrate-3.0.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.easing.1.3.js"></script>
	<script src="js/jquery.waypoints.min.js"></script>
	<script src="js/jquery.stellar.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/jquery.animateNumber.min.js"></script>
	<script src="js/scrollax.min.js"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
	<script src="js/google-map.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>
	<script src="js/main.js"></script>
</body>
</html>
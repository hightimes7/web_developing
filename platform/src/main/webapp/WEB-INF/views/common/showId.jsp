
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="result" value="${param.result }" />
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<title>아이디 찾기</title>
<meta charset="utf-8">

</head>
<body>
	<section class="hero-wrap hero-wrap-2"
		style="background-image: url('${contextPath }/resources/images/bg_5.jpg');"
		data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="container">
			<div
				class="row no-gutters slider-text align-items-center justify-content-center">
				<div class="col-md-9 ftco-animate mb-0 text-center">
					<p class="breadcrumbs mb-0">
						<span class="mr-2"><a href="${contextPath }/common/loginForm.do">로그인 <i
								class="fa fa-chevron-right"></i></a></span>
						<!--  	<span> <i class="fa fa-chevron-right"></i></span> -->
					</p>
					<h2 class="mb-0 bread">아이디 찾기</h2>
				</div>
			</div>
		</div>
	</section>
	
	<section class="ftco-section bg-light">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-12">
					<div class="wrapper px-md-4">

						<div class="row no-gutters">
							<div class="col-md-7">
								<div class="contact-wrap w-100 p-md-5 p-4">
									<h3 class="mb-4">아이디 찾기 검색 결과</h3>
									<form method="POST" id="login" name="contactForm"
										class="contactForm" action="${contextPath }/common/loginForm.do">
										<div class="row">

											<div class="col-md-12">
												<div class="form-group">
													<p><font color="skyblue">${showId.id }</font></p> 
												</div>
											</div>

											<div class="col-md-12">
												<div class="form-group">
													<a href="${contextPath }/common/loginForm.do" class="btn btn-primary"
														id="loginButton">Login</a>
													<button type="button" onclick="history.go(-1);"
														class="btn btn-primary">Back</button>
												</div>
											</div>
										</div>
									</form>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- loader -->
	<div id="ftco-loader" class="show fullscreen">
		<svg class="circular" width="48px" height="48px">
            <circle class="path-bg" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke="#eeeeee" />
            <circle class="path" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" /></svg>
	</div>


	
</body>
</html>
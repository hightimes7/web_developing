
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
<html lang="en">

<head>
<title>회원 로그인</title>
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

<c:choose>
	<c:when test="${result =='loginFailed' }">
		<script>
			window.onload = function() {
				alert("아이디나 비밀번호가 틀립니다. 다시 로그인 하세요!");
			}
		</script>
	</c:when>
</c:choose>


<style>
.submitting {
	margin-top: 30px;
}
</style>
<meta charset="utf-8">
</head>

<body onkeydown="javascript:onEnterLogin();">

	<section class="hero-wrap hero-wrap-2"
		style="background-image: url('${contextPath}/resources/images/bg_5.jpg');"
		data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="container">
			<div
				class="row no-gutters slider-text align-items-center justify-content-center">
				<div class="col-md-9 ftco-animate mb-0 text-center">
					<p class="breadcrumbs mb-0">
						<span class="mr-2"><a href="index.html">마이페이지 <i
								class="fa fa-chevron-right"></i></a></span>
						<!--  	<span> <i class="fa fa-chevron-right"></i></span> -->
					</p>
					<h2 class="mb-0 bread">Login</h2>
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
									<h3 class="mb-4">로그인</h3>
									<form method="POST" id="login" name="contactForm"
										class="contactForm" action="${contextPath}">
										<div class="row">
											<div class="col-md-6">
												<div class="form-group">
													<select class="form-control input-sm" id="selectid">
														<option value="admin" id="admin">회원종류를 선택하세요</option>
														<option value="startup" id="startup">스타트업</option>
														<option value="manufac" id="manufac">제조업체</option>
														<option value="expert" id="expert">전문가</option>

													</select>
												</div>
											</div>
											<div class="col-md-12">
												<div class="form-group">
													<label class="label" for="name">ID</label> <input
														type="text" class="form-control" name="id" id="name"
														placeholder="아이디를 입력하세요">
												</div>
											</div>

											<div class="col-md-12">
												<div class="form-group">
													<label class="label" for="password">Password</label> <input
														type="password" class="form-control" name="pwd"
														id="subject" placeholder="비밀번호를 입력하세요">
												</div>
											</div>

											<div class="col-md-12">
												<div class="form-group">
													<input  onKeyPress="EnterCheckEvent();" type="button" value="로그인" class="btn btn-primary"
														id="loginButton" onClick="loginClick()">
													<button type="reset" class="btn btn-primary">다시입력</button>
													<div class="submitting">
														<a href="${contextPath}/common/idForm.do" class="findId"><h5>아이디
																찾기</a> &emsp;&emsp;&emsp; <a
															href="${contextPath}/common/pwdForm.do" class="findPwd">비밀번호
															찾기</a> &emsp;&emsp;&emsp; <a
															href="${contextPath}/admin/chooseForm.do"
															class="joinMember">회원가입
															</h5>
														</a>
													</div>
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

	<script>
		var loginbutton = document.querySelector("#loginButton");
		var formtag = document.querySelector("#login")
		function onEnterLogin(){
			var keyCode = window.event.keyCode;
			if (keyCode == 13) { //엔테키 이면
				loginClick();
			}
		} //onEnterLogin()
		function loginClick(){
			var select = document.querySelector("#selectid").value
			if (select === "startup") {
				console.log("startup 선택")
				formtag.action += "/startup/login.do"
				formtag.submit();
			} else if (select === "manufac") {
				console.log("manufac 선택 ")
				formtag.action += "/manufac/login.do"
				formtag.submit();
			} else if (select === "expert") {
				console.log("expert 선택")
				formtag.action += "/expert/login.do"
				formtag.submit();
			} else {
				console.log("admin 선택")
				formtag.action += "/admin/login.do"
				formtag.submit();
			}
		}
	</script>
</body>

</html>

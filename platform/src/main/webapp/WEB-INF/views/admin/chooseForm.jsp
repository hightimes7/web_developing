<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Lora:ital,wght@0,400;0,500;0,600;0,700;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="${contextPath}/resources/css/animate.css">
    
    <link rel="stylesheet" href="${contextPath}/resources/css/owl.carousel.min.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/magnific-popup.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.min.css">
    
    <link rel="stylesheet" href="${contextPath}/resources/css/flaticon.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/style.css">
<title>Insert title here</title>
</head>
<body>
  	
		
    
    
		
		<section class="ftco-section">
      <div class="container">
        <div class="row d-flex">
          <div class="col-md-4 d-flex ftco-animate">
          	<div class="blog-entry justify-content-end">
              <div class="text text-center">
              	<a href="${contextPath}/startup/startupForm.do" class="block-20 img" style="background-image: url('${contextPath}/resources/images/image_6.jpg');">
	              </a>
	              <div class="meta text-center mb-2 d-flex align-items-center justify-content-center">
                	<div>
                		<span class="day">01</span>
                		<span class="mos">StartUp</span>
                		<span class="yr">Join-us</span>
                	</div>
                </div>
                <h3 class="heading mb-3"><a href="${contextPath}/startup/startupForm.do">스타트 기업 회원가입</a mb-3></h3>
								<p>Start company membership registration.</p>              
							</div>
            </div>
          </div>
         <!--             스타트업 회원가입 선택                 -->
          <div class="col-md-4 d-flex ftco-animate">
          	<div class="blog-entry justify-content-end">
              <div class="text text-center">
              	<a href="${contextPath}/manufac/manufacForm.do" class="block-20 img" style="background-image: url('${contextPath}/resources/images/image_9.jpg');">
	              </a>
	              <div class="meta text-center mb-2 d-flex align-items-center justify-content-center">
                	<div>
                		<span class="day">02</span>
                		<span class="mos">Manufactur</span>
                		<span class="yr">Join-us</span>
                	</div>
                </div>
                <h3 class="heading mb-3"><a href="${contextPath}/manufac/manufacForm.do" >제조업체 회원등록 신청</a mb-3></h3>
								<p>Application for manufacturer membership registration.</p>              
							</div>
            </div>
          </div>
			<!--             제조업체 회원가입 선택                 -->
          
          <div class="col-md-4 d-flex ftco-animate">
          	<div class="blog-entry justify-content-end">
              <div class="text text-center">
              	<a href="${contextPath}/expert/expertForm.do" class="block-20 img" style="background-image: url('${contextPath}/resources/images/image_3.jpg');">
	              </a>
	              <div class="meta text-center mb-2 d-flex align-items-center justify-content-center">
                	<div>
                		<span class="day">03</span>
                		<span class="mos">Expert</span>
                		<span class="yr">Join-us</span>
                	</div>
                </div>
                <h3 class="heading mb-3"><a href="${contextPath}/expert/expertForm.do">전문가 회원등록 신청</a mb-3></h3>
					<p>Application for expert membership registration.</p>              
			  </div>
            </div>
          </div>

         <!--             전문가 회원가입 선택                 -->
         

         
         
        </div>
        
      </div>
    </section>	

    
  

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


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
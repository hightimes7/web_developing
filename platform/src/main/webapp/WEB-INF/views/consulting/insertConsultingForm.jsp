<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Publishing Company - Free Bootstrap 4 Template by Colorlib</title>
        <meta charset="utf-8">
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link
            href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
            rel="stylesheet">
        <link
            href="https://fonts.googleapis.com/css2?family=Lora:ital,wght@0,400;0,500;0,600;0,700;1,400;1,500;1,600;1,700&display=swap"
            rel="stylesheet">

        <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="${contextPath }/resources/css/animate.css">

        <link rel="stylesheet" href="${contextPath }/resources/css/owl.carousel.min.css">
        <link rel="stylesheet" href="${contextPath }/resources/css/owl.theme.default.min.css">
        <link rel="stylesheet" href="${contextPath }/resources/css/magnific-popup.css">

        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.min.css">

        <link rel="stylesheet" href="${contextPath }/resources/css/flaticon.css">
        <link rel="stylesheet" href="${contextPath }/resources/css/style.css">
    </head>
	<body>
        <section class="ftco-section bg-light">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-12">
                        <div class="wrapper px-md-4">
                            <div class="row no-gutters">
                                <div class="contact-wrap w-100 p-md-5 p-4">
                                    <h3 class="mb-4">컨설팅 요청</h3>
                                    <form method="POST" class="contactForm" action="${contextPath }/insertConsulting.do">
                                        <div class="row">
                                        	<div class="col-md-6">
                                                <div class="form-group">
                                                    <div style="float:left"><label class="label" for="no">NO</label></div>
                                                    <div style="float:left; padding-left: 2%">
	                                                    <input
	                                                        type="text"
	                                                        class="random"
	                                                        name="no"
	                                                        style="border:none;"
	                                                        value="" readonly />
                                                    </div>
                                                </div>
                                            </div>
                                            <br>
                                            <br>
                                            <br>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="label" for="compId">요청업체</label>
                                                    <input
                                                        type="text"
                                                        class="form-control"
                                                        name="compId"
                                                        value="${member.id}" readonly><!--requeset.getSession("userId") 으로 차후 교체-->
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="label" for="expId">담당자</label>
                                                    <input
                                                        type="text"
                                                        class="form-control"
                                                        name="expId"
                                                        value="<%= request.getParameter("expId")%>" readonly />
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label class="label" for="title">제목</label>
                                                    <input
                                                        type="text"
                                                        class="form-control title"
                                                        name="title"
                                                        placeholder="title">
                                                </div>
											</div>
											<div class="col-md-12">
                                                <div class="form-group">
                                                    <label class="label" for="content">내용</label>
                                                    <textarea class="form-control content" name="content" rows="12"></textarea>
                                                </div>
											</div>
											<div class="col-md-1">
                                                <div class="form-group">
                                                    <label class="label" for="#">금액</label>
                                                    <div style="text-align:right; padding-right: 20px;">
														<span>&#8361;</span>
													</div>
                                                </div>
                                            </div>
											<div class="col-md-11">
                                                <div class="form-group">
                                                    <label class="label" for="price">    </label>
                                                    <input
                                                        type="text"
                                                        class="form-control price"
                                                        name="price"
                                                        placeholder="가격">
                                                </div>
											</div>
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label class="label" for="fileName">첨부</label>
													<input
														type="file" 
                                                        name="fileName"
                                                        class="form-control"
                                                        value="첨부파일"  />
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <input type="submit" value="Send Consulting" class="btn btn-primary">
                                                    <div class="submitting"></div>
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
        </section>

        <!-- loader -->
        <div id="ftco-loader" class="show fullscreen">
    
        </div>

        <script src="${contextPath }/resources/js/jquery.min.js"></script>
        <script src="${contextPath }/resources/js/jquery-migrate-3.0.1.min.js"></script>
        <script src="${contextPath }/resources/js/popper.min.js"></script>
        <script src="${contextPath }/resources/js/bootstrap.min.js"></script>
        <script src="${contextPath }/resources/js/jquery.easing.1.3.js"></script>
        <script src="${contextPath }/resources/js/jquery.waypoints.min.js"></script>
        <script src="${contextPath }/resources/js/jquery.stellar.min.js"></script>
        <script src="${contextPath }/resources/js/owl.carousel.min.js"></script>
        <script src="${contextPath }/resources/js/jquery.magnific-popup.min.js"></script>
        <script src="${contextPath }/resources/js/jquery.animateNumber.min.js"></script>
        <script src="${contextPath }/resources/js/scrollax.min.js"></script>
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>
        <script src="${contextPath }/resources/js/main.js"></script>
		<script>
			var price = document.querySelector(".price")
			var vat = document.querySelector(".vat")
			var rand = document.querySelector(".random")
			var form = document.querySelector(".contactForm")
			var content = document.querySelector(".content")
			var title = document.querySelector(".title")
			console.log(rand.value)
			addEventListener("load",function(){
				console.log(rand.value);
				var min = Math.ceil(10);
				var max = Math.floor(1000);
				rand.value = Math.floor(Math.random() * (max - min)) + min;
			})
			price.addEventListener("change",function(e){
				if(!isNaN(e.target.value)){
					vat.value= Math.round(e.target.value/10);
				}else{
					alert("숫자만 입력 가능합니다.")
					price.value = "";
					price.focus();
				}
			})
			
			console.log(form)
			form.addEventListener("submit",function(e){
				e.preventDefault();
				if(content.value ==""){
					alert("내용을 입력해 주세요")
					content.focus();
				}else if(title.value==""){
					alert("제목을 입력해 주세요")
					title.focus();
				}else if(price.value==""){
					alert("가격을 입력해 주세요")
					price.focus();
				}else{
					form.submit();
				}
			})
		</script>
    </body>
</html>
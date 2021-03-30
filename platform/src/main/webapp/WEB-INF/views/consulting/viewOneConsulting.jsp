<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
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

        <link rel="stylesheet" href="${contextPath}/resources/css/animate.css">

        <link rel="stylesheet" href="${contextPath}/resources/css/owl.carousel.min.css">
        <link rel="stylesheet" href="${contextPath}/resources/css/owl.theme.default.min.css">
        <link rel="stylesheet" href="${contextPath}/resources/css/magnific-popup.css">

        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.min.css">

        <link rel="stylesheet" href="${contextPath}/resources/css/flaticon.css">
        <link rel="stylesheet" href="${contextPath}/resources/css/style.css">
    </head>
    <script>
	var compId='${member.id}';
	function del(no) {
		var chk = confirm("철회 하시겠습니까?");
		if (chk) {
			location.href="${contextPath}/startuppage/conlist_del.do?no="+no+"&compId="+compId;
			
		}
	}	
	</script>
<body>
	<section class="ftco-section bg-light">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-12">
                        <div class="wrapper px-md-4">
                            <div class="row no-gutters">
                                <div class="contact-wrap w-100 p-md-5 p-4">
                                    <h3 class="mb-4">컨  설  팅</h3>
                                    <form method="POST" class="contactForm">
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
	                                                        value="${ConsultingVO.no}" readonly />
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
                                                        value="${ConsultingVO.compId}" readonly><!--requeset.getSession("userId") 으로 차후 교체-->
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
                                                        value="${ConsultingVO.expId}" readonly />
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label class="label" for="title">제목</label>
                                                    <input
                                                        type="text"
                                                        class="form-control"
                                                        name="title"
                                                        value="${ConsultingVO.title}"
                                                        placeholder="title">
                                                </div>
											</div>
											<div class="col-md-12">
                                                <div class="form-group">
                                                    <label class="label" for="content">내용</label>
                                                    <textarea class="form-control" name="content" rows="12">${ConsultingVO.content}</textarea>
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
                                                        value="${ConsultingVO.price}"
                                                        placeholder="가격">
                                                </div>
											</div>
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label class="label" for="fileName">첨부</label>
													<input
														type="text" 
                                                        name="fileName"
                                                        class="form-control"
                                                        value="${ConsultingVO.fileName}"  />
                                                </div>
                                            </div>
                                            <c:if test="${member.type == 'startup'}"><!-- request.getSession에서 user의 타입을 가져온다. -->
                                            	<div class="col-md-12">
	                                                <div class="form-group">
	                                                    <input type="button" value="컨설팅 철회" class="btn btn-primary"  onclick="del(${ConsultingVO.no})">
	                                                    <div class="submitting"></div>
	                                                </div>
                                            	</div>
                                            </c:if>
                                            <c:if test="${member.type == 'expert'}">
	                                           	<div class="col-md-12" >
	                                           		<c:if test="${ConsultingVO.status == 0 }">
		                                               	<div class="form-group" style="display: inline-block;">
		                                                   <a href= "${contextPath}/expertpage/updatestatus_y.do?status=${ConsultingVO.status}&no=${ConsultingVO.no}&expId=${member.id}" class="btn btn-info">컨설팅 수락</a>
		                                                   <div class="submitting"></div>
		                                               	</div>
		                                               	<div class="form-group" style="display: inline-block;">
		                                                   <a href= "${contextPath}/expertpage/updatestatus_n.do?status=${ConsultingVO.status}&no=${ConsultingVO.no}&expId=${member.id}" class="btn btn-primary">컨설팅 거절</a>
		                                                   <div class="submitting"></div>
		                                               </div>
	                                               </c:if>
	                                            </div>
	                                            <c:if test="${ConsultingVO.status == 1 }">
	                                            	<div class="form-group">
	                                                   <a href= "${contextPath}/expertpage/updatestatus_y.do?status=${ConsultingVO.status}&no=${ConsultingVO.no}&expId=${member.id}" class="btn btn-primary">컨설팅 완료</a>
	                                                   <div class="submitting"></div>
	                                               	</div>
	                                            </c:if>
                                            </c:if>
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
</body>
</html>
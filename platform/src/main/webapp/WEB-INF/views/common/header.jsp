<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%> 
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<style>
	*{
		font-family: 'Noto Sans KR', sans-serif;
	}
</style>
<meta charset="UTF-8">
<title>헤더</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	var type = '${member.type}';
	console.log(type);
	if(type=='startup'){
		var compId='${member.id}';
	}else if(type=='manufac'){
		var manuId='${member.id}';
	}else if(type=='expert'){
		var expId='${member.id}';
	}
	console.log(compId);
	console.log(manuId);
	console.log(expId);
	var id='${member.id}';
	
	$(function(){
		unReadCount();
		alarmQuotation();
		alarmConsulting();
	});
	
	function unReadCount(){
		$.ajax({
			url:"${contextPath}/message/unReadCount.do",
			type:"GET",
			data:{'id':id},
			success:function(data){
				$("#unReadCount").html(data);
			}
		});
	}
	
	function alarmQuotation(){
		$.ajax({
			url:"${contextPath}/alarmQuotation.do",
			type:"get",
			data:{"compId":compId, "manuId":manuId},
			success:function(data){
				$('#alarmQuotation').html(data);
			}
		});
	}
	
	function alarmConsulting(){
		$.ajax({
			url:"${contextPath}/alarmConsulting.do",
			type:"get",
			data:{"compId":compId, "expId":expId},
			success:function(data){
				$('#alarmConsulting').html(data);
			}
		})
	}
	
	function messageCheck(){
		var message = document.message;
		if(message.receiveId.value==""){
			alert("수신자를 입력해주세요");
			message.receiveId.focus();
			return false;
		}
		if(message.content.value==""){
			alert("내용을 입력해주세요");
			message.content.focus();
			return false;
		}
	}
	
	function adminMessageCheck(){
		var adminMessage = document.adminMessage
		if(adminMessage.content.value==""){
			alert("내용을 입력해주세요");
			adminMessage.content.focus();
			return false;
		}
	}
	
</script>
</head>
<body>
	<div class="container-fluid px-md-5  pt-4 pt-md-5">
		<div class="row justify-content-between">
			<div class="col-md-8 order-md-last">
				<div class="row">
					<div class="col-md-6 text-center">
						<a class="navbar-brand" href="${contextPath}/main/main.do">StartUp <span>Company</span> <small>Book Publishing Company</small></a>
					</div>
					<div class="col-md-6 d-md-flex justify-content-end mb-md-0 mb-3">
						<nav class="navbar navbar-expand-sm">
							<ul class="navbar-nav ml-auto">
								<c:if test="${member.id != null}">
									<c:choose>
										<c:when test="${member.type=='startup'}">
											<li class="nav-item dropdown mt-2">
												<a class="mr-1" href="${contextPath}/startuppage/estilist_more_w.do?compId=${member.id}" id="receivedRequest">대기중인 견적</a>
											</li>
											<li>
							             		<span class="badge badge-danger mt-3 mr-2" id="alarmQuotation"></span>
							             	</li>
							             	<li class="nav-item dropdown mt-2">
												<a class="mr-1" href="${contextPath}/startuppage/consulting_more_w.do?compId=${member.id}" id="receivedRequest">대기중인 컨설팅</a>
											</li>
											<li>
							             		<span class="badge badge-danger mt-3 mr-2" id="alarmConsulting"></span>
							             	</li>
										</c:when>
										<c:when test="${member.type=='manufac'}">
											<li class="nav-item dropdown mt-2">
												<a class="mr-1" href="${contextPath}/manufacpage/estilist_more_w.do?manuId=${member.id}" id="receivedRequest">대기중인 견적</a>
											</li>
											<li>
							             		<span class="badge badge-danger mt-3 mr-2" id="alarmQuotation"></span>
							             	</li>
										</c:when>
										<c:when test="${member.type=='expert'}">
											<li class="nav-item dropdown mt-2">
												<a class="mr-1" href="${contextPath}/expertpage/con_wait.do?expId=${member.id}" id="receivedRequest">대기중인 컨설팅</a>
											</li>
											<li>
							             		<span class="badge badge-danger mt-3 mr-2" id="alarmConsulting"></span>
							             	</li>
										</c:when>
									</c:choose>
									<li class="nav-item dropdown">
					                    <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
					                        	쪽지
					                    </a>
					                    <div class="dropdown-menu" style="margin: 0">
					                        <a class="dropdown-item" href="#">
					                        	<button class="btn btn-default text-muted text-center" data-target="#mesPop" data-toggle="modal">쪽지 보내기</button>
					                        </a>
					                        <a class="dropdown-item text-muted text-center" href="${contextPath}/message/messageList.do?id=${member.id}">쪽지 함</a>
					                        <a class="dropdown-item" href="#">
					                        	<button class="btn btn-default text-muted text-center" data-target="#adminMesPop" data-toggle="modal">관리자에게 쪽지</button>
					                        </a>
					                    </div>
				             		</li>
				             		<li>
					             		<span class="badge badge-danger mt-3" id="unReadCount"></span>
					             	</li>
				             		<li class="nav-item dropdown">
				                    	 <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
					                        	마이페이지
					                    </a>
					                    <div class="dropdown-menu" style="margin: 0">
					                    	<c:if test="${member.type!='admin'}">
						                    	<a class="dropdown-item text-muted text-center" href="${contextPath}/common/MyPage.do?userId=${member.id}">마이페이지 가기</a>
					                    	</c:if>
					                        <c:if test="${member.type=='startup'}">
					                        	<a class="dropdown-item text-muted text-center" href="${contextPath}/startup/startUpSelectForm.do?id=${member.id}">내 정보 관리</a>
					                        	<div class="dropdown-divider"></div>
						                        <a class="dropdown-item text-muted text-center" href="${contextPath}/scrap/printScrapAll.do?compId=${member.id}">스크랩 리스트</a>
						                        <div class="dropdown-divider"></div>
						                    	<a class="dropdown-item text-muted text-center" href="${contextPath}/startuppage/manu_estilist.do?compId=${member.id}">견적 현황 관리</a>
						                    	<a class="dropdown-item text-muted text-center" href="${contextPath}/startuppage/consultinglist.do?compId=${member.id}">컨설팅 현황 관리</a>
						                    	<div class="dropdown-divider"></div>
						                    	<a class="dropdown-item text-muted text-center" href="${contextPath}/startuppage/com_consultinglist.do?compId=${member.id}">완료 내역 관리</a>
						                    	<div class="dropdown-divider"></div>
					                        </c:if>
					                        <c:if test="${member.type=='manufac'}">
					                        	<a class="dropdown-item text-muted text-center" href="${contextPath}/manufac/manufacSelectForm.do?id=${member.id}">내 정보 관리</a>
					                        	<div class="dropdown-divider"></div>
					                        	<a class="dropdown-item text-muted text-center" href="${contextPath}/manufacpage/estilist.do?manuId=${member.id}">견적 현황 관리</a>
					                        	<a class="dropdown-item text-muted text-center" href="${contextPath}/manufacpage/com_estilist.do?manuId=${member.id}">견적 완료 목록</a>
					                        	<div class="dropdown-divider"></div>
					                        </c:if>
					                        <c:if test="${member.type=='expert'}">
					                        	<a class="dropdown-item text-muted text-center" href="${contextPath}/expert/expertSelectForm.do?id=${member.id}">내 정보 관리</a>
					                        	<div class="dropdown-divider"></div>
					                        	<a class="dropdown-item text-muted text-center" href="${contextPath}/expertpage/consulting.do?expId=${member.id}">컨설팅 현황 관리</a>
					                        	<a class="dropdown-item text-muted text-center" href="${contextPath}/expertpage/com_consulting.do?expId=${member.id}">컨설팅 완료 목록</a>
					                        	<div class="dropdown-divider"></div>
					                        </c:if>
					                        <c:if test="${member.type == 'startup'}">
				                				<a class="dropdown-item text-muted text-center" href="${contextPath}/startup/logout.do">로그아웃</a>
				                			</c:if>
				                			<c:if test="${member.type == 'manufac'}">
				                				<a class="dropdown-item text-muted text-center" href="${contextPath}/manufac/logout.do">로그아웃</a>
				                			</c:if>
				                			<c:if test="${member.type == 'expert'}">
				                				<a class="dropdown-item text-muted text-center" href="${contextPath}/expert/logout.do">로그아웃</a>
				                			</c:if>
				                			<c:if test="${member.type == 'admin'}">
				                				<a class="dropdown-item text-muted text-center" href="${contextPath}/admin/logout.do">로그아웃</a>
				                			</c:if>
					                    </div>
				                	</li>
				                	<c:if test="${member.type == 'admin'}">
				                		<li class="nav-item dropdown">
				                			<a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
				                				회원관리
				                			</a>
				                			<div class="dropdown-menu">
				                				<a class="dropdown-item text-muted text-center" href="${contextPath}/startup/startUpListForm.do">스타트업 목록</a>
				                				<a class="dropdown-item text-muted text-center" href="${contextPath}/manufac/manufacListForm.do">제조업체 목록</a>
				                				<a class="dropdown-item text-muted text-center" href="${contextPath}/expert/expertListForm.do">전문가 목록</a>
				                				<a class="dropdown-item text-muted text-center" href="${contextPath}/admin/changeLogForm.do">회원정보수정이력</a>
				                				<a class="dropdown-item text-muted text-center" href="${contextPath}/admin/LoginLogForm.do">로그인이력</a>
				                			</div>
				                		</li>
				                	</c:if>
								</c:if>
			                	<c:if test="${member.id == null}">
			                		<li class="nav-item">
				                		<a class="nav-link" href="${contextPath}/common/loginForm.do">로그인</a>
				                	</li>
				                	<li class="nav-item">
				             			<a class="nav-link" href="${contextPath}/admin/chooseForm.do">회원가입</a>
				                	</li>	
			                	</c:if>
							</ul>
						</nav>
					</div>
				</div>
			</div>
			<div class="col-md-4 d-flex">
				<div class="social-media">
		    		<p class="mb-0 d-flex">
		    			<a href="#" class="d-flex align-items-center justify-content-center"><span class="fa fa-facebook"><i class="sr-only">Facebook</i></span></a>
		    			<a href="#" class="d-flex align-items-center justify-content-center"><span class="fa fa-twitter"><i class="sr-only">Twitter</i></span></a>
		    			<a href="#" class="d-flex align-items-center justify-content-center"><span class="fa fa-instagram"><i class="sr-only">Instagram</i></span></a>
		    		</p>
        		</div>
			</div>
		</div>
	</div>
	<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container-fluid">
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="fa fa-bars"></span> Menu
	      </button>
	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav m-auto" >
	        	<li class="nav-item"><a href="${contextPath}/common/about.do" class="nav-link" style="font-family: 'Noto Sans KR', sans-serif;">플랫폼 소개</a></li>
	        	<li class="nav-item"><a href="${contextPath}/manufacSearch/allManufac.do" class="nav-link" style="font-family: 'Noto Sans KR', sans-serif;">제조사 찾기</a></li>
	        	<li class="nav-item"><a href="${contextPath}/expSearch/allExpert.do" class="nav-link" style="font-family: 'Noto Sans KR', sans-serif;">전문가 찾기</a></li>
	        	<li class="nav-item"><a href="${contextPath}/notice/noticeList.do" class="nav-link" style="font-family: 'Noto Sans KR', sans-serif;">공지사항</a></li>
	        	<li class="nav-item"><a href="${contextPath}/adminQnA/listArticles.do" class="nav-link" style="font-family: 'Noto Sans KR', sans-serif;">Q&A</a></li>
	        </ul>
	      </div>
	    </div>
  	</nav>
    <!-- END nav -->
    <!-- message Modal -->
     <div class="modal fade" id="mesPop">
        <div class="modal-dialog">
            <div class="modal-content" align="center">
            	<!-- Modal Header -->
		        <div class="modal-header">
		        	<h4 class="modal-title">쪽지 보내기</h4>
		        	<button type="button" class="close" data-dismiss="modal">&times;</button>
		      	</div>
		      	<div class="modal-body">
	                <form name="message" class="py-4" method="post" action="${contextPath}/message/sendMessage.do" onsubmit="return messageCheck()">
	                	<input type="hidden" name="sendId" value="${member.id}"> 
	                    <div class="form-group col-sm-10">
	                        <label for="inputReceiveId">수신자</label>
	                        <input type="text" name="receiveId" class="form-control" id="inputReceiveId" placeholder="받을 사람">
	                    </div>
	                    <div class="form-group col-sm-10">
	                        <label for="InputContent">내용</label>
	                        <textarea class="form-control" name="content" id="InputContent" rows="5" cols="10" placeholder="내용을 입력하세요."></textarea>
	                    </div>
	                    <button type="submit" class="btn btn-primary">전송</button>
	                    <button type="reset" class="btn btn-secondary">다시입력</button>
	                    <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
	                </form>
		      	</div>
            </div>
        </div>
    </div>
    <!-- message Modal End -->
    <!-- admin message Modal -->
     <div class="modal fade" id="adminMesPop">
        <div class="modal-dialog">
            <div class="modal-content" align="center">
            	<!-- Modal Header -->
		        <div class="modal-header">
		        	<h4 class="modal-title">쪽지 보내기</h4>
		        	<button type="button" class="close" data-dismiss="modal">&times;</button>
		      	</div>
		      	<div class="modal-body">
	                <form name="adminMessage" class="py-4" method="post" action="${contextPath}/message/sendMessage.do" onsubmit="return adminMessageCheck()">
	                	<input type="hidden" name="sendId" value="${member.id}"> 
	                    <div class="form-group col-sm-10">
	                        <label for="inputReceiveId">수신자</label>
	                        <input type="hidden" name="receiveId" value="admin">
	                        <input type="text" name="showId" class="form-control" id="inputReceiveId" placeholder="관리자" readonly>
	                    </div>
	                    <div class="form-group col-sm-10">
	                        <label for="InputContent">내용</label>
	                        <textarea class="form-control" name="content" id="InputContent" rows="5" cols="10" placeholder="내용을 입력하세요."></textarea>
	                    </div>
	                    <button type="submit" class="btn btn-primary">전송</button>
	                    <button type="reset" class="btn btn-secondary">다시입력</button>
	                    <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
	                </form>
		      	</div>
            </div>
        </div>
    </div>
    <!-- admin message Modal End -->
</body>
</html>
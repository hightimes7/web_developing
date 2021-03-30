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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<head>
<script type="text/javascript">
	function joinCheck(){
		var joinForm = document.joinForm;
		if(joinForm.name.value==""||joinForm.pwd.value==""||joinForm.expName.value==""||joinForm.expEmail.value==""
				||joinForm.expTel.value==""||joinForm.expDetail.value==""||joinForm.expCertif.value==""||joinForm.expCareer.value==""){
			alert('입력되지 않은 사항이 있습니다.');
			return false;
		}else if(checked==false){
			alert('아이디 중복체크를 해야 합니다.');
			return false;
		}
	}
</script>
<meta charset="UTF-8">
<title>전문가 등록</title>
</head>
<body>
<div class="container">
<br> 
<hr>


<header class="card-header">
	<a href="${contextPath}/common/loginForm.do" class="float-right btn btn-outline-primary mt-1">Log in</a>
	<h4 class="card-title mt-2">전문가 등록 신청</h4>
</header>
<article class="card-body">
<form method="post" name="joinForm" action="${contextPath}/expert/join_expert.do" enctype="multipart/form-data" onsubmit="joinCheck();">

		<div class="col form-group">
			<label>아이디 </label>   
		  	<input type="text" class="form-control" id="id" name="id">
		  	<div class="btn btn-secondary" onClick="overlapCheck()">중복 확인</div>
		  	<script>
		  	function overlapCheck(){
				var id = document.getElementById('id').value;
				$.ajax({
					url:"${contextPath}/expert/overlapCheck.do",
					type:"get",
					data:{"id":id},
					success:function(data){
						if(data == 1){
							alert('사용 불가능한 아이디입니다.')
						}else if(data == 0){
							alert('사용이 가능한 아이디입니다.')
							checked = true;
						}
					}
				})
			}
		  	</script>
		</div> 
		 
		<div class="col form-group">
			<label>비밀번호</label>
		  	<input type="password" class="form-control" name="pwd" placeholder="password">
		</div>
		
		<div class="col form-group">
			<label>이름</label>
		  	<input type="text" class="form-control" name="expName">
		</div>
		
		<div class="col form-group">
			<label>이메일</label>
		  	<input type="email" class="form-control" name="expEmail" >
			<small class="form-text text-muted">정확한 이메일 형식을 지켜주세요.</small>
		</div>
		
		<div class="col form-group">
			<label>전화번호</label>
		  	<input type="text" class="form-control" name="expTel">
		</div> 
	
		<div class="col form-group">
			<label>경력</label>
		  	<input type="text" class="form-control" name="expCareer" >
		</div> 
		
		<div class="col form-group">
			<label>경력 증빙</label>
			<input type="file" class="form-control" name="expCertif">
		</div> 
		
		<div class="col form-group">
			<label>증명사진</label>
			<input type="file" class="form-control" name="expImg">
		</div>
		
		<div class="col form-group">
			<label>상세 설명</label>
		  	<textarea class="form-control" name="expDetail"></textarea>
		</div> 
		
		<div class="form-group">
		  <label>업종</label>
			  <select id="expBizField" class="form-control" name="expBizField">
			      <option>가전</option>
			      <option>패션의류</option>
			      <option>홈인테리어</option>
			      <option>도서</option>
			      <option>식품</option>
				  <option selected="">기타</option>
			  </select>
		</div>		
	
    <div class="form-group">
		<button type="submit" class="btn btn-primary btn-block">
			전문가 등록 신청
		</button>
	</div> <!-- form-group// -->      
                                          
</form>
</article> <!-- card-body end .// -->



</div> 


</body>
</html>
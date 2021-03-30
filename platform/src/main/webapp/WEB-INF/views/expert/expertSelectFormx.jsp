<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<c:set var="expertVO" value="${expMap.expertVO}" />
<c:set var="imageFileList" value="${expMap.imageFileList}" />
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<style>
* {box-sizing: border-box}

/* Add padding to containers */
.container {
  padding: 16px;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit/register button */
.registerbtn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity:1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

body > form > div:nth-child(1){
	width : 40%;
	margin : 0 auto;
	
}

body > form > div.container.signin{
	width : 40%;
	margin : 0 auto;
}
#btnSignup{
	width : 100px;
	height : 40px;
}
#btnCancel{
	width : 100px;
	height : 40px;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
</style>
<meta charset="UTF-8">
<title>등록 신청서</title>
</head>
<body>
<form method="post" action="${contextPath}/expert/updateexpert.do" enctype="multipart/form-data">
  <div class="container">
    <h1>전문가 등록 신청서</h1>
    <p>Application for registration of experts.</p>
    <hr>

    <label for="email"><b>아이디</b></label>
   <input type="text" name="id" value="${expertVO.id}" readonly><br>

    <label for="psw"><b>비번	</b></label>
    <input type="hidden" name="pwd" value="${expertVO.pwd}"><br>

    <label for="psw-repeat"><b>전문가 이름</b></label>
    <input type="text" name="expName" value="${expertVO.expName}" readonly><br>
   
	<label for="email"><b>이메일</b></label>
    <input type="text" name="expEmail" value="${expertVO.expEmail}" readonly><br>

    <label for="psw"><b>분야</b></label>
    <input type="text" name="expBizField" value="${expertVO.expBizField}" readonly><br>

    <label for="psw-repeat"><b>전화번호</b></label>
    <input type="text" name="expTel" value="${expertVO.expTel}" readonly><br>
   
	<label for="email"><b>경력</b></label>
    <input type="text" name="expCareer" value="${expertVO.expCareer}" readonly><br>

    <label for="email"><b>경력증빙자료</b></label>
    <img src="${contextPath}/download.do?id=${expertVO.id}&imageFileName=${imageFileList[0].imageFileName}" id="certifPreview" style="height:220px; width:150px;"/><br><br>
   
	<label for="email"><b>회사사진 </b></label>
	<img src="${contextPath}/download.do?id=${expertVO.id}&imageFileName=${imageFileList[1].imageFileName}" id="imgPreview" style="height:220px; width:150px;" /><br><br><br><br>
			
    <label for="psw"><b>세부사항</b></label>
    <input type="hidden" name="expAuth" value="o" >
   <textarea rows="10px" cols="90px" name="expDetail" readonly >${expertVO.expDetail}</textarea><br>

  </div>

  <div class="container signin">
    		<button type="submit" class="btn btn-sm btn-primary" id="btnSignup">등록</button>
				<button type="button" class="btn btn-sm btn-primary" id="btnCancel" onclick="history.go(-1);">취소</button>  
  </div>
</form>

                    	
</body>
</html>
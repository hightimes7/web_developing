<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />


<%
  request.setCharacterEncoding("UTF-8");
%>    


<html>
<head>
<meta charset=UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Lora:ital,wght@0,400;0,500;0,600;0,700;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="${contextPath}/resources/css/animate.css">
    
    <link rel="stylesheet" href="${contextPath}/resources/css/owl.carousel.min.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/magnific-popup.css">
    <style>
        .table{
            margin-top: 20px;
            margin-bottom: -30px;
            text-align: center;
        }
        body > div.row.mt-5 > div > div > ul{
            margin-bottom: 150px;
        }
        #thead-c{
            background-color:#95adbe;
            
            color: white;
        }
        body > div > a{
           float : right;
        }
        .container{
         margin-bottom: 80px;
        }
        
    </style>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.min.css">
    
    <link rel="stylesheet" href="${contextPath}/resources/css/flaticon.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/style.css">
    
<title>계정 수정 사항 로그</title>
</head>
<body>
   
   <div class="container">
   <h3>스타트업 수정 사항</h3>
   <a href="${contextPath}/admin/startchangeLogForm.do"
					class="btn btn-primary pull-right" style="margin: 5px;"><b>+</b>더보기</a>
				<br>
      <table class="table">
          <thead id="thead-c">
            <tr>        
                <th>회원 종류</th>
                <th>아이디</th>
                <th>비밀번호</th>
                <th>회사명</th>
                <th>대표명</th>
                <th>주소</th>
                <th>전화번호</th>
                <th>업력</th>
            </tr>
          </thead>

       <tbody>
          <c:forEach var="start" begin="0" end="2" items="${startUpVO}" >     
               <tr align="center">
               <td>StartUp</td>
               <td>${start.id}</td>
               <td>${start.pwd}</td>
               <td>${start.name}</td>
               <td>${start.ceoname}</td>
               <td>${start.addr}</td>
               <td>${start.tel}</td>
               <td>${start.career}</td>
          </tr>
        </c:forEach>   
  	 </table>
   </div>



<!--                  스타트업 수정 사항 테이블 끝!!!!!!!!!!!!!!!!!!!! -->
<!--                  스타트업 수정 사항 테이블 끝!!!!!!!!!!!!!!!!!!!! -->
<!--                  스타트업 수정 사항 테이블 끝!!!!!!!!!!!!!!!!!!!! -->

<div class="container">
   <h3>제조업체 수정 사항</h3>
      <table class="table">
      <a href="${contextPath}/admin/manuchangeLogForm.do"
					class="btn btn-primary pull-right" style="margin: 5px;"><b>+</b>더보기</a>
				<br>
          <thead id="thead-c">
            <tr>        
                <th>회원 종류</th>
                <th>아이디</th>
                <th>비밀번호</th>
                <th>회사명</th>
                <th>대표명</th>
                <th>주소</th>
                <th>전화번호</th>
                <th>업력</th>
                <th>최소금액</th>
            </tr>
          </thead>

       <tbody>
          <c:forEach var="manu" begin="0" end="2" items="${manufacVO}" >     
               <tr align="center">
               <td>Manufac</td>
               <td>${manu.id}</td>
               <td>${manu.pwd}</td>
               <td>${manu.name}</td>
               <td>${manu.ceoname}</td>
               <td>${manu.addr}</td>
               <td>${manu.tel}</td>
               <td>${manu.career}</td>
               <td>${manu.price}</td>
          </tr>
        </c:forEach>   
  	 </table>
   </div>

<!--                  스타트업 수정 사항 테이블 끝!!!!!!!!!!!!!!!!!!!! -->
<!--                  스타트업 수정 사항 테이블 끝!!!!!!!!!!!!!!!!!!!! -->
<!--                  스타트업 수정 사항 테이블 끝!!!!!!!!!!!!!!!!!!!! -->

<div class="container">
   <h3>전문가 수정 사항</h3>
   <a href="${contextPath}/admin/expertchangeLogForm.do"
					class="btn btn-primary pull-right" style="margin: 5px;"><b>+</b>더보기</a>
				<br>
      <table class="table">
          <thead id="thead-c">
            <tr>        
                <th>회원 종류</th>
                <th>아이디</th>
                <th>비밀번호</th>
                <th>이름</th>
                <th>분야</th>
                <th>전화번호</th>
                <th>업력</th>
            </tr>
          </thead>

       <tbody>
          <c:forEach var="expert" begin="0" end="2" items="${expertVO}" >     
               <tr align="center">
               <td>Expert</td>
               <td>${expert.id}</td>
               <td>${expert.pwd}</td>
               <td>${expert.name}</td>
               <td>${expert.biztype}</td>
               <td>${expert.tel}</td>
               <td>${expert.career}</td>
          </tr>
        </c:forEach>   
  	 </table>
   </div>



<!--                  제조 업체 수정 사항 테이블 끝!!!!!!!!!!!!!!!!!!!! -->
<!--                  제조 업체 수정 사항 테이블 끝!!!!!!!!!!!!!!!!!!!! -->
<!--                  제조 업체 수정 사항 테이블 끝!!!!!!!!!!!!!!!!!!!! -->





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
     <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
     <script src="${contextPath}/resources/js/google-map.js"></script>
     <script src="${contextPath}/resources/js/main.js"></script>
</body>
</html>
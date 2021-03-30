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
    
<title>접속변경 로그</title>
</head>

<body>
   
   <div class="container">
   <h3>제조업체 견젹 현황</h3>
      <table class="table">
          <thead id="thead-c">
            <tr>        
                <th>제조업체명</th>
                <th>견적 신청 날짜</th>
                <th>진행상황</th>
            </tr>
          </thead>

       <tbody>
          <c:forEach var="manu_esti" begin="0" end="2" items="${estilist}" >     
               <tr align="center">
               <td>${manu_esti.m_name}</td>
               <td>${manu_esti.e_date}</td>
                  <c:choose>
                  <c:when test="${manu_esti.e_status==0}">
                 <td>견적 대기</td>         
                  </c:when>
                  <c:when test="${manu_esti.e_status==1}">
                     <td>견적 진행중</td>
                  </c:when>
                  <c:when test="${manu_esti.e_status==2}">
                     <td>견적 완료</td>
                  </c:when>
                  
               </c:choose>
               <td><a href= "${contextPath}/startuppage/manu_esti_updatestatus_sh.do?e_status=${manu_esti.e_status}&m_name=${manu_esti.m_name}">수정하기</a></td>
          </tr>
        </c:forEach>   
   </table>
   <a href = "${contextPath}/startuppage/manu_estilist.do">더보기</a>
</div>





<div class="container">
   <h3>제조업체 제조 현황</h3>
      <table class="table">
          <thead id="thead-c">
            <tr>        
                <th>제조업체명</th>
                <th>제조 요청 날짜</th>
                <th>진행상황</th>
            </tr>
          </thead>

       <tbody>
          <c:forEach var="manu_prod" begin="0" end="2" items="${manulist}" >     
               <tr align="center">
               <td>${manu_prod.manuname}</td>
               <td>${manu_prod.reqprod}</td>
                  <c:choose>
                  <c:when test="${manu_prod.prodstatus==0}">
                 <td>발주 대기</td>         
                  </c:when>
                  <c:when test="${manu_prod.prodstatus==1}">
                     <td>발주 진행중</td>
                  </c:when>
                  <c:when test="${manu_prod.prodstatus==2}">
                     <td>제작 완료</td>
                  </c:when>
                  <c:when test="${manu_prod.prodstatus==3}">
                     <td>배송진행</td>
                  </c:when>
                  <c:when test="${manu_prod.prodstatus==4}">
                     <td>완료</td>
                  </c:when>
               </c:choose>
               <td><a href= "${contextPath}/startuppage/manu_updatestatus_sh.do?prodstatus=${manu_prod.prodstatus}&manuname=${manu_prod.manuname}">수정하기</a></td>
          </tr>
        </c:forEach>   
   </table>
   <a href = "${contextPath}/startuppage/manu_list.do">더보기</a>
</div>









<div class="container">
   <h3>컨설팅 현황</h3>
      <table class="table">
          <thead id="thead-c">
            <tr>        
                <th>전문가명</th>
                <th>컨설팅 신청 날짜</th>
                <th>진행상황</th>
            </tr>
          </thead>

       <tbody>
          <c:forEach var="conlist" begin="0" end="2" items="${conlist}" >     
               <tr align="center">
               <td>${conlist.expname}</td>
               <td>${conlist.reqdate}</td>
                  <c:choose>
                  <c:when test="${conlist.status==0}">
                 <td>컨설팅 대기</td>         
                  </c:when>
                  <c:when test="${conlist.status==1}">
                     <td>컨설팅 진행중</td>
                  </c:when>
                  <c:when test="${conlist.status==2}">
                     <td>컨설팅 완료</td>
                  </c:when>
               </c:choose>
               <td><a href= "${contextPath}/startuppage/con_updatestatus_sh.do?status=${conlist.status}&expname=${conlist.expname}">수정하기</a></td>
          </tr>
        </c:forEach>
   </table>
   <a href = "${contextPath}/startuppage/consulting_list.do">더보기</a>
</div>   
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
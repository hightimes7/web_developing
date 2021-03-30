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
		<script>
		var compId='${member.id}';
		function del(no) {
		var chk = confirm("삭제하시겠습니까?");
		if (chk) {
			location.href="${contextPath}/startuppage/com_estilist_del.do?no="+no+"&compId="+compId;
			
		}
	}	
</script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.min.css">
    
    <link rel="stylesheet" href="${contextPath}/resources/css/flaticon.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/style.css">
    
<title>제조업체 페이지 견적 완료내역</title>
</head>

<body>
   
   <div class="container">
   <h3>컨설팅 완료</h3>
      <table class="table">
          <thead id="thead-c">
            <tr>        
                <th>전문가명</th>
                <th>컨설팅 신청 날짜</th>
                <th></th>
            </tr>
          </thead>
	       <tbody>
	          <c:forEach var="start_con" items="${c_conlist}" begin="0" end="4"> 
	             <tr align="center">
	               <td>${start_con.expname}</td>
	               <td><fmt:formatDate value="${start_con.reqdate}" pattern="yy-MM-dd  kk:MM"/></td>
	               <td><button type="button" class="btn btn-outline-secondary" onclick="del(${start_con.no})">삭제</button></td>
	             </tr>
	          </c:forEach>
	        </tbody>
   		</table>
   		<a href = "${contextPath}/startuppage/com_consulting_more.do?compId=${member.id}">더보기</a>
   		<br><br><br><br>
   	<h3>견적 완료</h3>
      <table class="table">
          <thead id="thead-c">
            <tr>        
                <th>제조업체명</th>
                <th>견적 신청 날짜</th>
                <th></th>
            </tr>
          </thead>
	       <tbody>
	          <c:forEach var="start_esti" items="${c_estiList}" begin="0" end="4"> 
	             <tr align="center">
	               <td>${start_esti.manuname}</td>
	               <td><fmt:formatDate value="${start_esti.reqquote}" pattern="yy-MM-dd  kk:MM"/></td>
	               <td><button type="button" class="btn btn-outline-secondary" onclick="del(${start_esti.no})">삭제</button></td>
	             </tr>
	          </c:forEach>
	        </tbody>
   		</table>
   		<a href = "${contextPath}/startuppage/com_esti_more.do?compId=${member.id}">더보기</a>
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
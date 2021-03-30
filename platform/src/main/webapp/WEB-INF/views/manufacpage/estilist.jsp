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
<meta charset="UTF-8">
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
	var manuId='${member.id}';
	function del(no) {
		var chk = confirm("삭제 하시겠습니까?");
		if (chk) {
			location.href="${contextPath}/manufacpage/estilist_del.do?no="+no+"&manuId="+manuId;
			
		}
	}	
</script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.min.css">
    
    <link rel="stylesheet" href="${contextPath}/resources/css/flaticon.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/style.css">
    
<title>제조업체 페이지 견적 현황</title>
</head>

<body>
   
   <div class="container">
   <h3>대기중인 견적</h3>
      <table class="table">
          <thead id="thead-c">
            <tr>        
                <th>스타트업명</th>
                <th>견적 신청 날짜</th>
                <th></th>
            </tr>
          </thead>

       <tbody>
          <c:forEach var="manu_esti" begin='0' end='2' items="${w_estiList}" >     
               <tr align="center">
               <td><a href="${contextPath }/quotation/viewOneQuotation.do?no=${manu_esti.no}">${manu_esti.compname}</a></td>
               <td><fmt:formatDate value="${manu_esti.reqquote}" pattern="yy-MM-dd  kk:MM"/></td>
              <td><button type="button" class="btn btn-outline-secondary" onclick="del(${manu_esti.no})">철회</button></td>
          	   </tr>
        </c:forEach>
        </tbody>   
   </table>
   <a href = "${contextPath}/manufacpage/estilist_more_w.do?manuId=${member.id}">더보기</a>
</div>
 
   <div class="container">
   <h3>진행중인 견적</h3>
      <table class="table">
          <thead id="thead-c">
            <tr>        
                <th>스타트업명</th>
                <th>견적 신청 날짜</th>
                <th></th>
            </tr>
          </thead>

       <tbody>
         <c:forEach var="manu_esti" begin="0" end="2" items="${i_estiList}" >     
            <tr align="center">
               <td><a href="${contextPath }/quotation/viewOneQuotation.do?no=${manu_esti.no}">${manu_esti.compname}</a></td>
               <td><fmt:formatDate value="${manu_esti.reqquote}" pattern="yy-MM-dd  kk:MM"/></td>
               <td><button type="button" class="btn btn-outline-secondary" onclick="del(${manu_esti.no})">철회</button></td>
          	</tr>
       	</c:forEach>
       </tbody>   
   </table>
   <a href = "${contextPath}/manufacpage/estilist_more_ing.do?manuId=${member.id}">더보기</a>
</div>

   <div class="container">
   <h3>거절된 견적</h3>
      <table class="table">
          <thead id="thead-c">
            <tr>        
                <th>스타트업명</th>
                <th>견적 신청 날짜</th>
                <th></th>
            </tr>
          </thead>

       <tbody>
          <c:forEach var="manu_esti" begin="0" end="2" items="${d_estiList}" >     
               <tr align="center">
               <td><a href="${contextPath }/quotation/viewOneQuotation.do?no=${manu_esti.no}">${manu_esti.compname}</a></td>
               <td><fmt:formatDate value="${manu_esti.reqquote}" pattern="yy-MM-dd  kk:MM"/></td>
               <td><button type="button" class="btn btn-outline-secondary" onclick="del(${manu_esti.no})">삭제</button></td>
          </tr>
        </c:forEach>
        </tbody>   
   </table>
   <a href = "${contextPath}/manufacpage/estilist_more_de.do?manuId=${member.id}">더보기</a>
</div> 
</body>
</html>
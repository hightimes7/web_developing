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
		var chk = confirm("철회하시겠습니까?");
		if (chk) {
			location.href="${contextPath}/startuppage/estilist_del.do?no="+no+"&compId="+compId;
			
		}
	}	
	</script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.min.css">
    
    <link rel="stylesheet" href="${contextPath}/resources/css/flaticon.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/style.css">
    
<title>스타트업 페이지 제조업체 견적 현황</title>
</head>

<body>
   
   <div class="container">
   <h3>대기중인 견적</h3>
      <table class="table">
          <thead id="thead-c">
            <tr>        
                <th>제조업체명</th>
                <th>견적 신청 날짜</th>
                <th></th>
            </tr>
          </thead>

       <tbody>
          <c:forEach var="manu_esti" begin="0" end="2" items="${w_estilist}" >     
            <tr align="center">
               <td><a href = "${contextPath}/quotation/viewOneQuotation.do?no=${manu_esti.no}">${manu_esti.manuname}</a></td>
               <td><fmt:formatDate value="${manu_esti.reqquote}" pattern="yy-MM-dd  kk:MM"/></td>
               <td><button type="button" class="btn btn-outline-secondary" onclick="del(${manu_esti.no})">철회</button></td>
            </tr>
        </c:forEach>   
   </table>
   <a href= "${contextPath}/startuppage/estilist_more_w.do?compId=${member.id}">더보기</a>
</div>
 
   <div class="container">
   <h3>진행중인 견적</h3>
      <table class="table">
          <thead id="thead-c">
            <tr>        
                <th>제조업체명</th>
                <th>견적 신청 날짜</th>
                <th></th>
            </tr>
          </thead>

       <tbody>
          <c:forEach var="manu_esti" begin="0" end="2" items="${i_estilist}" >     
               <tr align="center">
               <td><a href = "${contextPath}/quotation/viewOneQuotation.do?no=${manu_esti.no}">${manu_esti.manuname}</a></td>
               <td><fmt:formatDate value="${manu_esti.reqquote}" pattern="yy-MM-dd  kk:MM"/></td>
               <td><button type="button" class="btn btn-outline-secondary" onclick="del(${manu_esti.no})">철회</button></td>
          </tr>
        </c:forEach>   
   </table>
   <a href = "${contextPath}/startuppage/estilist_more_ing.do?compId=${member.id}">더보기</a>
</div>

   <div class="container">
   <h3>거절된 견적</h3>
      <table class="table">
          <thead id="thead-c">
            <tr>        
                <th>제조업체명</th>
                <th>견적 신청 날짜</th>
                <th></th>
            </tr>
          </thead>

       <tbody>
          <c:forEach var="manu_esti" begin="0" end="2" items="${d_estilist}" >     
               <tr align="center">
               <td><a href = "${contextPath}/quotation/viewOneQuotation.do?no=${manu_esti.no}">${manu_esti.manuname}</a></td>
               <td><fmt:formatDate value="${manu_esti.reqquote}" pattern="yy-MM-dd  kk:MM"/></td>
               <td><button type="button" class="btn btn-outline-secondary" onclick="del(${manu_esti.no})">삭제</button></td>
          </tr>
        </c:forEach>   
   </table>
   <a href = "${contextPath}/startuppage/estilist_more_de.do?compId=${member.id}">더보기</a>
</div> 
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<style>
	.cls1{
		text-decoration: none;
	}
	.cls2{
		text-align: center;
		font-size: 30px;
	}
	.txt_center{
		text-align: center;
	}
</style>
<meta charset="UTF-8">
<title>공지사항 게시판</title>
</head>
<body>
	<div class="container" align="center">
        <div class="col-sm-8">
            <table class="table table-striped table-hover table-sm table-bordered">
                <thead align="center">
                    <tr class="table-active bg-primary text-white">
                        <th style="width:10%">글번호</th>
                       <th style="width:10%">작성자</th>
                       <th style="width:50%">제목</th>
                       <th style="width:20%">작성일</th>
                       <th style="width:10%">조회수</th>
                   </tr>
               </thead>
               <tbody>
                   <c:choose>
                   	<c:when test="${noticeList.isEmpty()}">
                   		<tr align="center">
                    		<td colspan=6>
                    			<p align="center">
									<b><span style="font-size:9pt;">등록된 글이 없습니다.</span></b>
								</p>
                    		</td>
                   		</tr>
                   	</c:when>
                   	<c:when test="${noticeList != null}">
                   		<c:forEach var="notice" items="${noticeList}" varStatus="noticeNum">
                   			<tr align="center">
								<td>${notice.no}</td>
								<td>${notice.writer}</td>
								<td align="left">
									<a class='cls1' href="${contextPath}/notice/viewNotice.do?no=${notice.no}">${notice.title}</a>
								</td>
								<td>${notice.writeDate}</td>
								<td>${notice.cnt}</td>
							</tr>
						</c:forEach>
                   	</c:when>
                   </c:choose>
               </tbody>
           </table>
           <div class="row mt-5">
	          <div class="col text-center">
	            <div class="block-27">
	              <ul>
	                 <c:if test="${pageVO.startPage != 1}">
	                   <li><a href="${contextPath}/notice/noticeList.do?nowPage=${pageVO.startPage -1}&cntPerPage=${pageVO.cntPerPage}">&lt;</a></li>
	               </c:if>
	               <c:forEach begin = "${pageVO.startPage}" end = "${pageVO.endPage}" var="idx">
	                  <c:choose>
	                  <c:when test="${idx == pageVO.nowPage }">
	                   <li class="active"><span> ${idx} </span></li>
	                   </c:when>
	                   <c:when test="${idx != pageVO.nowPage}">
	                   <li><a href="${contextPath}/notice/noticeList.do?nowPage=${idx}&cntPerPage=${pageVO.cntPerPage}"> ${idx} </a></li>
	                   </c:when>
	                     </c:choose>
	                </c:forEach>
	                <c:if test="${pageVO.endPage != pageVO.lastPage}">
	                   <li><a href="${contextPath}/notice/noticeList.do?nowPage=${pageVO.endPage+1}&cntPerPage=${pageVO.cntPerPage}">&gt;</a></li>
	                </c:if>
	              </ul>
	            </div>
	          </div>
        	</div>
           
       </div>
   </div>
	<c:if test="${member.type == 'admin'}">
		<a class="cls1" href="${contextPath}/notice/writeNoticeForm.do">
			<p class="cls2">글쓰기</p>
		</a>
	</c:if>
</body>
</html>
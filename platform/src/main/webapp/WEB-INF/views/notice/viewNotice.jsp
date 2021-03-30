<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<script src = "${contextPath}/ckeditor/ckeditor.js"></script>
<script type="text/javascript">
	var no = '${notice.no}';
	function backToList(obj){
		obj.action = "${contextPath}/notice/noticeList.do";
		obj.submit();
	}
	function deleteNotice(){
		if(confirm("정말 삭제하겠습니까?") != 0){
			location.href="${contextPath}/notice/deleteNotice.do?no="+no;
		}
	}
</script>
<meta charset="UTF-8">
<title>공지사항 작성</title>
</head>
<body>
	<div class="container" align="center">
		<div class="col-sm-10">
           <form name="writeForm" class="py-4" method="post" action="${contextPath}/notice/updateNoticeForm.do">
               <table class="table">
                   <h2>공지사항 작성</h2>
                   <tr class="col-sm-12">
                       <td align="center">작성자</td>
                       <td><input name="writer" type="text" class="form-control" value="${notice.writer}" readonly></td>
                   </tr>
                   <tr class="col-sm-12">
                       <td align="center">제목</td>
                       <td><input name="title" type="text" class="form-control" value="${notice.title}" readonly></td>
                   </tr>
                   <tr class="col-sm-12">
                       <td align="center">내용</td>
                       <td>
                       <textarea id = "description" class="form-group" name = "content" rows = "15" cols = "100" readonly>${notice.content}</textarea>
                       <script>
                       var id='${member.id}';
					   //id가 description인 태그에 ckeditor를 적용시킴
					   CKEDITOR.replace("description",{
					   });
					   </script>
                       </td>
                   </tr>
				  <tr>
				  	<td></td>
				  	<td></td>
				  </tr>
               </table>
               <input type="hidden" name="no" value="${notice.no}">
               <c:if test="${member.type == 'admin'}">
	               <button type="submit" class="btn btn-primary">수정하기</button>
	               <button type="button" class="btn btn-danger" onClick="deleteNotice();">삭제</button>
               </c:if>
               <button class="btn btn-secondary" onClick = "backToList(this.form)">목록</button>
           </form>
        </div>
	</div>
</body>
</html>
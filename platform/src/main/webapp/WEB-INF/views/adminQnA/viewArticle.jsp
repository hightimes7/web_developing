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
	var no = '${article.no}'
	function backToList(obj){
		obj.action = "${contextPath}/adminQnA/listArticles.do";
		obj.submit();
	}
	function deleteArticle(){
		if(confirm("정말 삭제하겠습니까?")!=0){
			location.href="${contextPath}/adminQnA/deleteArticle.do?no="+no;
		}
	}
</script>
<meta charset="UTF-8">
<title>게시글 보기</title>
</head>
<body>
	<div class="container" align="center">
		<div class="col-sm-8">
           <form name="writeForm" class="py-4" method="post" action="${contextPath}/adminQnA/updateArticleForm.do">
               <table class="table">
                   <h2>게시글 작성</h2>
                   <tr class="col-sm-10">
                       <td align="center">작성자</td>
                       <td><input name="writer" type="text" class="form-control" value="${article.writer}" readonly></td>
                   </tr>
                   <tr class="col-sm-10">
                       <td align="center">제목</td>
                       <td><input name="title" type="text" class="form-control" value="${article.title}" readonly></td>
                   </tr>
                   <tr class="col-sm-10">
                       <td align="center">내용</td>
                       <td>
                       <textarea id = "description" class="form-group" name = "content" rows = "5" cols = "100" readonly>${article.content}</textarea>
                       <script>
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
               <input type="hidden" name="no" value="${article.no}">
               <c:if test="${article.writer==member.id}">
	               <button type="submit" class="btn btn-warning">수정</button>
	               <button type="button" class="btn btn-danger" onClick="deleteArticle()">삭제</button>
               </c:if>
               <c:if test="${article.lvl == 1 && member.type == 'admin'}">
               		<button type="button" class="btn btn-info" onClick="location.href='${contextPath}/adminQnA/addReplyForm.do?no=${article.no}'">답글달기</button>
               </c:if>
               <button class="btn btn-danger" onClick = "backToList(this.form)">목록</button>
           </form>
        </div>
	</div>
</body>
</html>
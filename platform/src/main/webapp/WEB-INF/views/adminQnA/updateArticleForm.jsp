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
	function backToList(obj){
		obj.action = "${contextPath}/adminQnA/listArticles.do";
		obj.submit();
	}
	function adminQnACheck(){
		var writeForm = document.writeForm;
		var ckeditor = CKEDITOR.instances['description'];
		console.log(ckeditor.getData());
		if(writeForm.title.value==""){
			alert("제목을 입력하세요");
			writeForm.title.focus();
			return false;
		}
		if(ckeditor.getData()==""){
			alert("내용을 입력하세요");
			writeForm.content.focus();
			return false;
		}
	}
</script>
<meta charset="UTF-8">
<title>게시글 보기</title>
</head>
<body>
	<div class="container" align="center">
		<div class="col-sm-8">
           <form name="writeForm" class="py-4" method="post" action="${contextPath}/adminQnA/updateArticle.do" onsubmit="return adminQnACheck()">
               <table class="table">
                   <h2>게시글 작성</h2>
                   <tr class="col-sm-10">
                       <td align="center">작성자</td>
                       <c:if test="${adminQnAVO.writer=='admin'}">
						   <td>
								<input type="hidden" name="writer" value="${adminQnAVO.writer}">
								<input type="text" class="form-control" value="관리자" readonly>
						   </td>                       
                       </c:if>
                       <c:if test="${adminQnAVO.writer!='admin'}">
	                       <td><input name="writer" type="text" class="form-control" value="${adminQnAVO.writer}" readonly></td>
                       </c:if>
                   </tr>
                   <tr class="col-sm-10">
                       <td align="center">제목</td>
                       <td><input name="title" type="text" class="form-control" value="${adminQnAVO.title}"></td>
                   </tr>
                   <tr class="col-sm-10">
                       <td align="center">내용</td>
                       <td>
                       <textarea id = "description" class="form-group" name = "content" rows = "5" cols = "100">${adminQnAVO.content}</textarea>
                       <script>
                       var id ='${member.id}'
					   //id가 description인 태그에 ckeditor를 적용시킴
					   CKEDITOR.replace("description",{
					       filebrowserUploadUrl : "${contextPath}/qnaBoard/imageUpload.do?id="+id //이미지 업로드 기능을 추가하기위한 코드
					   });
					   </script>
                       </td>
                   </tr>
				  <tr>
				  	<td></td>
				  	<td></td>
				  </tr>
               </table>
               <input type="hidden" name="no" value="${adminQnAVO.no}">
               <button type="submit" class="btn btn-warning">수정완료</button>
               <button class="btn btn-danger" onClick = "backToList(this.form)">취소</button>
           </form>
        </div>
	</div>
</body>
</html>
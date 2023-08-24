<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#delete').click(function() {
			var result = confirm('삭제하시겠습니까?');
			if (result) {
				$('#boardForm').attr("action", "deleteBoard.do").submit();
			}
		});
	});
</script>
</head>
<body>
	<c:if test="${ member eq bdata.writer }">
		<form id="boardForm">
			<input type="hidden" name="bid" value="${ bdata.bid }">
			<input type="hidden" name="searchCondition" value="UPDATE">
			제목 : <input type="text" name="title" value="${ bdata.title }"><br>
			내용 : <input type="text" name="content" value="${ bdata.content }"><br>
			작성자 : <input type="text" value="${ bdata.writer }" disabled="disabled"><br>
			조회수 : <input type="text" value="${ bdata.cnt }" disabled="disabled"><br>
			<input id="update" type="submit" value="게시글 수정" formaction="updateBoard.do">
			<button id="delete" type="button">게시글 삭제</button>
		</form>
	</c:if>
	<c:if test="${ member ne bdata.writer }">
		<form>
			<input type="hidden" value="${ bdata.bid }">
			제목 : <input type="text" value="${ bdata.title }" disabled="disabled"><br>
			내용 : <input type="text" value="${ bdata.content }" disabled="disabled"><br>
			작성자 : <input type="text" value="${ bdata.writer }" disabled="disabled"><br>
			조회수 : <input type="text" value="${ bdata.cnt }" disabled="disabled"><br>
		</form>
	</c:if>
	<a href="main.do">메인으로 이동</a>
</body>
</html>
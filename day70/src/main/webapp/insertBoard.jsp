<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글작성페이지</title>
</head>
<body>

<form action="insertBoard.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="writer" value="${member}">
	<input type="text" name="title" required placeholder="제목 작성"> <br>
	<input type="text" name="content" required placeholder="내용 작성"> <br>
	<input type="file" name="fileUpload" onchange="thumnail(event);"> <br>
	<input type="submit" value="글 작성">
</form>

<hr>
<div id="thumbnailBox"></div>
<hr>

<a href="main.do">메인으로 돌아가기</a>

<script>
	function thumbnail(event) {
		var reader = new FileReader();
		reader.onload = function(event) {
			var img = document.createElement("img");
			img.setAttribute("src", event.target.result);
			document.querySelector("#thumbnailBox").appendChild(img);
		};
		reader.readAsDataURL(event.target.files[0]);
	}
</script>

</body>
</html>
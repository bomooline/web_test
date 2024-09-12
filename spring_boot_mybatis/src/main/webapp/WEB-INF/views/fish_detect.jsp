<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>fish detect test</title>
		<script src="<c:url value='/js/jquery-3.7.1.min.js' />"></script>
		<script src="<c:url value='/js/fish_detect.js' />"></script>
	</head>
	<body>
		<!-- 파일 업로드 -->
		<h3>Fish Detect Test</h3>
		 <form id="fishForm" >
			파일 : <input type="file" id="uploadFile" name="uploadFile">
			<input type="submit" value="결과 확인"><br><br>
		</form>
		<br><br>
		
		<!-- 결과 출력 -->	
		<h3>텍스트</h3>
		<div id="resultBox"></div>
		<br><br>			
		
		<a href="<c:url value='/' />">index 페이지로 이동</a>
	</body>
</html>



<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>index 페이지</title>
	</head>
	<body>
		<h3>Sping Boot - MyBatis 사용 DB 연동 : 상품 관리</h3><br>		
		
		<a href="<c:url value='/product/listAllProduct'/>">전체 상품 조회</a><br>
		<a href="<c:url value='/product/newProductForm'/>">상품 등록</a><br>
		
		<!-- 이미지 출력 -->		
		<img src="/image/apple.png"> <!--  "/"가 static 폴더 찾음 -->
		<img src="<c:url value='/image/apple.png'/>"> 
		<!-- 맵핑 이름 project_image 사용해서 이미지 출력 -->
		<img src="/prd_images/apple.png"> <!-- 주의: 맨 앞에 / 없음 -->
		<img src="<c:url value='/prd_images/apple.png'/>"> 
				
		<h3>상품 검색</h3>
		<a href="<c:url value='/product/productSearchForm1'/>">상품 검색1</a><br>
		
		<a href="<c:url value='/product/productSearchForm2'/>">상품 검색2</a><br>
		<a href="<c:url value='/product/productSearchForm3'/>">상품 검색3</a><br>
		
		<h3>파일 업로드</h3>
		<a href="<c:url value='/fileUploadForm'/>">파일 업로드</a><br>
		<a href="<c:url value='/fileDownloadList'/>">파일 다운로드</a><br><br>
		
		<a href="<c:url value='/imageFileUploadForm'/>">이미지 파일 업로드</a><br>
		<a href="<c:url value='/audioFileUploadForm'/>">오디오 파일 업로드</a><br>
		<a href="<c:url value='/recordFileUploadForm'/>">녹음 파일 업로드</a><br>
		
		<!-- 테스트  -->
		<h3>게시판</h3>
		<a href="<c:url value='/board/listAllBoard'/>">전체 게시글 조회</a><br>
	
		<!--  서버 테스트 -->
		<a href="<c:url value='/ocrForm'/>">OCR</a><br><br>
		
		<!--  파이썬 : Fish Detect 테스트 -->
		<a href="<c:url value='/fishDetectForm'/>">Fish Detect</a><br><br>
		
		<a href="<c:url value='/map' />">MAP</a><br><br>
	</body>
</html>




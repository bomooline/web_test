<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>파일 업로드 폼</title>
		<style type="text/css">
			.uploadBtn {
				background:blue;
				width:100px;
			}
		</style>
	</head>
	<body>
		<h3>파일 업로드</h3>
		<!-- 업로드 버튼 스타일 적용 -->
		<form id="fileUploadFrm" method="post" 
					action="<c:url value='/fileUpload'/>" 
					enctype="multipart/form-data">
			<label for="uploadFile">
  				<div class="uploadBtn">파일 업로드</div>
			</label>
			<input type="file" id="uploadFile" name=	"uploadFile"><br><br>
			<input type="submit" value="업로드">
		</form>
<%-- 		<form id="fileUploadFrm" method="post" 
					action="<c:url value='/fileUpload'/>" 
					enctype="multipart/form-data">
			파일 : <input type="file" id="uploadFile" name=	"uploadFile"><br><br>
			<input type="submit" value="업로드">
		</form> --%>
		
		<hr>
		<h3>여러 개의 파일 업로드</h3>
		<form id="fileUploadFrmMulti" method="post" 
					action="<c:url value='/fileUploadMultiple'/>" 
					enctype="multipart/form-data">
			파일 : <input type="file" id="uploadFileMulti" 
								name=	"uploadFileMulti" multiple="multiple"><br><br>
			<input type="submit" value="업로드">
		</form>
		
		
		<hr>
		<h3>파일명 변경하지않고 파일 업로드</h3>
		<form id="fileOriginalNameUploadForm" method="post" 
					action="<c:url value='/fileOriginalNameUpload'/>" 
					enctype="multipart/form-data">
			파일 : <input type="file" id="uploadFileOriginal" 
								name=	"uploadFileOriginal"><br><br>
			<input type="submit" value="업로드">
		</form>
	</body>
</html>
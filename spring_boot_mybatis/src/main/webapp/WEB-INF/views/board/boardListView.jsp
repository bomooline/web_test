<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>전제 게시글 조회</title>		 
		<link rel="stylesheet"   type="text/css"  href="<c:url value='/css/board.css'/>">
	</head>
	<body>
		<h3>전체 게시글 조회</h3>		
		<table border="1" width="600">
			<table border="1" width="600">
			<tr><th>글번호</th>
			<th>제목</th>
			<th>작성일</th>
			<th>작성자</th>
			<th>내용</th>
			
			<!-- 반복문 사용해서 모든 데이터 출력 -->			
			<!-- 날짜 포맷 설정 : 2024-05-10 형식 -->
			<c:forEach items="${ boardList }" var="board">
			<tr>
				<td>${board.bNo}</td>
				<td>${board.bTitle}</td>
				<td><fmt:formatDate value="${board.bDate}" pattern="YYYY-MM-dd" /></td>
				<td>${board.bWriter}</td>
				<td>${board.bContent}</td>				
			</tr>
			</c:forEach>			
		</table><br><br>
		
		<div style="text-align:center;">
			<a  onclick="javascript:goPage(1)">&lt;&lt;</a>
			<a onclick="javascript:goPage('prev')">이전</a>
			
			<c:forEach var="i" begin="${pageVo.startPage }" end="${pageVo.endPage }">
				<a onclick="javascript:goPage('${i}')">${i }</a>
			</c:forEach>			
		
			<a onclick="javascript:goPage('next')">다음</a>
			<a onclick="javascript:goPage('${pageVo.totalPage }')"> &gt;&gt;</a>
		</div>
		<form name="pageFrm">
			<input type="hidden" name="pageNo" value="${pageVo.pageNo }">
		</form>
		<script>
			function goPage(no) {
				const frm = document.pageFrm;
				//alert(frm.pageNo.value);
				
				if(no == "prev") {
					no = frm.pageNo.value - 1;
					if(no <= 0) no = 1;
				} else if(no == "next") {
					no = parseInt(frm.pageNo.value) + 1;					
				}
				
				//alert(no);
				
				frm.action = "/board/listAllBoard";	
				frm.pageNo.value=no;
				frm.submit();
			}
		</script>
		
		<!--  index 페이지로 이동 링크 추가 -->
		<a href="<c:url value='/' />">홈으로 이동</a>
	</body>
</html>
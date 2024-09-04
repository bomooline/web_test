/**
 * ocr.js
 */
 
 $(document).ready(function() {
	$('#ocrForm').on('submit', function(){
 		// submit 이벤트 기본 기능 : 페이지 새로 고침
 		// 기본 기능 중단
 		event.preventDefault();
 		
 		// 업로드된 파일명 알아오기
 		var fileName = $('#uploadFile').val().split("\\").pop();
 		// alert(fileName);

 		// 폼 데이터 읽어 오기
 		var formData = new FormData($('#ocrForm')[0]); 
 		
 		$.ajax({
 			type:"post",
 			url:"/ocr",
 			enctype: 'multipart/form-data',
 			processData:false,
 			contentType:false,
 			data:formData,
			success:function(result){ 				
 				$('#resultBox').text(result);
 				
 				$('#imageBox').empty();
 				$('#imageBox').append('<img src="/images/'+fileName+'">');
			},
			error:function(){
				alert("실패");
			},
 		}); // ajax 끝
 	}); // submit 끝
});
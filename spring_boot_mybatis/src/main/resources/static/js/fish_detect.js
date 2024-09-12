/**
 * fish_detect.js
 */
 
 $(document).ready(function() {
	$('#fishForm').on('submit', function(){ 		
 		event.preventDefault();
 		
 		// 업로드된 파일명 알아오기
 		//let fileName = $('#uploadFile').val().split("\\").pop(); 		

 		// 폼 데이터 읽어 오기
 		let formData = new FormData($('#fishForm')[0]); 		
 				
 		$.ajax({
 			type:"post",
 			//url:"http://127.0.0.1:8000/file_upload/",  
 			url:"http://127.0.0.1:8080/file_upload",  
 			enctype: 'multipart/form-data',
 			processData:false,
 			contentType:false,
 			data:formData,
			success:function(result){ 				
 				console.log(result);	
				console.log(result.result);	
				//$('#resultBox').text(result.result);
				$('#resultBox').text(result);
			},
			error:function(){
				alert("실패");
			},
 		}); // ajax 끝
 		
 	}); // submit 끝
});
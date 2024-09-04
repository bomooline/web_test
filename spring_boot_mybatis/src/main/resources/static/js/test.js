 $(document).ready(function() {
 	
 	let btn = $('.btn');
 	
 	$('.btn').on('click', function() {
 		console.log($(this).data("value"));
 		let span = document.getElementById($(this).data("value")); 		
 		span.innerHTML = $(this).data("value");
 	}); //  끝
 
 });
 
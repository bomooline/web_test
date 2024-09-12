

window.onload = function(){
	// (4) 마커 위에 정보 창 올리기
	var cityhall = new naver.maps.LatLng(37.5666805, 126.9784147);

	var map = new naver.maps.Map('map', {
	    center: new naver.maps.LatLng(37.5698411, 126.9783927),
	    zoom: 10
	});
	
	var contentString = [
	    '<div class="iw_inner">',
	    '   <h3>서울특별시청</h3>',
	    '   <p>서울특별시 중구 태평로1가 31 | 서울특별시 중구 세종대로 110 서울특별시청<br>',
	    '       <img src="./img/hi-seoul.jpg" width="55" height="55" alt="서울시청" class="thumb" /><br>',
	    '       02-120 | 공공,사회기관 > 특별,광역시청<br>',
	    '       <a href="http://www.seoul.go.kr" target="_blank">www.seoul.go.kr/</a>',
	    '   </p>',
	    '</div>'
	].join('');
	
	/*
	//(1) 마커만 표시하는 경우
	var marker = new naver.maps.Marker({
	    map: map,
	    position: cityhall
	});
	*/
	
	//(2) 마커 커스터마이징 : '마커 + 텍스트' 표시
	let iconTitle = "서울시정";
	
	const iconStyle = `
			<div style="background-color:pink;">
				<img src="/images/apple.png" width="30" height="30">
				${iconTitle}		
			</div>
	`;
	
	var markerOptions = {
    	position: cityhall,
    	map: map,
    	icon: {
    		content: [iconStyle].join(''),
        	//url: '/images/apple.png',
       	 	size: new naver.maps.Size(50, 66),
        	origin: new naver.maps.Point(0, 0),
        	anchor: new naver.maps.Point(11, 35)
    	}
	};

	var marker = new naver.maps.Marker(markerOptions);
	
	var infowindow = new naver.maps.InfoWindow({
	    content: contentString
	});
	
	naver.maps.Event.addListener(marker, "click", function(e) {
	    if (infowindow.getMap()) {
	        infowindow.close();
	    } else {
	        infowindow.open(map, marker);
	    }
	});
	
};


/*
 (1) 서울 시청 
 // 37.5666103, 126.9783882 (서울 시청)
// 37.3595704, 127.105399 (분당)
	
 var mapOptions = {
	    center: new naver.maps.LatLng(37.5666103, 126.9783882),
	    zoom: 10
	};
	
	var map = new naver.maps.Map('map', mapOptions);
*/

/*
	// (2) 지도 옵션 조정
	//지도 생성 시에 옵션을 지정할 수 있습니다.
	var map = new naver.maps.Map('map', {
	        center: new naver.maps.LatLng(37.3595704, 127.105399), //지도의 초기 중심 좌표
	        zoom: 13, //지도의 초기 줌 레벨
	        minZoom: 7, //지도의 최소 줌 레벨
	        zoomControl: true, //줌 컨트롤의 표시 여부
	        zoomControlOptions: { //줌 컨트롤의 옵션
	            position: naver.maps.Position.TOP_RIGHT
	        }
	    });
	    
	 // (3) 마커 표시
	 var marker = new naver.maps.Marker({
	    position: new naver.maps.LatLng(37.3595704, 127.105399),
	    map: map
	});
*/
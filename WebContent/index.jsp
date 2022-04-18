<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8"/>
<!DOCTYPE html>
<html>
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Happy House</title>
    
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3e67d82bfe3b34b4a506801a19e581ae&libraries=services,clusterer,drawing"></script>
    <link rel="stylesheet" href="css/main.css" />
   </head>
 <body>
	<div class="b-example-divider"></div>

	<div class="container">
		<header
			class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
			<a href="#"
				class="d-flex align-items-center col-md-2 mb-2 mb-md-0 text-dark text-decoration-none">
				<svg class="bi me-2" width="40" height="32" role="img"
					aria-label="Bootstrap">
					<use xlink:href="#bootstrap" /></svg>
			</a> <a href="#"
				class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
				<svg class="bi me-2" width="20" height="32">
					<use xlink:href="#bootstrap" /></svg> <span class="fs-4">Happy
					House</span>
			</a>

			<ul
				class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
				<li><a href="./main?action=notice" class="nav-link px-2 link-secondary">공지사항</a></li>
				<li><a href="#" class="nav-link px-2 link-dark">오늘의 뉴스</a></li>
				<li><a href="#" class="nav-link px-2 link-dark">주변 탐방</a></li>
				<li><a href="#" class="nav-link px-2 link-dark">관심지역 설정</a></li>
				<li><a href="#" class="nav-link px-2 link-dark">관심지역 둘러보기</a></li>
			</ul>
			<c:if test="${empty userInfo}">
				<div class="col-md-3 text-end">
					<button type="button" class="btn btn-outline-primary me-2"
						id="buttonLogin" onclick="location.href='login.jsp';">Login</button>
					<button type="button" class="btn btn-primary"
						onclick="location.href='signUp.jsp'">Sign-up</button>
				</div>
			</c:if>
			<c:if test="${not empty userInfo}">
				<div class="col-md-3 text-end">
					<button type="button" class="btn btn-outline-primary me-2"
						id="buttonLogout" onclick="location.href='./main?action=logout'">Logout</button>
				</div>
			</c:if>
		</header>
	</div>

	<div class="text-center">
		<img src="img/1.JPG" alt="..." height="500px" width="900px">
	</div>
	 <form action="main">
		<input type="hidden" name="action" value="searchBydongCode">
		<div class="col-5 mt-3 my-3"
			style="float: none; margin: 0 auto; display: flex;">

			<select class="form-select form-select-sm form-control input-sm"
				id="do" aria-label=".form-select-sm example">
				<option value="">도/광역시</option>
			</select> <select class="form-select form-select-sm form-control input-sm"
				id="goo" aria-label=".form-select-sm example">
				<option value="">시/구/군</option>

			</select> <select name="dongCode"
				class="form-select form-select-sm form-control input-sm" id="dong"
				aria-label=".form-select-sm example">
				<option value="">동</option>
			</select>

			<!--        <select class="form-select form-select-sm form-control input-sm" id="apartment" aria-label=".form-select-sm example">
        <option selected>아파트</option>
      </select>  -->
			<button class="btn btn-outline-secondary" type="submit" id="apartment">검색</button>
		</div>
	</form>

	<!-- 아파트별 조회  -->
      <form action="main">
      <input type="hidden" name="action" value="searchByAptName">
      <div class="col-5 mb-5" style="margin: auto;">
        <div class="input-group">
          <input type="text" class="form-control" placeholder="아파트명 입력" aria-label="Recipient's username"
            aria-describedby="button-addon2" name="aptName" id="apartment">
          <button  class="btn btn-outline-secondary" type="submit" id=>검색</button>
        </div>
      </div>
      </form>
      <br />
	
    <script type="text/javascript" src="js/main.js"></script>

    <div class="b-example-divider"></div>
  <div class="d-flex flex-column align-items-stretch flex-shrink-0 bg-white" style="width: 380px; float: left;">
    <a href="#" class="d-flex align-items-center flex-shrink-0 p-3 link-dark text-decoration-none border-bottom">
      <svg class="bi me-2" width="30" height="24"><use xlink:href="#bootstrap"/></svg>
      <span class="fs-5 fw-semibold">거래 정보</span>
    </a>
    <div class="list">
    
    <c:if test="${not empty aptInfoList}">
	   	<c:forEach var="aptInfo" items="${aptInfoList}">
	   	<a href="javascript:test(${aptInfo.lat}, ${aptInfo.lng})" class="list-group-item list-group-item-action active py-3 lh-tight" aria-current="true">
		   	<div class="d-flex w-100 align-items-center justify-content-between">
	           <strong class="mb-1">${aptInfo.aptName}</strong>
           </div>
           <script>
           </script>
			<div class="col-10 mb-1 small">거래 금액: ${aptInfo.dealAmount}</div>
			<div class="col-10 mb-1 small">전용면적: ${aptInfo.area}㎡</div>
			<div class="col-10 mb-1 small">거래일: ${aptInfo.dealYear}.${aptInfo.dealMonth}.${aptInfo.dealDay}</div>
			<div class="col-10 mb-1 small">동: ${aptInfo.dongName} </div>
			<div class="col-10 mb-1 small">위도: ${aptInfo.lat} </div>
			<div class="col-10 mb-1 small">경도: ${aptInfo.lng} </div>
			
	   </a>
		</c:forEach>
    </c:if>
        <c:if test="${empty aptInfoList}">
    		<div class="col-10 mb-1 small">검색 결과가 없습니다.</div>
    	</c:if>
    </div>
  </div>
  
  <div id="map" style="width:1000px;height:700px; float:left; margin:100px" ></div>
	
  <h2 style=" text-align: center; margin: 50px;">지혜롭게 내 집 마련하기</h2>
  <div class="list-group" style=" margin: 50px">
    <a href="#" class="list-group-item list-group-item-action d-flex gap-3 py-3" aria-current="true">
      <img src="img/house1.jpg" alt="twbs" width="32" height="32" class="rounded-circle flex-shrink-0">
      <div class="d-flex gap-2 w-100 justify-content-between">
        <div>
          <h6 class="mb-0">주택 청약 통장</h6>
          <p class="mb-0 opacity-75">청약 통장 가입 방법과 조건 소개</p>
        </div>
        <small class="opacity-50 text-nowrap">now</small>
      </div>
    </a>
    <a href="#" class="list-group-item list-group-item-action d-flex gap-3 py-3" aria-current="true">
      <img src="img/house1.jpg" alt="twbs" width="32" height="32" class="rounded-circle flex-shrink-0">
      <div class="d-flex gap-2 w-100 justify-content-between">
        <div>
          <h6 class="mb-0">부동산 투자의 원칙</h6>
          <p class="mb-0 opacity-75">명강사 00씨가 알려주는 부동산 투자의 대원칙</p>
        </div>
        <small class="opacity-50 text-nowrap">3d</small>
      </div>
    </a>
    <a href="#" class="list-group-item list-group-item-action d-flex gap-3 py-3" aria-current="true">
      <img src="img/house1.jpg" alt="twbs" width="32" height="32" class="rounded-circle flex-shrink-0">
      <div class="d-flex gap-2 w-100 justify-content-between">
        <div>
          <h6 class="mb-0">청년안심주택</h6>
          <p class="mb-0 opacity-75">청년안심주택 정책 소개</p>
        </div>
        <small class="opacity-50 text-nowrap">1w</small>
      </div>
    </a>
  </div>

  <h2 style=" text-align: center; margin: 50px;">오늘의 뉴스</h2>
  <div class="list-group" style="margin: 50px">
    <a href="#" class="list-group-item list-group-item-action d-flex gap-3 py-3" aria-current="true">
      <img src="img/house1.jpg" alt="twbs" width="32" height="32" class="rounded-circle flex-shrink-0">
      <div class="d-flex gap-2 w-100 justify-content-between">
        <div>
          <h6 class="mb-0">서울 아파트 가파른 상승세</h6>
        </div>
        <small class="opacity-50 text-nowrap">now</small>
      </div>
    </a>
    <a href="#" class="list-group-item list-group-item-action d-flex gap-3 py-3" aria-current="true">
      <img src="img/house1.jpg" alt="twbs" width="32" height="32" class="rounded-circle flex-shrink-0">
      <div class="d-flex gap-2 w-100 justify-content-between">
        <div>
          <h6 class="mb-0">2022 대선의 트렌드</h6>
        </div>
        <small class="opacity-50 text-nowrap">3d</small>
      </div>
    </a>
    <a href="#" class="list-group-item list-group-item-action d-flex gap-3 py-3" aria-current="true">
      <img src="img/house1.jpg" alt="twbs" width="32" height="32" class="rounded-circle flex-shrink-0">
      <div class="d-flex gap-2 w-100 justify-content-between">
        <div>
          <h6 class="mb-0">변모할 부동산 정책은 ..? </h6>
        </div>
        <small class="opacity-50 text-nowrap">1w</small>
      </div>
    </a>
  </div>

  <footer class="footer mt-auto py-3 bg-light" >
    <div class="container">
      <span class="text-muted" style="font-weight: bolder">SSAFY</span>
      <br>
      <span class="text-muted">주소: 서울시 강남구 테헤란로 멀티스퀘어</span>
      <br>
      <span class="text-muted">전화번호: 1544-9001</span>
      <br>
      <span class="text-muted">ssafy@ssafy.com</span>
    </div>
  </footer>
	

	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3e67d82bfe3b34b4a506801a19e581ae"></script>
	<script>

		var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
		mapOption = {
			center : new kakao.maps.LatLng(37.55561040965739,
					126.99495250145412), // 지도의 중심좌표
			level : 7
		// 지도의 확대 레벨
		};

		var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

		// 마커를 표시할 위치와 title 객체 배열입니다 
		var positions = [
					{
					title : '근린공원',
					latlng : new kakao.maps.LatLng(37.54561040965739,
							126.99495250145412)
				} ];

		// 마커 이미지의 이미지 주소입니다
		var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

		for (var i = 0; i < positions.length; i++) {

			// 마커 이미지의 이미지 크기 입니다
			var imageSize = new kakao.maps.Size(24, 35);

			// 마커 이미지를 생성합니다    
			var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

			// 마커를 생성합니다
			var marker = new kakao.maps.Marker({
				map : map, // 마커를 표시할 지도
				position : positions[i].latlng, // 마커를 표시할 위치
				title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
				image : markerImage
			// 마커 이미지 
			});
		}
		
		function test(lat,lng){
	
			alert("지도에 표시합니다.")
			var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
			mapOption = {
				center : new kakao.maps.LatLng(lat,
						lng), // 지도의 중심좌표
				level : 7
			// 지도의 확대 레벨
			};

			var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

			// 마커를 표시할 위치와 title 객체 배열입니다 
			var positions = [ {
				title : '건물',
				latlng : new kakao.maps.LatLng(lat, lng)
			} ]

			// 마커 이미지의 이미지 주소입니다
			var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

			for (var i = 0; i < positions.length; i++) {

				// 마커 이미지의 이미지 크기 입니다
				var imageSize = new kakao.maps.Size(24, 35);

				// 마커 이미지를 생성합니다    
				var markerImage = new kakao.maps.MarkerImage(imageSrc,
						imageSize);

				// 마커를 생성합니다
				var marker = new kakao.maps.Marker({
					map : map, // 마커를 표시할 지도
					position : positions[i].latlng, // 마커를 표시할 위치
					title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
					image : markerImage
				// 마커 이미지 
				});
			}
		}
	</script>
	
  </body>
</html>
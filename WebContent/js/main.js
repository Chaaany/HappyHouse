$(function () {
    var x;

    loadData(0, "");        //초기 디폴트 리스트
    /*loadMap("",0);*/
    sendRequest("do", "*00000000");

    $('#do').change(function () {
        regcode = $(this).val().substr(0, 2) + "*00000";
        console.log("sido select regcode : " + regcode);
        $("#goo").empty();
        $("#dong").empty().append("<option>동선택</option>");
        sendRequest("goo", regcode);
    });

    $('#goo').change(function () {
        regcode = $(this).val().substr(0, 5) + "*";
        console.log("gugun select regcode : " + regcode);
        sendRequest("dong", regcode);
    });

    $('#dong').change(function () {
        var aptSet = new Set();
        var dong_name = $('#dong option:selected').text();
        loadData(1, dong_name); //동별 조회
        var dong = $('#dong option:selected').text();
        $(this).nextAll().empty();
        let aptDiv = document.querySelector("select#apartment");  //아파트 select 만들기
        aptDiv.innerHTML += `<option selected>아파트</option>`;
        for (i = 0; i < x.length; i++) {
            var aptDong = x[i].getElementsByTagName("dong")[0].childNodes[0].nodeValue.trim();
            if (aptDong != dong) continue;
            var aptName = x[i].getElementsByTagName("apt")[0].childNodes[0].nodeValue;
            if (aptSet.has(aptName)) continue;
            else aptSet.add(aptName);
            let aptList = `<option value="${i}">${aptName}</option>`
            aptDiv.innerHTML += aptList;
        }
    });


    function sendRequest(selid, regcode) {
        console.log("regcode : " + regcode);
        $.ajax({
            url: "https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes",
            type: "GET",
            data: {
                regcode_pattern: regcode,
                is_ignore_zero: true,
            },
            dataType: "json",
            success: function (response) {
                console.log(response);
                addOption(selid, response);
            },
            error: function (xhr, status, msg) {
                console.log("상태값 : " + status + " Http에러메시지 : " + msg);
            },
        });
    }

    function addOption(selid, data) {
        let code = ``;
        let initOption = ``;
        switch (selid) {
            case "do":
                initOption = `<option>시도선택</option>`;
                $("#do").empty().append(initOption);
                $.each(data.regcodes, function (i, regcode) {
                    code += `
          <option value="${regcode.code}">${regcode.name.split(" ")[0]}</option>
          `;
                });
                break;
            case "goo":
                initOption = `<option>구군선택</option>`;
                $("#goo").empty().append(initOption);
                console.log(data.regcodes);
                for (let i = 0; i < data.regcodes.length; i++) {
                    if (i != data.regcodes.length - 1) {
                        if (
                            data.regcodes[i].name.split(" ")[1] == data.regcodes[i + 1].name.split(" ")[1] &&
                            data.regcodes[i].name.split(" ").length !=
                            data.regcodes[i + 1].name.split(" ").length
                        ) {
                            data.regcodes.splice(i, 1);
                            i--;
                        }
                    }
                }
                console.log(data.regcodes);
                let name = "";
                $.each(data.regcodes, function (i, regcode) {
                    if (regcode.name.split(" ").length == 2) name = regcode.name.split(" ")[1];
                    else name = regcode.name.split(" ")[1] + " " + regcode.name.split(" ")[2];
                    code += `
          <option value="${regcode.code}">${name}</option>
          `;
                });
                break;
            case "dong":
                initOption = `<option>동선택</option>`;
                $("#dong").empty().append(initOption);
                let idx = 2;
                $.each(data.regcodes, function (i, regcode) {
                    if (data.regcodes[i].name.split(" ").length != 3) idx = 3;
                    code += `
          <option value="${regcode.code}">${regcode.name.split(" ")[idx]}</option>
          `;
                });
                break;
        }
        $("#" + selid).append(code);
    }

    var apt_name;

    $('#apartment').onclick(function () {
        apt_name = $('#apartment option:selected').text();
        loadData(2, apt_name);
        var addr=$("#do option:selected").text()+" "+$("#goo option:selected").text()+" "+$("#dong option:selected").text()+" ";
        loadMap(addr,0);
    })

    function loadData(code, name) {
        var xhr = new XMLHttpRequest();
        var url_ = '../res/AptDealHistory.xml'
        xhr.open('GET', url_, true);
        xhr.setRequestHeader('Content-Type', 'application/xml');
        xhr.onreadystatechange = function () {
            if (this.readyState == 4) {
                if (xhr.status == 200) {
                    if (code == 0) {
                        makeListAll(xhr, name);   //매매만??
                    }
                    else if (code == 1) {
                        makeDongList(xhr, name); //동별 조회
                    }
                    else if (code == 2) {
                        makeAptList(xhr, name); //아파트별 조회
                    }
                }
            }
        }
        xhr.send();
    }

    function makeListAll(xml, name) {      //전체 조회(default)
        var i;
        var xmlDoc = xml.responseXML;
        x = xmlDoc.getElementsByTagName("item");
        let list = document.querySelector(".list");
        for (i = 0; i < x.length; i++) {
            var aptName = x[i].getElementsByTagName("apt")[0].childNodes[0].nodeValue;
            var aptPrice = x[i].getElementsByTagName("price")[0].childNodes[0].nodeValue;
            var aptArea = x[i].getElementsByTagName("area")[0].childNodes[0].nodeValue;
            var aptDate = x[i].getElementsByTagName("year")[0].childNodes[0].nodeValue + "." +
                x[i].getElementsByTagName("month")[0].childNodes[0].nodeValue + "." +
                x[i].getElementsByTagName("day")[0].childNodes[0].nodeValue;
            var aptDong = x[i].getElementsByTagName("dong")[0].childNodes[0].nodeValue;
            let aptItem = `
            <div class="list-group list-group-flush border-bottom scrollarea">
            <a href="#" class="list-group-item list-group-item-action active py-3 lh-tight" aria-current="true">
            <div class="d-flex w-100 align-items-center justify-content-between">
            <strong class="mb-1">${aptName}</strong>
            </div>
            <div class="col-10 mb-1 small">거래 금액: ${aptPrice}</div>
            <div class="col-10 mb-1 small">전용면적: ${aptArea}㎡</div>
            <div class="col-10 mb-1 small">거래구분: 아파트 매매</div>
            <div class="col-10 mb-1 small">거래일: ${aptDate}</div>
            <div class="col-10 mb-1 small">동: ${aptDong}</div>
            </a>
            </div>
            `;
            list.innerHTML += aptItem;
        }
    }

    var aptList=[];

    function makeDongList(xml, dong) {      //동별 조회
        var i;
        var xmlDoc = xml.responseXML;
        var x = xmlDoc.getElementsByTagName("item");
        let list = document.querySelector(".list");
        $(".list").empty();
        console.log("hihi");
        aptList.length=0;
        for (i = 0; i < x.length; i++) {
            var aptDong = x[i].getElementsByTagName("dong")[0].childNodes[0].nodeValue.trim();
            if (dong != aptDong) continue;
            var aptName = x[i].getElementsByTagName("apt")[0].childNodes[0].nodeValue;
            var aptPrice = x[i].getElementsByTagName("price")[0].childNodes[0].nodeValue;
            var aptArea = x[i].getElementsByTagName("area")[0].childNodes[0].nodeValue;
            var aptDate = x[i].getElementsByTagName("year")[0].childNodes[0].nodeValue + "." +
                x[i].getElementsByTagName("month")[0].childNodes[0].nodeValue + "." +
                x[i].getElementsByTagName("day")[0].childNodes[0].nodeValue;
            let aptItem = `
            <div class="list-group list-group-flush border-bottom scrollarea">
            <a href="#" class="list-group-item list-group-item-action active py-3 lh-tight" aria-current="true">
            <div class="d-flex w-100 align-items-center justify-content-between">
            <strong class="mb-1">${aptName}</strong>
            </div>
            <div class="col-10 mb-1 small">거래 금액: ${aptPrice}</div>
            <div class="col-10 mb-1 small">전용면적: ${aptArea}㎡</div>
            <div class="col-10 mb-1 small">거래구분: 아파트 매매</div>
            <div class="col-10 mb-1 small">거래일: ${aptDate}</div>
            <div class="col-10 mb-1 small">동: ${aptDong}</div>
            </a>
            </div>
            `;
            aptList.push(aptName);
            list.innerHTML += aptItem;
        }
        var addr=$("#do option:selected").text()+" "+$("#goo option:selected").text()+" "+$("#dong option:selected").text()+" ";
        loadMap(addr,1);

    }


    function makeAptList(xml, name) {      //아파트별 조회
        var i;
        var xmlDoc = xml.responseXML;
        var x = xmlDoc.getElementsByTagName("item");
        let list = document.querySelector(".list");
        $(".list").empty();
        for (i = 0; i < x.length; i++) {
            var aptName = x[i].getElementsByTagName("apt")[0].childNodes[0].nodeValue;
            if (aptName != name) continue;
            var aptDong = x[i].getElementsByTagName("dong")[0].childNodes[0].nodeValue.trim();
            var aptPrice = x[i].getElementsByTagName("price")[0].childNodes[0].nodeValue;
            var aptArea = x[i].getElementsByTagName("area")[0].childNodes[0].nodeValue;
            var aptDate = x[i].getElementsByTagName("year")[0].childNodes[0].nodeValue + "." +
                x[i].getElementsByTagName("month")[0].childNodes[0].nodeValue + "." +
                x[i].getElementsByTagName("day")[0].childNodes[0].nodeValue;
            let aptItem = `
            <div class="list-group list-group-flush border-bottom scrollarea">
            <a href="#" class="list-group-item list-group-item-action active py-3 lh-tight" aria-current="true">
            <div class="d-flex w-100 align-items-center justify-content-between">
            <strong class="mb-1">${aptName}</strong>
            </div>
            <div class="col-10 mb-1 small">거래 금액: ${aptPrice}</div>
            <div class="col-10 mb-1 small">전용면적: ${aptArea}㎡</div>
            <div class="col-10 mb-1 small">거래구분: 아파트 매매</div>
            <div class="col-10 mb-1 small">거래일: ${aptDate}</div>
            <div class="col-10 mb-1 small">동: ${aptDong}</div>
            </a>
            </div>
            `;
            list.innerHTML += aptItem;
        }
    }

    function loadMap(addr,code) {
        var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
            mapOption = {
                center: new kakao.maps.LatLng(37.55561040965739, 126.99495250145412), // 지도의 중심좌표
                level: 6 // 지도의 확대 레벨
            };
        // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
        var map = new kakao.maps.Map(mapContainer, mapOption);
        mark(map, addr,code);
    }

    var ji="";

    function mark(map, addr,code) {
        console.log("hi");
        //addr+지번 해서 찾기
        //apt_name으로 지번 찾기
        getJibun(map, apt_name, addr,code);
        // 마커 이미지의 이미지 주소입니다
        /*
        var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";
        for (var i = 0; i < positions.length; i++) {
            if (positions[i].title == loc) {
                // 마커 이미지의 이미지 크기 입니다
                var imageSize = new kakao.maps.Size(24, 35);

                // 마커 이미지를 생성합니다    
                var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

                // 마커를 생성합니다
                var marker = new kakao.maps.Marker({
                    map: map, // 마커를 표시할 지도
                    position: positions[i].latlng, // 마커를 표시할 위치
                    title: positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
                    image: markerImage // 마커 이미지 
                });
                break;
            }
        }
        */
    }

    function getJibun(map, apt_name, addr, code){
        var xhr = new XMLHttpRequest();
        var url_ = '../res/AptInfo.xml'
        xhr.open('GET', url_, true);
        xhr.setRequestHeader('Content-Type', 'application/xml');
        xhr.onreadystatechange = function () {
            if (this.readyState == 4) {
                    if (xhr.status == 200) {
                        if (code==0)
                            getJibun2(map, xhr.responseXML, apt_name, addr);
                        else if (code==1)
                            makeDongApts(map, xhr.responseXML, addr);
                }
            }
        }
        xhr.send();
    }

    function makeDongApts(map, xmlDoc, addr){
        list=[]
        var x = xmlDoc.getElementsByTagName("item");
        for (var j=0; j<aptList.length; j++){
            for (i = 0; i < x.length; i++) {
                var aptName = x[i].getElementsByTagName("아파트")[0].childNodes[0].nodeValue.trim();
                if (aptName != aptList[j]) continue;
                if (aptList[j]==aptName){
                    ji=x[i].getElementsByTagName("지번")[0].childNodes[0].nodeValue.trim();
                    list.push(addr+ji);
                    break;
                }
            }   
        }
        var geocoder = new kakao.maps.services.Geocoder();
        var positions=[];
        for (var j=0; j<list.length; j++){
            console.log(list[j]);
            geocoder.addressSearch(list[j], function(result, status) {

                // 정상적으로 검색이 완료됐으면 
                 if (status === kakao.maps.services.Status.OK) {
            
                    var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
            
                    positions.push({
                        title: list[j],
                        latlng: coords,
                    })
            
                    // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
                    map.setCenter(coords);
                } 
            });  
            console.log(positions[-1]);  
        }
        for (var i=0; i<positions.length; i++){
            console.log("경로:"+positions[i]);
        }
        for (var i = 0; i < positions.length; i ++) {
            console.log("표시");
            // 마커 이미지의 이미지 크기 입니다
            var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
            var imageSize = new kakao.maps.Size(24, 35); 
            
            // 마커 이미지를 생성합니다    
            var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
            console.log("2939399339");
            // 마커를 생성합니다
            var marker = new kakao.maps.Marker({
                map: map, // 마커를 표시할 지도
                position: positions[i].latlng, // 마커를 표시할 위치
                image : markerImage // 마커 이미지 
            });
        }
        
    }

    function getJibun2(map, xmlDoc, apt_name, addr){
        var x = xmlDoc.getElementsByTagName("item");
        for (i = 0; i < x.length; i++) {
            var aptName = x[i].getElementsByTagName("아파트")[0].childNodes[0].nodeValue.trim();
            if (aptName != apt_name) continue;
            if (aptName==apt_name){
                console.log(aptName+" "+apt_name);
                ji=x[i].getElementsByTagName("지번")[0].childNodes[0].nodeValue.trim();
                break;
            }
        }
        let addr1=addr+ji;
        console.log(addr1);
        
        var geocoder = new kakao.maps.services.Geocoder();

        // 주소로 좌표를 검색합니다
        geocoder.addressSearch(addr1, function(result, status) {
        
            // 정상적으로 검색이 완료됐으면 
             if (status === kakao.maps.services.Status.OK) {
        
                var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
        
                // 결과값으로 받은 위치를 마커로 표시합니다
                var marker = new kakao.maps.Marker({
                    map: map,
                    position: coords
                });
        
                // 인포윈도우로 장소에 대한 설명을 표시합니다
                var infowindow = new kakao.maps.InfoWindow({
                    content: `<div style="width:150px;text-align:center;padding:6px 0;">${apt_name}</div>`
                });
                infowindow.open(map, marker);
        
                // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
                map.setCenter(coords);
            } 
        });    

    }

});

var btnLogin = document.getElementById("buttonLogin");
var loginToken = document.getElementById("buttonLogin").getAttribute("loginToken");
window.onload=function(){
    if (localStorage.getItem("loginT")) {
        loginToken = localStorage.getItem("loginT");
        document.getElementById("buttonLogin").setAttribute("loginToken", loginToken);
    };

    loginToken = document.getElementById("buttonLogin").getAttribute("loginToken");
    if (loginToken === "false") {
        btnLogin.innerText = 'Login';
        
    } else if(loginToken === "true"){
        btnLogin.innerText = 'Logout';
        $('ul li:nth-child(3)').show();
        $('ul li:nth-child(4)').show();
        $('ul li:nth-child(5)').show();
    };
}

function loginTokenSend() {
    loginToken=document.getElementById("buttonLogin").getAttribute("loginToken");
    
    if (loginToken === "false") {
        localStorage.setItem("loginToken", loginToken);
        location.href='login.html';
    }
    else if (loginToken === "true") {
        loginToken="false";
        localStorage.setItem("loginToken", loginToken);
        document.getElementById("buttonLogin").setAttribute("loginToken", loginToken);
        alert("로그아웃 완료");
        btnLogin.innerText = 'Login';
        $('ul li:nth-child(3)').hide();
        $('ul li:nth-child(4)').hide();
        $('ul li:nth-child(5)').hide();
    }
}




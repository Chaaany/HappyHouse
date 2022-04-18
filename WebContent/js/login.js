var loginT;
if(localStorage.getItem("loginToken")){
  loginT=localStorage.getItem("loginToken");
}
console.log(loginT);

// Ajax 요청 객체 생성
var xmlHttp;
if(window.XMLHttpRequest){
  xmlHttp=new XMLHttpRequest;
} else {
  xmlHttp=new ActiveXObject('microsoft.XMLHTTP');
}

// Ajax 요청
xmlHttp.open("GET","/data/users.xml");
xmlHttp.send();

var uid = [];
var upw = [];
//준비 상태가 바뀌면
xmlHttp.onreadystatechange=function(){
  if(xmlHttp.readyState==4){
    if(xmlHttp.status>=200 && xmlHttp.status<300){
      var xmlDoc=xmlHttp.responseXML;
      var uids=xmlDoc.getElementsByTagName("id");
      var upws=xmlDoc.getElementsByTagName("password");
      for (var i = 0; i < uids.length; i++) {
        uid[i] = uids[i].childNodes[0].nodeValue;
        upw[i] = upws[i].childNodes[0].nodeValue;
      }
      //요청하는게 xml이면 responseXML 일반텍스트면 response
    } else {
    alert(xmlHttp.status);
    }
  }
}

// 가입부분 체크
function loginCheck() {

  let id = document.getElementById("id").value
  let pw = document.getElementById("pw").value
  let check = true;
  let unum=-1;
  let isInXML=false;

  console.log("id : " + id);
  console.log("password : " + pw);
  
  // 아이디 확인
  if (id === "") {
    document.getElementById("idError").innerHTML = "아이디를 입력해주세요."
    check = false
  } else {
    document.getElementById("idError").innerHTML = ""
  }

  for(var i=0; i<uid.length; i++){
    if(id === uid[i]) {
        unum=i;
        isInXML=true;
        break;
    }
  }

  console.log("hi");

  for (i=0; i<localStorage.length; i++){
    let key=localStorage.key(i);
    if (!Number.isInteger(parseInt(key))){
      if (key=='user'){
        let data=JSON.parse(localStorage.getItem(key));
        console.log("아이디"+data.id);
        if (data.id==id){
          unum=1;
        }
      }
    }
  }

  if (id !== "" && unum === -1){
    document.getElementById("idError").innerHTML = "존재하지 않는 아이디입니다."
    check=false;
  } else if(id !== "") {
    document.getElementById("idError").innerHTML = ""
  }

  

  // 비밀번호 확인
  if (pw === "") {
    document.getElementById("pwError").innerHTML = "비밀번호를 입력해주세요."
    check = false
  } else {
    if(unum!==-1 && isInXML==true && pw!==upw[unum]){
      document.getElementById("pwError").innerHTML = "비밀번호가 일치하지 않습니다."
      check = false
    } 
    else if (unum!==-1 && isInXML==false && pw!==JSON.parse(localStorage.getItem('user')).password){
      document.getElementById("pwError").innerHTML = "비밀번호가 일치하지 않습니다."
      check = false
    }
    else {
      document.getElementById("pwError").innerHTML=""
    }
  }

  if (check) {
    document.getElementById("idError").innerHTML = ""
    document.getElementById("pwError").innerHTML = ""

    //비동기 처리이벤트
    setTimeout(function () {
      console.log("login");
      loginT = "true";  //로그인 됨을 표시
      localStorage.setItem("loginT",loginT);  //main으로 보내기
      alert("로그인 완료.");
      document.location.href="index.html";
    }, 0);
  }
  else{
    loginT = "false";  //로그인 됨을 표시
    localStorage.setItem("loginT",loginT);  //main으로 보내기
  }
}
// Ajax 요청 객체 생성
var xmlHttp;
if (window.XMLHttpRequest) {
  xmlHttp = new XMLHttpRequest;
} else {
  xmlHttp = new ActiveXObject('microsoft.XMLHTTP');
}

// Ajax 요청
xmlHttp.open("GET", "/data/users.xml");
xmlHttp.send();

var uid = [];
var upw = [];
//준비 상태가 바뀌면
xmlHttp.onreadystatechange = function () {
  if (xmlHttp.readyState == 4) {
    if (xmlHttp.status >= 200 && xmlHttp.status < 300) {
      var xmlDoc = xmlHttp.responseXML;
      var uids = xmlDoc.getElementsByTagName("id");
      var upws = xmlDoc.getElementsByTagName("password");
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

// 아이디 중복 체크
function idCheck() {
  let id = document.getElementById("id").value;
  let check = true;
  let unum = -1;
  document.getElementById("id").setAttribute("checkOverlap","false");

  // 아이디 확인
  if (id === "") {
    document.getElementById("idError").innerHTML = "아이디를 입력해주세요."
    check = false;
  } else {
    for (var i = 0; i < uid.length; i++) {
      if (id === uid[i]) {
        unum = i;
        break;
      }
    }
    if (unum !== -1) {
      document.getElementById("idError").innerHTML = "사용 불가능한 아이디입니다. 아이디를 새로 입력해주세요."
    } else {
      document.getElementById("idError").innerHTML = "사용 가능한 아이디입니다."
      document.getElementById("id").setAttribute("checkOverlap","true");
    }
  }

  setTimeout(function () { }, 0);
}

// 가입부분 체크

function signUpCheck() {

  let id = document.getElementById("id").value
  let checkOverlap = document.getElementById("id").getAttribute("checkOverlap")
  let password = document.getElementById("password").value
  let passwordCheck = document.getElementById("passwordCheck").value

  let name = document.getElementById("name").value
  let tel = document.getElementById("tel").value
  let email = document.getElementById("email").value
  let address = document.getElementById("address").value
  let check = true;


  console.log("id : " + id);
  console.log("password : " + password);
  console.log("name : " + name);
  console.log("tel : " + tel);
  console.log("email : " + email);
  console.log("address : " + address);


  // 아이디 확인
  if (id === "") {
    document.getElementById("idError").innerHTML = "아이디를 입력해주세요."
    check = false
  } else if (checkOverlap === "false") {
    document.getElementById("idError").innerHTML = "중복확인을 해주세요."
    check = false
  } else {
    document.getElementById("idError").innerHTML = ""
  }

  // 비밀번호 확인
  if (password !== passwordCheck) {
    document.getElementById("passwordError").innerHTML = ""
    document.getElementById("passwordCheckError").innerHTML = "비밀번호가 동일하지 않습니다."
    check = false
  } else {
    document.getElementById("passwordError").innerHTML = ""
    document.getElementById("passwordCheckError").innerHTML = ""
  }

  if (password === "") {
    document.getElementById("passwordError").innerHTML = "비밀번호를 입력해주세요."
    check = false
  } else {
    //document.getElementById("passwordError").innerHTML=""
  }
  if (passwordCheck === "") {
    document.getElementById("passwordCheckError").innerHTML = "비밀번호를 다시 입력해주세요."
    check = false
  } else {
    //document.getElementById("passwordCheckError").innerHTML=""
  }


  // 이름확인
  if (name === "") {
    document.getElementById("nameError").innerHTML = "이름을 입력해주세요."
    check = false
  } else {
    document.getElementById("nameError").innerHTML = ""
  }

  // 휴대폰번호 확인
  if (tel === "") {
    document.getElementById("telError").innerHTML = "휴대폰 번호를 입력해주세요."
    check = false
  } else {
    document.getElementById("telError").innerHTML = ""
  }

  // 이메일확인
  if (email.includes('@')) {
    let emailId = email.split('@')[0]
    let emailServer = email.split('@')[1]
    if (emailId === "" || emailServer === "") {
      document.getElementById("emailError").innerHTML = "이메일이 올바르지 않습니다."
      check = false
    }
    else {
      document.getElementById("emailError").innerHTML = ""
    }
  } else {
    document.getElementById("emailError").innerHTML = "이메일이 올바르지 않습니다."
    check = false
  }

  // 주소 확인
  if (address === "") {
    document.getElementById("addressError").innerHTML = "주소를 입력해주세요."
    check = false
  } else {
    document.getElementById("addressError").innerHTML = ""
  }

  if (check) {
    document.getElementById("idError").innerHTML = ""
    document.getElementById("passwordError").innerHTML = ""
    document.getElementById("passwordCheckError").innerHTML = ""

    document.getElementById("nameError").innerHTML = ""
    document.getElementById("telError").innerHTML = ""
    document.getElementById("emailError").innerHTML = ""
    document.getElementById("addressError").innerHTML = ""

    // 다음 페이지로 데이터 넘기기
    var user ={
      "id" : id,
      "password" : password,
      "name" : name,
      "tel" : tel,
      "email" : email,
      "address" : address
    };

    //비동기 처리이벤트
    setTimeout(function () {
      alert("가입이 완료되었습니다.");
      localStorage.setItem("user", JSON.stringify(user));
      document.location.href="userInfo.html";
    }, 0);
  }
}
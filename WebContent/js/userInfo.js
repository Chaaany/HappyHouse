// signUp.js에서 데이터 받아오기
var userI;
if(localStorage.getItem("user")){
  userI = JSON.parse(localStorage.getItem("user"));
}

function okButtonFunc() {
  document.location.href="index.html";
}

function editButtonFunc() {
  // userInfoEdit.js로 데이터 보내기
  localStorage.setItem("userI", JSON.stringify(userI));
  document.location.href="userInfoEdit.html";
}

function deleteButtonFunc() {
  alert("회원 정보를 삭제했습니다.");
  document.location.href="index.html";
}
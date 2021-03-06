<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8"/>
<!DOCTYPE html>
<html>
<head>
    <title>회원 정보 수정</title>

    <link href="css/userInfoEdit.css" rel="stylesheet" />
    <script src="js/userInfoEdit.js"></script>
</head>

<body>
    <div class="wrapper">
        <div class="title"><h1 style="font-size: 21px;">회원 정보 수정</h1></div>
        <div class="id">
            <input id="id" type="text" value="" checkOverlap="true";
                maxlength="20" placeholder="아이디">
            <button id="idCheckButton" 
                    style="width: 20%; height:39px; float:right;" 
                    onclick="idCheck()">중복검사</button>
            <div id="idError" class="error"></div>
        </div>
        <div class="password">
            <input id="password" type="password" value="" maxlength="20" placeholder="비밀번호">
            <div id="passwordError" class="error"></div>
        </div>
        <div class="passwordCheck">
            <input id="passwordCheck" type="password" value="" maxlength="20" placeholder="비밀번호 확인">
            <div id="passwordCheckError" class="error"></div>
        </div>
        <div class="line">
            <hr>
        </div>

        <div class="name">
            <input id="name"  type="text" value="" placeholder="이름">
            <div id="nameError" class="error"></div>
        </div>
        <div class="tel">
            <input id="tel" type="tel" value="" placeholder="휴대폰번호 010-0000-0000">
            <div id="telError" class="error"></div>
        </div>
        <div class="email">
            <input id="email" type="text" value="" placeholder="이메일 example89@gmail.com">
            <div id="emailError" class="error"></div>
        </div>
        <div class="address">
            <input id="address"  type="text" value="" placeholder="주소">
            <div id="addressError" class="error"></div>
        </div>
        
        <div class="line">
            <hr>
        </div>
        <div class="signUp">
            <button id="signUpButton" onclick="signUpCheck()">수정하기</button>
        </div>
    </div>

</body>
</html>
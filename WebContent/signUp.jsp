<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8"/>
<!DOCTYPE html>
<html>
<head>
    <title>회원가입 페이지</title>
    <link href="css/signUp.css" rel="stylesheet" />
    <script src="js/signUp.js"></script>
</head>

<body>
    <div class="wrapper">
    	<form action="./main" method="post">
    	<input type="hidden" name="action" value="registeraf">
        <div class="title"><h1 style="font-size: 21px;">회원가입</h1></div>
        <div class="id">
            <input id="id" name="id" type="text" checkOverlap="false" maxlength="20" placeholder="아이디">
            <button id="idCheckButton" 
                    style="width: 20%; height:39px; float:right;" 
                    onclick="idCheck()">중복검사</button>
            <div id="idError" class="error"></div>
        </div>
        <div class="pass">
            <input id="pass" name="pass" type="password" maxlength="20" placeholder="비밀번호">
            <div id="passwordError" class="error"></div>
        </div>

        <div class="name">
            <input id="name" name="name" type="text" placeholder="이름">
            <div id="nameError" class="error"></div>
        </div>
        <div class="phone">
            <input id="tel" name="phone" type="tel" placeholder="휴대폰번호 010-0000-0000">
            <div id="telError" class="error"></div>
        </div>
        <div class="email">
            <input id="email" name="email" type="text" placeholder="이메일 example89@gmail.com">
            <div id="emailError" class="error"></div>
        </div>
        <div class="address">
            <input id="address"  type="text" placeholder="주소">
            <div id="addressError" class="error"></div>
        </div>
        
        <div class="line">
            <hr>
        </div>
        <div class="signUp">
            <button id="signUpButton" onclick="signUpCheck()">가입하기</button>
        </div>
        </form>
    </div>

</body>
</html>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인 페이지</title>

    <link href="css/login.css" rel="stylesheet" />
    <script src="js/login.js"></script>
</head>

<body>
    <div class="wrapper">
    	<form action="./main" method="post">
    	<input type="hidden" name="action" value="loginaf">
        <div class="title">
            <h1 style="font-size: 21px;">로그인</h1>
        </div>
        <div class="id">
            <input id="id" name="id" type="text" maxlength="20" placeholder="아이디">
            <div id="idError" class="error"></div>
        </div>
        <div class="pw">
            <input id="pw" name="pass" type="password" maxlength="20" placeholder="비밀번호">
            <div id="pwError" class="error"></div>
        </div>
        <div class="line">
            <hr>
        </div>
        <div class="login">
            <button id="loginButton" type="submit">로그인</button>
        </div>
        </form>
    </div>
</body>
</html>
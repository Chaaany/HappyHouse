<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8"/>
<!DOCTYPE html>
<html>
<head>
    <title>회원 정보 확인</title>

    <link href="css/userInfo.css" rel="stylesheet" />
    <script src="js/userInfo.js"></script>
</head>

<body>
    <div class="wrapper">
        <div class="title"><h1 style="font-size: 21px;">회원 정보 확인</h1></div>
        <div class="line">
            <hr>
        </div>

        <div class="id">
            <script>
                document.write("아이디 : "+ userI.id);
            </script>
        </div>
        <div class="password">
            <script>
                document.write("비밀번호 : "+ userI.password);
            </script> 
        </div>
        <div class="name">
            <script>
                document.write("이름 : "+ userI.name);
            </script> 
        </div>
        <div class="tel">
            <script>
                document.write("휴대폰번호 : "+ userI.tel);
            </script> 
        </div>
        <div class="email">
            <script>
                document.write("이메일 : "+ userI.email);
            </script> 
        </div>
        <div class="address">
            <script>
                document.write("주소 : "+ userI.address);
            </script> 
        </div>
        
        
        <div class="line">
            <hr>
        </div>
        <div class="button">
            <button id="okButton" style="width:32%;" onclick="okButtonFunc()">확인</button>
            <button id="editButton" style="width:32%;" onclick="editButtonFunc()">수정</button>
            <button id="deleteButton" style="width:32%;" onclick="deleteButtonFunc()">삭제</button>
        </div>
    </div>

</body>
</html>
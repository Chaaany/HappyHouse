<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8"/>
<!DOCTYPE html>
<html>
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
      <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
        <a href="/" class="d-flex align-items-center col-md-2 mb-2 mb-md-0 text-dark text-decoration-none">
          <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"/></svg>
        </a>
        <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
          <svg class="bi me-2" width="20" height="32"><use xlink:href="#bootstrap"/></svg>
          <span class="fs-4">Happy House</span>
        </a>
  
        <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
          <li><a href="notice.html" class="nav-link px-2 link-secondary">????????????</a></li>
          <li><a href="#" class="nav-link px-2 link-dark">????????? ??????</a></li>
          <li><a href="#" class="nav-link px-2 link-dark">?????? ??????</a></li>
          <li><a href="#" class="nav-link px-2 link-dark">???????????? ??????</a></li>
          <li><a href="#" class="nav-link px-2 link-dark">???????????? ????????????</a></li>
        </ul>
  
        <div class="col-md-3 text-end">
          <button type="button" class="btn btn-outline-primary me-2">Login</button>
          <button type="button" class="btn btn-primary">Sign-up</button>
        </div>
      </header>
    </div>


    <table class="table">
        <thead class="thead-dark">
          <tr>
            <th scope="col">??????</th>
            <th scope="col">??????</th>
            <th scope="col">?????????</th>
          </tr>
        </thead>
        <tbody>
          
        </tbody>
      </table>

      <button id="create">?????????</button>
      
      <div class="modal_"></div>

    <footer class="footer mt-auto py-3 bg-light" >
        <div class="container">
          <span class="text-muted" style="font-weight: bolder">SSAFY</span>
          <br>
          <span class="text-muted">??????: ????????? ????????? ???????????? ???????????????</span>
          <br>
          <span class="text-muted">????????????: 1544-9001</span>
          <br>
          <span class="text-muted">ssafy@ssafy.com</span>
        </div>
      </footer>

      <script type="text/javascript" src="js/notice.js"></script>

    </body>
</html>
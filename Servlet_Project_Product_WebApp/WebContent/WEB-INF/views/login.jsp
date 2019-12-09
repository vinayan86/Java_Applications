<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<div class="container">
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>
<div class="container" align="center" style="margin-top: 5em; min-height: 200%;">

<form action="${pageContext.request.contextPath }/login" method="post" style="width:50%;">
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" value="${user.userName }"  name="userName" id="inputEmail3" placeholder="Email">
    </div>
  </div>
  <div class="form-group row">
    <label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" value="${user.password }" name="password" id="inputPassword3" placeholder="Password">
    </div>
  </div>
    <div class="form-group row">

    <label for="inputPassword3" class="col-sm-12 col-form-label"> <input type="checkbox" name="rememberMe" value= "Y" />Remeber ME</label>

 
     
  </div>
  <div class="form-group row">
    <div class="col-sm-10">
      <button type="submit" class="btn btn-primary">Sign in</button>
      <a href="${pageContext.request.contextPath}/">Cancel</a>
    </div>
  </div>
</form>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.container {
    height:100%;
}
.contents
{
height:500px;
}
.footer
{
background-color: #f8f9fa;}
</style>
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
   <jsp:include page="Admin_menu.jsp"></jsp:include>
   <div class="contents">
    <h3>Hello: ${loginedUser.userName}</h3>
    
  <br />
    </div>
    
 <jsp:include page="footer.jsp"></jsp:include>
   </div>
 
</body>
</html>
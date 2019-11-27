<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
      <div class="col-lg-10 col-xl-9 mx-auto">
        <div class="card card-signin flex-row my-5">
          <div class="card-img-left d-none d-md-flex">
             <!-- Background image for card set in CSS! -->
          </div>
          <div class="card-body">
            <h5 class="card-title text-center">Register</h5>
            <form class="form-signin">
              <div class="form-label-group">
                  <label for="inputUserame">Username</label>
                <input type="text" id="inputUserame" class="form-control" placeholder="Username" required autofocus>
            
              </div>

              <div class="form-label-group">
              <label for="inputEmail">Email address</label>
                <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required>
                
              </div>
              
          

              <div class="form-label-group">
              <label for="inputPassword">Password</label>
                <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
                
              </div>
              
              <div class="form-label-group">
              <label for="inputConfirmPassword">Confirm password</label>
                <input type="password" id="inputConfirmPassword" class="form-control" placeholder="Password" required>
                
              </div>
</br>
              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Register</button>
              <a class="d-block text-center mt-2 small" href="#">Sign In</a>
               </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>	
</html>
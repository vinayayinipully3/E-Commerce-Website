<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="stylesheet" href="signup.css">
    
     <style>
         * {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: Arial, Helvetica, sans-serif;
}
body {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  width: auto;
  background-color: #f8f8f8;
  right: 100px;
}
.signup-container {
  display: flex;
  justify-content: center;
  align-items: center;
  background: white;
  width: 900px;
  border-radius: 10px;
  overflow: hidden;
  box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
}
.image-section {
  width: 50%;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #e6f2ff;
  padding: 20px;
}
.image-section img {
  width: 80%;
}
.form-section {
  width: 50%;
  padding: 40px;
  display: flex;
  flex-direction: column;
  justify-content: center;
}
h2 {
  margin-bottom: 10px;
  font-size: 24px;
}

p {
  display: flex;
  margin-top: 13px;
  justify-content: center;
  align-items: center;
  color: #666;
  font-size: 18px;
  margin-bottom: 20px;
}
form input {
  width: 100%;
  padding: 10px;
  margin-bottom: 15px;
  border: 1px solid black;
  border-radius: 5px;
}
.btn {
  width: 100%;
  padding: 10px;
  background-color: #e63946;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 16px;
  margin-bottom: 10px;
}
.google-btn {
  width: 100%;
  padding: 10px;
  background-color: white;
  color: black;
  border: 1px solid black;
  border-radius: 5px;
  cursor: pointer;
  font-size: 16px;
}
.links {
  text-align: right;
  margin-top: 10px;
}
.links a {
  display: flex;
  justify-content: center;
  color: #e63946;
  text-decoration: none;
  font-size: 14px;
  align-items: center;
}
>
a {
  color: #e63946;
  text-decoration: none;
}

       
   </style>
</head>

<body>
    <input type="hidden" id="status"  value="<%=request.getAttribute("status") %>">
    <div class="signup-container">
        <div class="image-section">
            <img src="https://img.freepik.com/free-vector/shopping-cart-icon-isolated-illustration_18591-82226.jpg?ga=GA1.1.9287204.1739290501&semt=ais_hybrid"
                alt="Shopping">
        </div>
        <div class="form-section">
            <h2>Log in to Exclusive</h2>
            <p>Enter your details below</p>
            <form action="login" method="post">
                <input type="email" name="username" id="username" placeholder="Email or Phone Number" required>
                <input type="password" name="password" id="password" placeholder="Password" required>
                <button type="submit" class="btn">Log In</button>
            </form>
            <div class="links">
                <a href="#">Forgot Password?</a>
            </div>

        </div>
    </div>
    
        <script src="vendor/jquerry/jquerry.min.js"></script>
    <script src="js/main.js"></script>
    
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
    
    
    
    
    <script type="text/javascript">
       var status = document.getElementById("status").value;
       if(status=="failed"){
    	   swal("sorry","Wrong username and password","error");
       }
    </script>
</body>

</html>
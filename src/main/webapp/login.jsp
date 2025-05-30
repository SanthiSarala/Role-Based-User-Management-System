<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Form</title>
    <style>
    *{
       margin:15 0;
       padding:0;
       border-sizing:border-box;
      font-family: "Poppins", sans-serif;
    }
        body {
        min-height:100vh;
        display:flex;
        align-items:center;
        justify-content:center;
        background-image:url('bg.jpg');
        background-size:cover;
        background-position:center;
        }
        .container {
            background: rgba(0, 0, 0, 0.5);
            padding: 30px;
            border-radius: 16px;
            color: white;
            text-align: center;
            background-size:cover;
            border:solid 5px rgb(255, 255, 255, 0.1);
            backdrop-filter:blur(25px);
            box-shadow:0px 0px 30px 20px rgb(0, 0, 0, 0.1);
            flex-direction:coloumn;
            width: 400px;   
        }
        .login-form {
        background: rgba(64, 64, 64, 0.15);
        border: 3px solid rgba(255, 255, 255, 0.3);
        padding: 30px;
        border-radius: 16px;
        backdrop-filter: blur(25px);
        text-align:center;
        color:white;
        box-shadow: 0px 0px 20px 10px rgba(0, 0, 0, 0.15) ;
        }
        .login-title{
           font-size: 40px;
          margin-bottom: 20px;
        }
        select {
            width: 100%
            padding: 12px;
            border-radius: 10px;
            border: none;
            margin-bottom: 15px;
            background: rgba(255, 255, 255, 0.1);
            color: white;
            font-size: 16px;
            cursor: pointer;
        }
        .input-box { 
         margin: 15px 0;
         position:relative;
        }
        .input-box input {
           width:100px;
           background: rgba(255, 255, 255, 0.1);
           border: none;
           padding: 12px  45px;
           border-radius: 99px;
           outline: 3px solid transparent;
           transistion: 0.3s;
           font-size: 17px;
           color: white;
           font-weight: 600;
        }
        .input-box input::placeholder {
        color: rgba(255, 255, 255, 0.8);
        font-size: 17px;
        font-weight: 500px;
        }
        .input-box input:focus {
        outline: 3px solid rgba(255, 255, 255, 0.3);
        }
        .input-box input::ms-reveal {
           filter: invert(100%);
        }
        .input-box i {
           position: absolute;
           left: 15px;
           top: 50%;
           transform: translateY(-50%);
           font-size: 20px;
           color: rgba(255, 255, 255, 0.8);
        }
        .remember-forgot-box {
         display: flex;
         justify-content: space-between;
         margin: 15px 0;
         font-size: 15px;
        }
        .remember-forgot-box label {
           display: flex;
           gap: 8px;
           cursor: pointer;
        }
        .remember-forgot-box input {
        accent-color: white;
        cursor: pointer;
        }
        .remember-forgot-box a {
        color: white;
        text-decoration: none;  
        }
        .remember-forgot-box a:hover{
           text-decoration: underline;
        }
        .login-button {
            background: #2F9CF4;
            color: white;
            padding: 12px 0;
            border: none;
            border-radius: 99px;
            width: 100%;
            font-size: 16px;
            font-weight: 600;
            cursor: pointer;
            transition: 0.3s;
        }
        .login-btn:hover {
          background: #0B87EC;
        }
        .register {
          margin-top: 15px;
          font-size: 15px;
        } 
        .register a {
           color: white;
           text-decoration: none;
           font-weight: 500;
        }
        .register a:hover {
        text-decoration: underline;
        }
        
        
    </style>
</head>
<body>
    <div class="container">
    <%
    String error = request.getParameter("error");
    if (error != null) {
%>
    <p style="color: red;"><%= error %></p>
<%
    }
%>
    
        <h1>Login</h1>
        <form name="loginForm" action="LoginController" method="post" onsubmit="return validateLoginForm()">
        <script>
function validateLoginForm() {
    let username = document.forms["loginForm"]["username"].value.trim();
    let password = document.forms["loginForm"]["password"].value.trim();
    let role = document.forms["loginForm"]["role"].value;

    if (username === "") {
        alert("Username cannot be empty!");
        return false;
    }
    if (password === "") {
        alert("Password cannot be empty!");
        return false;
    }
    if (password.length < 6) {
        alert("Password must be at least 6 characters long!");
        return false;
    }
    if (role === "") {
        alert("Please select a role!");
        return false;
    }

    return true;
}
</script>
       
            <select name="role" required>
                <option value="admin">Admin</option>
                <option value="teacher">Teacher</option>
                <option value="student">Student</option>
            </select>
            <div class="input-box">
                 <i class='bx bxs-user'></i>
                <input type="text" name="username" placeholder="Username" required>
            </div>
            
            <div class="input-box">
                <i class='bx bxs-lock-alt'></i>
                <input type="password" name="password" placeholder="Password" required>
            </div>
            
            <div class="remember-forgot-box">
                <label for="remember">
                <input type="checkbox" id="remember">
                   Remember me
                   </label>
                   <a href="#">Forgot Password?</a>
            </div>
            
            <button type="submit" class="login-button">Login</button>
        </form>
        <p>Don't have an account? <a href="register.jsp">Register</a></p>
    </div>
</body>
</html>

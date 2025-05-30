<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f3f4f6;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .register-form {
            background-color: #ffffff;
            padding: 20px 40px;
            border-radius: 10px;
            box-shadow: 0px 5px 15px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
        }
        .login-title {
            text-align: center;
            font-size: 24px;
            color: #333;
            margin-bottom: 20px;
        }
        .input-box {
            margin-bottom: 10px;
        }
        .input-box input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            outline: none;
            font-size: 14px;
        }
        .input-box input::placeholder {
            color: #aaa;
        }
        .register-btn {
            width: 100%;
            background-color: #007bff;
            color: white;
            border: none;
            padding: 12px;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }
        .register-btn:hover {
            background-color: #0056b3;
        }
        .register {
            text-align: center;
            margin-top: 10px;
        }
        .register a {
            color: #007bff;
            text-decoration: none;
        }
        .register a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <form action="RegisterController" method="post" class="register-form">
        <h1 class="login-title">Register Form</h1>
         <div class="input-box">
            <input type="text" name="id" placeholder="id" required>
        </div>
        <div class="input-box">
            <input type="text" name="username" placeholder="Username" required>
        </div>
        <div class="input-box">
            <input type="text" name="firstname" placeholder="First Name" required>
        </div>
        <div class="input-box">
            <input type="text" name="lastname" placeholder="Last Name" required>
        </div>
        <div class="input-box">
            <input type="email" name="email" placeholder="Email" required>
        </div>
        <div class="input-box">
            <input type="password" name="password" placeholder="Password" required>
        </div>
        <div class="input-box">
            <input type="password" name="confirmPassword" placeholder="Confirm Password" required>
        </div>
        <label>Role:</label>
        <select name="role" required>
            <option value="admin">Admin</option>
            <option value="teacher">Teacher</option>
            <option value="student">Student</option>
        </select><br><br>
        <button type="submit" class="register-btn">Register</button>
        <div class="register">
            Already have an account? <a href="login.jsp">Login</a>
        </div>
    </form>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>HariniMart - Login</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .login-card {
            background: #ffffff;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 8px 30px rgba(0, 0, 0, 0.08);
            width: 360px;
            border: 1px solid rgba(255, 255, 255, 0.5);
        }
        h2 {
            text-align: center;
            color: #2c3e50;
            margin-bottom: 25px;
            font-size: 24px;
            font-weight: 600;
        }
        .form-group {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 8px;
            color: #4a5568;
            font-size: 14px;
            font-weight: 500;
        }
        input[type="email"], input[type="password"] {
            width: 100%;
            padding: 12px;
            border: 1px solid #e2e8f0;
            border-radius: 8px;
            box-sizing: border-box;
            font-size: 14px;
            background-color: #f8fafc;
            transition: all 0.3s ease;
        }
        input[type="email"]:focus, input[type="password"]:focus {
            border-color: #4f46e5;
            background-color: #ffffff;
            outline: none;
            box-shadow: 0 0 0 3px rgba(79, 70, 229, 0.1);
        }
        button {
            width: 100%;
            padding: 12px;
            background-color: #4f46e5;
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 15px;
            font-weight: 600;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        button:hover {
            background-color: #4338ca;
        }
        .error {
            background-color: #fee2e2;
            color: #991b1b;
            padding: 10px;
            border-radius: 6px;
            text-align: center;
            margin-bottom: 20px;
            font-size: 13px;
            font-weight: 500;
        }
    </style>
</head>
<body>

    <div class="login-card">
        <h2>HariniMart</h2>
        
        <% 
            String error = request.getParameter("error");
            if (error != null) { 
        %>
            <div class="error">Invalid Email or Password!</div>
        <% } %>

        <form action="login" method="post">
            <div class="form-group">
                <label>Email Address</label>
                <input type="email" name="email" required placeholder="admin@harinimart.com">
            </div>
            <div class="form-group">
                <label>Password</label>
                <input type="password" name="password" required placeholder="••••••••••••">
            </div>
            <button type="submit">Sign In</button>
        </form>
    </div>

</body>
</html>
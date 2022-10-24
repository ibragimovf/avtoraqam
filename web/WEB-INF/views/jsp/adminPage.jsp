<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
    <style>
        * {
            box-sizing: border-box;
            font-family: sans-serif;
        }

        .login {
            width: 320px;
            height: 450px;
            border: 1px solid #CCC;
            background: url(https://media4.giphy.com/media/BHNfhgU63qrks/giphy.gif) center center no-repeat;
            background-size: cover;
            margin: 150px auto;
            border-radius: 20px;
        }

        .login .form {
            width: 100%;
            height: 100%;
            padding: 0px 25px;
        }

        .login .form h1 {
            color: #FFF;
            text-align: center;
            font-weight: normal;
            font-size: 18px;
            margin-top: 30px;
            margin-bottom: 80px;
        }

        .login .form input {
            width: 100%;
            height: 40px;
            margin-top: 10px;
            background: rgba(255, 255, 255, .5);
            border: 1px solid rgba(255, 255, 255, .1);
            padding: 0 15px;
            color: #FFF;
            border-radius: 5px;
            font-size: 14px;
        }

        .login .form input:focus {
            border: 1px solid rgba(255, 255, 255, .8);
            outline: none;
        }

        ::-webkit-input-placeholder {
            color: #DDD;
        }

        .login .form input.submit {
            background: rgba(255, 255, 255, .9);
            color: #444;
            font-size: 15px;
            margin-top: 40px;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="login">
    <form action="/adminPage/addNumber" method="post" class="form">
        <h1>Auto number kiritish</h1>
        <input name="number" type="text" placeholder="Auto number">
        <input name="region" type="text" placeholder="Region">
        <input name="price" type="text" placeholder="Price">
        <input name="roleId" type="text" placeholder="Fiz = 1 , Yur = 2">
        <input type="submit" value="Sign In" class="submit">
    </form>
    <a href="/adminPage/addAuction">Auksion kiritish</a>
</div>
</body>
</html>

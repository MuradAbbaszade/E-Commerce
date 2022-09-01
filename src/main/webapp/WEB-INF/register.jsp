<%-- 
    Document   : register
    Created on : Sep 1, 2022, 1:09:52 PM
    Author     : roma-cervice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Register</h1>
        <form action="register" method="POST">
            <label for="name">Name:</label>
            <input type="text" name="name" id="name" />
            <label for="email">Email:</label>
            <input type="email" name="email" id="email" />
            <label for="password">Password:</label>
            <input type="password" name="password" id="password" />
            <label for="matchingPassword">Repeat Password</label>
            <input type="text" name="matchingPassword" id="matchingPassword" />
            <button type="submit">Submit</button>
            <label style="color:red">${message}</label>
        </form>
    </body>
</html>

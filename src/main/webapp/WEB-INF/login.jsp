<%-- 
    Document   : login
    Created on : Sep 1, 2022, 12:38:22 PM
    Author     : roma-cervice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            <%@ include file="assets/login.css"%>
        </style>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="POST">
            <label for="username">Email:</label>
            <input type="email" name="username" id="username" />
            <label for="password">Password:</label>
            <input type="password" name="password" id="password" />
            <button type="submit">Submit</button>
        </form>
    </body>
</html>

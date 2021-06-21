<%--
  Created by IntelliJ IDEA.
  User: Jin
  Date: 25.06.2020
  Time: 8:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <style>
        <%@include file='style/commonStyle.css' %>
        <%@include file='style/bootstrap.min.css'%>
    </style>
</head>
<body>
<div class="container">
    <div class="form-group">
        <c:url var="loginUrl" value="/login"/>
        <form action="${loginUrl}" method="post" class="form-signin">
            <h2 class="form-heading">Log in</h2>
            <c:if test="${param.error!=null}">
                <div class="alert alert-danger">
                    <p>Invalid username and password.</p>
                </div>
            </c:if>
            <c:if test="${param.logout!=null}">
                <div class="alert alert-success">
                    <p>You have been logged out successfully.</p>
                </div>
            </c:if>
            <div>
                <input type="text" class="form-control" id="username" name="ssoId" placeholder="Login" value="" required>
            </div>
            <div>
                <input type="password" class="form-control" id="password" name="password" placeholder="Password" value="" required>
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Enter</button>
        </form>
    </div>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>

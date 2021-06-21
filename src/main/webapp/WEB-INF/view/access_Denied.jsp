<%--
  Created by IntelliJ IDEA.
  User: Jin
  Date: 25.06.2020
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Denied</title>
    <style>
        <%@include file='style/commonStyle.css' %>
        <%@include file='style/bootstrap.min.css'%>
    </style>
</head>
<body>
<h1>Access Denied</h1>
<a href="<c:url value="/login"/>">Log in</a>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: Jin
  Date: 25.06.2020
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
<%--    <style>
        <%@include file='commonStyle.css' %>
        <%@include file='bootstrap.min.css'%>
    </style>--%>
</head>
<body>
<a href="<c:url value= "/goHomeAdmin" />">Create test</a>
<a href="<c:url value="/goHomeAdmin"/>">Statistic</a>
<a href="<c:url value="/goHomeAdmin"/>">Create user</a>

<a href="<c:url value="/logout"/>">Log off</a>
<form action="/goHomeAdmin">
    <input type="submit" value="Back">
</form>
</body>
</html>

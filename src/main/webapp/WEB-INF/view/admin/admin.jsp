<%--
  Created by IntelliJ IDEA.
  User: Jin
  Date: 25.06.2020
  Time: 8:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin</title>

</head>
<body>
    <a href="<c:url value= "/createTest" />">Create test</a>
    <a href="<c:url value="/adminStatistic"/>">Statistic</a>
    <a href="<c:url value="/createUser"/>">Create user</a>


<a href="<c:url value="/logout"/>">Log off</a>
    <h1>Hello ${user}</h1>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>

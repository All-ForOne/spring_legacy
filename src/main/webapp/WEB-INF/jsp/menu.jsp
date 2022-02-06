<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Spring test</title>
</head>
<body>
    <c:forEach items="${menus}" var="menu">
        <c:out value="${menu.name}" /><br>
    </c:forEach>
</body>
</html>
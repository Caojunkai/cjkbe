<%--
  Created by IntelliJ IDEA.
  User: zad
  Date: 2016/12/21
  Time: 下午3:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>number</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.bookId}</td>
            <td>${book.name}</td>
            <td>${book.number}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

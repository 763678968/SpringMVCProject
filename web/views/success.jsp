<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: animation
  Date: 2019/8/10
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--        <fmt:message key="resource.welcome"/>--%>
<%--        <fmt:message key="resource.exit"/>--%>

        <br/>
        welcome to spring mvc success<br/>
        ==== request:<br/>
        ${requestScope.student.id} -${requestScope.student.name} <br>
        ${requestScope.student2.id} -${requestScope.student2.name} <br>
        ${requestScope.student3.id} -${requestScope.student3.name} <br>
        ${requestScope.student4.id} -${requestScope.student4.name} <br>

        ==== session:<br/>
        ${sessionScope.student.id} -${sessionScope.student.name} <br>
        ${sessionScope.student2.id} -${sessionScope.student2.name} <br>
        ${sessionScope.student3.id} -${sessionScope.student3.name} <br>
        ${sessionScope.student4.id} -${sessionScope.student4.name} <br>
</body>
</html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05.07.2019
  Time: 3:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details Worker</title>
</head>
<body>
<div align="center">
    <h2>Details Worker</h2>
    <form:form action="${pageContext.request.contextPath}/search_worker" method="get" modelAttribute="worker">
        <table border="0" cellpadding="5">
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Position</th>
            </tr>
            <tr>
                <td>${worker.id}
                    <form:hidden path="id"/>
                </td>
                <td>${worker.firstName}
                    <form:hidden path="firstName"/>
                </td>
                <td>${worker.lastName}
                    <form:hidden path="lastName"/>
                </td>
                <td>${worker.position}
                    <form:hidden path="position"/>
                </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>

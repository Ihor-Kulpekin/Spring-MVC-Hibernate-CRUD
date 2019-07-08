<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05.07.2019
  Time: 3:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Service</title>
</head>
<body>
<div align="center">
    <h2>Edit worker</h2>
    <form:form action="${pageContext.request.contextPath}/edit_worker/worker" method="post" modelAttribute="worker">
        <table border="0" cellpadding="5">
            <tr>
                <td>ID:</td>
                <td>${worker.id}
                    <form:hidden path="id"/>
                </td>
            </tr>
            <tr>
                <td>First Name:</td>
                <td><form:input path="firstName"/></td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><form:input path="lastName"/></td>
            </tr>
            <tr>
                <td>Position:</td>
                <td><form:input path="position"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Edit"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>

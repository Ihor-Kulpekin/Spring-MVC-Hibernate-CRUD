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
    <title>Edit Ordering</title>
</head>
<body>
<div align="center">
    <h2>Edit Ordering</h2>
    <form:form action="${pageContext.request.contextPath}/edit_ordering/ordering" method="post" modelAttribute="ordering">
        <table border="0" cellpadding="5">
            <tr>
                <td>ID:</td>
                <td>${ordering.id}
                    <form:hidden path="id"/>
                </td>
            </tr>
            <tr>
                <td>General Price:</td>
                <td>
                    <form:input path="generalPrice"/>
                </td>
            </tr>
            <tr>
                <td>Date Ordering:</td>
                <td><form:input path="dateOrdering"/></td>
            </tr>
            <tr>
                <td>Number of Good:</td>
                <td>
                    <form:input path="numberService"/>
                </td>
            </tr>
            <tr>
                <td>Client ID:</td>
                <td>${ordering.idClient}
                    <form:hidden path="idClient"/>
                </td>
            </tr>
            <tr>
                <td>Worker ID:</td>
                <td>${ordering.idWorker}
                    <form:hidden path="idWorker"/>
                </td>
            </tr>
            <tr>
                <td>ID Name Service:</td>
                <td>${ordering.idNameService}
                    <form:hidden path="idNameService"/>
                </td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Edit"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>

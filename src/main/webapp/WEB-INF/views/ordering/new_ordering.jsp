<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05.07.2019
  Time: 3:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Name Service</title>
</head>
<body>
<c:url value="/save_ordering" var="save"/>
<div align="center">
    <h2>New Ordering</h2>
    <form:form action="${save}" method="post" modelAttribute="ordering">
        <table border="0" cellpadding="5">
            <tr>
                <td>General Price:</td>
                <td><form:input path="generalPrice"/></td>
            </tr>
            <tr>
                <td>Date Ordering:</td>
                <td><form:input path="dateOrdering"/></td>
            </tr>
            <tr>
                <td>Number of Service:</td>
                <td><form:input path="numberService"/></td>
            </tr>
            <tr>
                <td>Id Client:</td>
                <td><form:select items="${listClients}" path="idClient"/></td>
            </tr>
            <tr>
                <td>Id Worker:</td>
                <td><form:select items="${listWorkers}" path="idWorker"/></td>
            </tr>
            <tr>
                <td>Id Name Service:</td>
                <td><form:select items="${listNameService}" path="idNameService"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>

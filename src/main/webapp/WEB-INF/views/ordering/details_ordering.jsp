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
    <title>Details Ordering</title>
</head>
<body>
<div align="center">
    <h2>Details Ordering</h2>
    <form:form action="${pageContext.request.contextPath}/search_ordering" method="get" modelAttribute="ordering">
        <table border="0" cellpadding="5">
            <tr>
                <th>ID</th>
                <th>General Price</th>
                <th>Date Ordering</th>
                <th>Number of Goods</th>
                <th>Id Client</th>
                <th>Id Worker</th>
                <th>Id Name Service</th>
            </tr>
            <tr>
                <td>${ordering.id}
                    <form:hidden path="id"/>
                </td>
                <td>${ordering.generalPrice}
                    <form:hidden path="generalPrice"/>
                </td>
                <td>${ordering.dateOrdering}
                    <form:hidden path="dateOrdering"/>
                </td>
                <td>${ordering.numberService}
                    <form:hidden path="numberService"/>
                </td>
                <td>${ordering.idClient}
                    <form:hidden path="idClient"/>
                </td>
                <td>${ordering.idWorker}
                    <form:hidden path="idWorker"/>
                </td>
                <td>${ordering.idNameService}
                    <form:hidden path="idNameService"/>
                </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>

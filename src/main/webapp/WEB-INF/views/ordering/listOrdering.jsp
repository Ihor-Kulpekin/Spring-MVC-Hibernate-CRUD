<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<div align="center">
    <h3><a href="<c:url value="/new_Ordering"/>">New Ordering</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>General Price</th>
            <th>Date Ordering</th>
            <th>Number of Service</th>
            <th>Id_Client</th>
            <th>Id_Worker</th>
            <th>Id_Number_Service</th>
            <th>DETAILS</th>
            <th>ACTION</th>
        </tr>
        <c:forEach items="${listOrdering}" var="ordering">
            <tr>
                <td>${ordering.id}</td>
                <td>${ordering.generalPrice}</td>
                <td>${ordering.dateOrdering}</td>
                <td>${ordering.numberService}</td>
                <td>${ordering.idClient}</td>
                <td>${ordering.idWorker}</td>
                <td>${ordering.idNameService}</td>
                <td><a href="${pageContext.request.contextPath}/search_ordering?id=${ordering.id}">Details</a></td>
                <td>
                    <a href="${pageContext.request.contextPath}/edit_ordering?id=${ordering.id}">Edit</a>
                    <a href="${pageContext.request.contextPath}/delete_ordering?id=${ordering.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

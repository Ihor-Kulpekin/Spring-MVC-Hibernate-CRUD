<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<div align="center">
    <h2>Service Manager</h2>
    <form method="get" action="../service/index.jsp">
        <input type="text" name="keyword"/>
        <input type="submit" value="Search"/>
    </form>
    <h3><a href="<c:url value="/newWorker"/>">New Worker</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Position</th>
            <th>DETAILS</th>
            <th>ACTION</th>
        </tr>
        <c:forEach items="${workerList}" var="worker">
            <tr>
                <td>${worker.id}</td>
                <td>${worker.firstName}</td>
                <td>${worker.lastName}</td>
                <td>${worker.position}</td>
                <td><a href="${pageContext.request.contextPath}/search_worker?id=${worker.id}">Details</a></td>
                <td>
                    <a href="${pageContext.request.contextPath}/edit_worker?id=${worker.id}">Edit</a>
                    <a href="${pageContext.request.contextPath}/delete_worker?id=${worker.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

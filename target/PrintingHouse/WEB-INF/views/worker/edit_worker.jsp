<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05.07.2019
  Time: 3:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Edit Service</title>
    <style>
        #firstName_error{
            color:red;
            margin-left: 10px;
        }
        #lastName_error{
            color:red;
            margin-left: 10px;
        }
        #position_error{
            color:red;
            margin-left: 10px;
        }
    </style>
    <script src="${pageContext.request.contextPath}/resources/js/ValidateWorker.js"></script>
</head>
<body>
<div align="center">
    <h2>Edit worker</h2>
    <form:form action="${pageContext.request.contextPath}/edit_worker/worker" onsubmit="return validateFormWorker()" method="post" modelAttribute="worker">
        <table border="0" cellpadding="5">
            <tr>
                <td>ID:</td>
                <td>${worker.id}
                    <form:hidden path="id"/>
                </td>
            </tr>
            <tr>
                <td>First Name:</td>
                <td><form:input path="firstName" id="firstName"/><span id="firstName_error"></span></td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><form:input path="lastName" id="lastName"/><span id="lastName_error"></span></td>
            </tr>
            <tr>
                <td>Position:</td>
                <td><form:input path="position" id="position"/><span id="position_error"></span></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Edit"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>

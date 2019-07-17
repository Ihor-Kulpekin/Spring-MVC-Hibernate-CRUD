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
    <title>Edit Name Service</title>
    <script src="${pageContext.request.contextPath}/resources/js/ValidateNameService.js"></script>
    <style>
        #kindService_error{
            color:red;
            margin-left: 30px;
        }
        #price_error{
            color:red;
            margin-left: 30px;
        }
    </style>
</head>
<body>
<div align="center">
    <h2>Edit Name Service</h2>
    <form:form action="${pageContext.request.contextPath}/edit_nameservice/nameservice" method="post"
               modelAttribute="nameService" onsubmit="return validateEditNameService()">
        <table border="0" cellpadding="5">
            <tr>
                <td>ID:</td>
                <td>${nameService.id}
                    <form:hidden path="id"/>
                </td>
            </tr>
            <tr>
                <td>Name Service:</td>
                <td>${nameService.id}
                    <form:hidden path="nameService"/>
                </td>
            </tr>
            <tr>
                <td>Kind Name Service:</td>
                <td><form:input path="kindService"/><span id="kindService_error"></span></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><form:input path="price"/><span id="price_error"></span></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Edit"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>

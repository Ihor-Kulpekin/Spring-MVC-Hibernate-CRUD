<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05.07.2019
  Time: 3:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>New Name Service</title>
    <script src="${pageContext.request.contextPath}/resources/js/ValidateNameService.js"></script>
    <style>
        #nameService_error{
            color:red;
            margin-left: 10px;
        }
        #kindService_error{
            color:red;
            margin-left: 10px;
        }
        #price_error{
            color:red;
            margin-left: 10px;
        }
    </style>
</head>
<body>
<c:url value="/saveNameService" var="save"/>
<div align="center">
    <h2>New NameService</h2>
    <form:form action="${save}" name="form" method="post" modelAttribute="nameService" onsubmit="return validateNameService()">
        <table border="0" cellpadding="5">
            <tr>
                <td>Name Service:</td>
                <td><form:select items="${listServices}" path="nameService" name="selectItems"/> <span id="nameService_error"></span></td>
            </tr>
            <tr>
                <td>Kind Service:</td>
                <td><form:input path="kindService" name="kindService" id="kindService"/><span id="kindService_error"></span></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><form:input path="price" name="price"/><span id="price_error"></span></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>

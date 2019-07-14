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
    <title>New Worker</title>
    <script src="${pageContext.request.contextPath}/resources/js/ValidateWorker.js">

    </script>
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
</head>
<body>
<c:url value="/saveWorker" var="save"/>
<div align="center">
    <h2>New Worker</h2>
    <form:form action="${save}" method="post" modelAttribute="worker" onsubmit="return validateFormWorker()">
        <table border="0" cellpadding="5">
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
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>

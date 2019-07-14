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
    <title>New Client</title>
    <script src="${pageContext.request.contextPath}/resources/js/ValidateClient.js"></script>
    <style>
        #firstName_error{
            color:red;
            margin-left: 10px;
        }
        #lastName_error{
            color:red;
            margin-left: 10px;
        }
        #email_error{
            color:red;
            margin-left: 10px;
        }
        #mobile_error{
            color:red;
            margin-left: 10px;
        }
    </style>
</head>
<body>
<c:url value="/saveClient" var="save"/>
<div align="center">
    <h2>New Worker</h2>
    <form:form action="${save}" method="post" modelAttribute="client" onsubmit="return validateClientFields()">
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
                <td>Mobile Number:</td>
                <td><form:input path="mobileNumber" id="mobile"/><span id="mobile_error"></span></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="email" id="email"/><span id="email_error"></span></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>

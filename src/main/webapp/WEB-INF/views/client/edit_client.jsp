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
<div align="center">
    <h2>Edit Client</h2>
    <form:form action="${pageContext.request.contextPath}/edit_client/client" onsubmit="return validateClientFields()" method="post" modelAttribute="client">
        <table border="0" cellpadding="5">
            <tr>
                <td>ID:</td>
                <td>${client.id}
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
                <td>Mobile Number:</td>
                <td><form:input path="mobileNumber" id="mobile"/><span id="mobile_error"></span></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="email" id="email"/><span id="email_error"></span></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Edit"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>

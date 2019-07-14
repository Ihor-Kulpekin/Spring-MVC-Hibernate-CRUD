<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>New Service</title>
    <script src="${pageContext.request.contextPath}/resources/js/ValidateService.js">
    </script>
    <style>
        #textMessageError{
            color:red;
            margin-left: 10px;
        }
    </style>
</head>
<body>
<div align="center">
    <h2>New Service</h2>
    <form:form action="save" method="post" modelAttribute="service" name="form" onsubmit="return validateForm()">
        <table border="0" cellpadding="5">
            <tr>
                <td>Name</td>
                <td><form:input path="name" name="name" id="name"/><span id="textMessageError"></span></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>

</body>
</html>

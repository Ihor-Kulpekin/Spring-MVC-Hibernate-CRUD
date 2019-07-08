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
    <title>Details Worker</title>
    <style>
        #header{
            text-align:center;
            color:green;
            font-size:60px;
        }


        #footer{
            font-size:30px;
            color:green;
            text-align:center;
        }



        #headerButton{
            margin-bottom:20px;
            text-align:center;

        }
    </style>
</head>
<body>
<header>
    <h1 id="header">PrinterPlace</h1>
    <div id="headerButton">
        <a href="${pageContext.request.contextPath}/index"><button>Table "Service"</button></a>
        <a href="${pageContext.request.contextPath}/listNameService"><button>Table "Name Service"</button></a>
        <a href="${pageContext.request.contextPath}/listClients"><button>Table "Client"</button></a>
        <a href="${pageContext.request.contextPath}/listWorkers"><button>Table "Worker"</button></a>
        <a href="${pageContext.request.contextPath}/listOrdering"><button>Table "Ordering"</button></a>
    </div>
</header>
<div align="center">
    <h2>Details Worker</h2>
    <form:form action="${pageContext.request.contextPath}/search_client" method="get" modelAttribute="client">
        <table border="0" cellpadding="5">
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Mobile Number</th>
                <th>Email</th>
            </tr>
            <tr>
                <td>${client.id}
                    <form:hidden path="id"/>
                </td>
                <td>${client.firstName}
                    <form:hidden path="firstName"/>
                </td>
                <td>${client.lastName}
                    <form:hidden path="lastName"/>
                </td>
                <td>${client.mobileNumber}
                    <form:hidden path="mobileNumber"/>
                </td>
                <td>${client.email}
                    <form:hidden path="email"/>
                </td>
            </tr>
        </table>
    </form:form>
</div>
<footer>
    <P id="footer">2019 year</p>
</footer>
</body>
</html>

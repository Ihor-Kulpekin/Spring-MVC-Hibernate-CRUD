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
    <title>Details Service</title>
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
    <h1 id="header">Printer House</h1>
    <div id="headerButton">
        <a href="${pageContext.request.contextPath}/index"><button>Table "Service"</button></a>
        <a href="${pageContext.request.contextPath}/listNameService"><button>Table "Name Service"</button></a>
        <a href="${pageContext.request.contextPath}/listClients"><button>Table "Client"</button></a>
        <a href="${pageContext.request.contextPath}/listWorkers"><button>Table "Worker"</button></a>
        <a href="${pageContext.request.contextPath}/listOrdering"><button>Table "Ordering"</button></a>
    </div>
</header>
<div align="center">
    <h2>Details Service</h2>
    <form:form action="${pageContext.request.contextPath}/search" method="get" modelAttribute="service">
        <table border="0" cellpadding="5">
            <tr>
                <th>ID</th>
                <th>Name</th>
            </tr>
            <tr>
                <td>${service.id}
                    <form:hidden path="id"/>
                </td>
                <td>${service.name}
                    <form:hidden path="name"/>
                </td>
            </tr>
        </table>
    </form:form>
</div>

<footer>
    <p id="footer">2019 year</p>
</footer>
</body>
</html>

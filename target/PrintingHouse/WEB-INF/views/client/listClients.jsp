<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
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
    <h3><a href="<c:url value="/new_client"/>">New Client</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Mobile Number</th>
            <th>Email</th>
            <th>DETAILS</th>
            <th>ACTION</th>
        </tr>
        <c:forEach items="${listClients}" var="client">
            <tr>
                <td>${client.id}</td>
                <td>${client.firstName}</td>
                <td>${client.lastName}</td>
                <td>${client.mobileNumber}</td>
                <td>${client.email}</td>
                <td><a href="${pageContext.request.contextPath}/search_client?id=${client.id}">Details</a></td>
                <td>
                    <a href="${pageContext.request.contextPath}/edit_client?id=${client.id}">Edit</a>
                    <a href="${pageContext.request.contextPath}/delete_client?id=${client.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<footer>
    <P id="footer">2019 year</p>
</footer>
</body>
</html>

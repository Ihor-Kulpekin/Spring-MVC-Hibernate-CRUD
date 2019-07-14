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
<div align="center">
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
    <h3><a href="<c:url value="/new"/>">New Service</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>DETAILS</th>
            <th>ACTION</th>
        </tr>
        <c:forEach items="${listService}" var="service">
            <tr>
                <td>${service.id}</td>
                <td>${service.name}</td>
                <td><a href="${pageContext.request.contextPath}/search?id=${service.id}">Details</a></td>
                <td>
                    <a href="${pageContext.request.contextPath}/edit?id=${service.id}">Edit</a>
                    <a href="${pageContext.request.contextPath}/delete?id=${service.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<footer>
    <p id="footer">2019 year</p>
</footer>
</body>
</html>

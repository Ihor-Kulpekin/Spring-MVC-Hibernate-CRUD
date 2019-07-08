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
    <h3><a href="<c:url value="/new_nameService"/>">New Name Service</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name Service</th>
            <th>Kind Service</th>
            <th>Price</th>
            <th>DETAILS</th>
            <th>ACTION</th>
        </tr>
        <c:forEach items="${listNameService}" var="nameService">
            <tr>
                <td>${nameService.id}</td>
                <td>${nameService.nameService}</td>
                <td>${nameService.kindService}</td>
                <td>${nameService.price}</td>
                <td><a href="${pageContext.request.contextPath}/search_nameservice?id=${nameService.id}">Details</a></td>
                <td>
                    <a href="${pageContext.request.contextPath}/edit_nameservice?id=${nameService.id}">Edit</a>
                    <a href="${pageContext.request.contextPath}/delete_nameservice?id=${nameService.id}">Delete</a>
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

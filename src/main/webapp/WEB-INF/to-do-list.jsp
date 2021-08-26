<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <title>List Todos</title>
    <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<jsp:useBean id="now" class="java.util.Date"/>
<fmt:formatDate value="${now}" pattern="dd/MM/yyyy"/>
<nav class="navbar navbar-dark bg-dark">
    <a class="navbar-brand" href="#">
        <img src="../img/logo.png" width="50" height="40" class="d-inline-block align-top" alt="">
        Bootstrap
    </a>
    <div>
        <h1 style="color: white">Welcome, ${firstName}</h1>
    </div>

</nav>

<div class="container">
    <!-- Image and text -->

    <h1>Your Plans:</h1>
    <table class="table table-striped table-bordered table-hover">

        <thead class="thead-dark">
        <tr>
            <th>Description</th>
            <th>Begin date</th>
            <th>End date</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${todolist}" var="todo">
            <tr>
                <td>${todo.description}</td>
                <td><fmt:formatDate value="${todo.beginDate}" pattern="dd/mm/yyyy"/></td>
                <td><fmt:formatDate value="${todo.endDate}" pattern="dd/mm/yyyy"/></td>
                <c:choose>
                    <c:when test="${now lt todo.endDate && now ge todo.beginDate}">
                        <td style="color: green;">Already in process</td>
                    </c:when>
                    <c:when test="${now gt todo.endDate}">
                        <td style="color: red">Deadline Expired</td>
                    </c:when>
                    <c:otherwise>
                        <td style="color: orange;">Waiting the beginning date.</td>
                    </c:otherwise>
                </c:choose>
                <td><a type="button" class="btn btn-success" href="/update-todo?id=${todo.id}">Update</a>
                    <a type="button" class="btn btn-warning" href="/delete-todo?id=${todo.id}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>

    </table>

    <div><a href="/add-todo">Add new ToDo</a></div>
    <div><a href="/user-logout">Log out</a></div>
</div>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>

</html>
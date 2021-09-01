<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>List Todos</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/to-do-list.css" rel="stylesheet">
</head>

<body>
<jsp:useBean id="now" class="java.util.Date"/>

<nav class="navbar navbar-dark bg-dark">
    <a class="navbar-brand" href="/">
        <img src="../img/img-logo.png" width="50" height="40" class="d-inline-block align-top" alt="">
        MyTodos App
    </a>
    <div>
        <h1 style="color: white; display: inline;">Welcome, ${firstName}</h1>
        <div class="btn-group open" style="margin-bottom: 22px;">
            <a class="btn btn-primary" href="#"><i class="fa fa-user fa-fw"></i> My Account</a>
            <a class="btn btn-primary dropdown-toggle" data-toggle="dropdown" href="#">
                <span class="" title="Toggle dropdown menu"></span>
            </a>
            <ul class="dropdown-menu">
                <li><a href="#"><i class="fa fa-pencil fa-fw"></i> Edit profile</a></li>
                <li><a href="${pageContext.request.contextPath}/logout" data-toggle="modal" data-target="#logoutModal"><i class="fa fa-sign-out"></i> Log out</a></li>
            </ul>
        </div>
    </div>

    <!-- Log out confirmation Modal -->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="LogoutModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="LogoutModalLabel">Log out confirmation</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <h4>Are you sure to log out?</h4>
                </div>
                <div class="modal-footer">
                    <a href="${pageContext.request.contextPath}/logout"><button type="button" class="btn btn-primary">Yes</button></a>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
                </div>
            </div>
        </div>
    </div>

</nav>
<br>
<br>
<div class="container-fluid">

<c:choose>
    <c:when test="${empty todolist}">
        <div class="add-icon">
            <a href="/add-todo">
            <button type="submit" class="btn btn-primary btn-lg">
                <i class="fa fa-plus"></i> Add your first ToDo
            </button>
            </a>
        </div>
    </c:when>

    <c:otherwise>
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
                <td><fmt:formatDate value="${todo.beginDate}" pattern="dd-MM-yyyy"/></td>
                <td><fmt:formatDate value="${todo.endDate}" pattern="dd-MM-yyyy"/></td>
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
                    <a type="button" class="btn btn-warning" data-toggle="modal" data-target="#DeleteModal" href="/delete-todo?id=${todo.id}">Delete</a></td>

<%--                <!-- Delete confirmation Modal --%>
                <div class="modal fade" id="DeleteModal" tabindex="-1" role="dialog" aria-labelledby="DeleteModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="DeleteModalLabel">Delete confirmation</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <h4>Are you sure to delete </h4>
                            </div>
                            <div class="modal-footer">
                                <a href="/delete-todo?id=${todo.id}"><button type="button" class="btn btn-primary">Yes</button></a>
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
                            </div>
                        </div>
                    </div>
                </div>

            </tr>
        </c:forEach>
        </tbody>

    </table>
        <a href="/add-todo" class="fixed-bottom">
            <button type="submit" class="btn btn-primary btn-lg" style="margin-bottom: 70px; margin-left: 15px;">
                <i class="fa fa-plus"></i> Add new ToDo
            </button>
        </a>
    </c:otherwise>

</c:choose>
</div>


<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<jsp:include page="includes/footer-copyright.jsp"/>
</body>

</html>
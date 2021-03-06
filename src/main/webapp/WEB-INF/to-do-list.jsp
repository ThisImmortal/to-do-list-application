<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>List Todos</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="webjars/bootstrap/5.0.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/to-do-list.css" rel="stylesheet">
</head>

<body style="background-color: beige">
<jsp:useBean id="now" class="java.util.Date"/>

<nav class="navbar navbar-dark bg-dark">
    <a class="navbar-brand" href="/">
        <img src="../img/img-logo.png" width="50" height="40" class="d-inline-block align-top" alt="">
        MyTodos App
    </a>
    <div>
        <h1 style="color: white; display: inline;">Welcome, ${firstName}</h1>
        <div class="btn-group" style="margin-bottom: 22px;margin-right: 80px; margin-left: 20px;">
            <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown">
                My Account
            </button>
            <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="#">Edit profile</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/logout" data-bs-toggle="modal" data-bs-target="#logoutModal"><i class="fa fa-sign-out"></i>Log out</a></li>
            </ul>
        </div>
    </div>

    <!-- Log out confirmation Modal -->
    <jsp:include page="includes/logout-confirm-modal.jsp"/>


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
    <table class="table table-striped table-bordered table-hover ">

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
                    <a type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#DeleteModal" href="/delete-todo?id=${todo.id}">Delete</a></td>

              <!-- Delete confirmation Modal -->
                <div class="modal fade" id="DeleteModal" tabindex="-1" role="dialog" aria-labelledby="DeleteModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="DeleteModalLabel">Delete confirmation</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">
                                </button>
                            </div>
                            <div class="modal-body text-center">
                                <h4>Are you sure to delete? </h4>
                            </div>
                            <div class="modal-footer">
                                <a href="/delete-todo?id=${todo.id}"><button type="button" class="btn btn-primary">Yes</button></a>
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
                            </div>
                        </div>
                    </div>
                </div>



            </tr>
        </c:forEach>
        </tbody>

    </table>

        <a href="/add-todo">
            <button type="submit" class="btn btn-primary btn-lg fixed-bottom" style="margin-bottom: 70px; margin-left: 15px;">
                <i class="fa fa-plus"></i> Add new ToDo
            </button>
        </a>

    </c:otherwise>

</c:choose>
</div>


<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/5.0.1/js/bootstrap.min.js"></script>

<!--Footer include-->
<jsp:include page="includes/footer-copyright.jsp"/>


<!-- Modal for About project link-->
<jsp:include page="includes/about-project-modal.jsp"/>
</body>

</html>
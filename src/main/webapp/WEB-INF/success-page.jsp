<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05.09.2021
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success!</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>

<div class="text-center">
    <h1 class="display-3">${successMessageHeader}</h1>
    <p class="lead">${successMessageBody}</p>
    <hr>

    <p class="lead">
        <a class="btn btn-primary btn-sm" href="/show-login-page" role="button">Continue to login page</a>
    </p>
</div>
</body>
</html>

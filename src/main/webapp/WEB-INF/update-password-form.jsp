<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05.09.2021
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reset Password</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body style="background-color: beige">

<div class="container">

    <div class="d-flex justify-content-center align-items-center container">
        <div class="row">
            <form:form method="post" modelAttribute="passwordDto" class="justify-content-center" cssStyle="margin-top: 50px;">
                <h4 class=""><small>Set a new password</small></h4>
                <div class="mb-2 form-group">
                    <label for="password" class="visually-hidden">New Password</label>
                    <form:input type="password" path="password" class="form-control" id="password" placeholder="New Password"/>
                    <div style="color: red; display: inline-block;font-size: 14px;">
                        <form:errors path="password" cssStyle=""/>
                    </div>
                </div>
                <div class="mb-4  form-group">
                    <label for="confirmPassword" class="visually-hidden">Confirm Password</label>
                    <form:input type="password" path="confirmPassword" class="form-control" id="confirmPassword" placeholder="Confirm Password"/>
                    <div style="color: red; display: inline-block;font-size: 14px;">
                        <form:errors path="confirmPassword" cssStyle=""/>
                    </div>
                </div>

                <input type="checkbox" onclick="myFunction()" class="mb-4">Show Password
                <div>
                    <button type="submit" class="btn btn-primary">Save Password</button>
                </div>

            </form:form>
        </div>
    </div>

</div>

<script>
    function myFunction() {
        var x = document.getElementById("password");
        var y = document.getElementById("confirmPassword");
        if (x.type === "password"||y.type === "password") {
            x.type = "text";
            y.type = "text";
        } else {
            x.type = "password";
            y.type = "password";
        }
    }
</script>

</body>
</html>

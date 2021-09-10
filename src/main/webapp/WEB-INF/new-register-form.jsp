<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<html>
<head>
    <title>Registration Form</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../css/new-register-form.css">
</head>

<body>

<div class="signup-form">
    <form:form method="post" modelAttribute="user">
        <h2 class="h4 font-weight-bold text-theme">Create Account</h2>
        <p class="lead">It's free and hardly takes more than 30 seconds.</p>
        <div class="form-group">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                <form:input type="text" path="firstName" class="form-control" name="username" placeholder="First Name"/>
            </div>
            <div class="my-alert">
                <form:errors path="firstName"/>
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                <form:input type="text" path="lastName" class="form-control" name="username" placeholder="Last Name"/>
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-paper-plane"></i></span>
                <form:input type="email" path="email" class="form-control" name="email" placeholder="Email Address"/>
            </div>
            <div class="my-alert">
                <form:errors path="email"/>
                <c:if test="${emailIsNotValidErrorMessage != null}">
                    <div class="my-alert">
                            ${emailIsNotValidErrorMessage}
                    </div>
                </c:if>
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                <form:input type="password" path="password" id="password" class="form-control" name="password" placeholder="Password"/>
            </div>
            <div class="my-alert">
                <form:errors path="password"/>
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
				<span class="input-group-addon">
					<i class="fa fa-lock"></i>
					<i class="fa fa-check"></i>
				</span>
                <form:input type="password" path="passwordMatching" id="passwordMatching" class="form-control" name="confirm_password" placeholder="Confirm Password"/>
            </div>
            <div class="my-alert">
                <form:errors path="passwordMatching"/>
            </div>
        </div>
        <div class="text-center">
            <input type="checkbox" onclick="myFunction()" class="mb-4">Show Password
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block btn-lg">Sign Up</button>
        </div>
    </form:form>
    <div class="text-center">Already have an account? <a href="/show-login-page" class="text-primary">Login here</a>.</div>
</div>

<script>
    function myFunction() {
        var x = document.getElementById("password");
        var y = document.getElementById("passwordMatching");
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
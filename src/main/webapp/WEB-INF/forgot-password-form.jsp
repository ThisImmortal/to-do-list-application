<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 06.09.2021
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Forgot password</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="../css/forgot-password.css" rel="stylesheet"/>

</head>
<body>

<div class="container padding-bottom-3x mb-2 mt-5">
    <div class="row justify-content-center">
        <div class="col-lg-8 col-md-10">
            <div class="forgot">
                <h2>Forgot your password?</h2>
                <p>Change your password in three easy steps. This will help you to secure your password!</p>
                <ol class="list-unstyled">
                    <li><span class="text-primary text-medium">1. </span>Enter your email address below.</li>
                    <li><span class="text-primary text-medium">2. </span>Our system will send you a temporary link</li>
                    <li><span class="text-primary text-medium">3. </span>Use the link to reset your password</li>
                </ol>
            </div>
            <form method="post" class="card mt-4">
                <div class="card-body">
                    <div class="form-group"> <label for="email-for-pass">Enter your email address</label> <input class="form-control" name="email" type="text" id="email-for-pass"/>
                        <small class="form-text text-muted">Enter the email address you used during the registration on <strong>Spring-boot-todo-demo.herokuapp.com</strong>.
                        Then we'll email a link to this address.</small>
                        <div style="color:red;">
                            ${suchEmailDoesnotExist}
                            ${emptyEmailError}
                        </div>
                    </div>
                </div>
                <div class="card-footer"> <button class="btn btn-primary" type="submit">Get New Password</button> <a href="/show-login-page" class="btn btn-dark">Back to Login</a></div>
            </form>
        </div>
    </div>
</div>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>

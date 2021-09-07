<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Login page</title>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../css/login.css">
</head>

<body>


<div id="main-wrapper" class="container">
    <div class="row justify-content-center">
        <div class="col-xl-10">
            <div class="card border-0">
                <div class="card-body p-0">
                    <div class="row no-gutters">
                        <div class="col-lg-6">
                            <div class="p-5">
                                <div class="mb-5">
                                    <h3 class="h4 font-weight-bold text-theme">Login</h3>
                                </div>

                                <p class="text-muted mt-2 mb-5">Sign in to your account</p>

                                <form:form action="/login" method="post">
                                    <c:if test="${invalidOrExpiredToken != null}">
                                        <div class="alert alert-success col-xs-offset-1 col-xs-10">
                                            <i>Your token link expired</i>
                                        </div>
                                    </c:if>
                                    <c:if test="${logout != null}">
                                        <div class="alert alert-success col-xs-offset-1 col-xs-10">
                                            <i>You have been logged out.</i>
                                        </div>
                                    </c:if>

                                    <c:if test="${param.error != null}">
                                        <div class="alert alert-danger col-xs-offset-1 col-xs-12">
                                            <i>Sorry, you entered invalid username or password!</i>
                                        </div>
                                    </c:if>

                                    <div class="form-group">
                                        <label for="username">Email</label>
                                        <input type="text" class="form-control" id="username" name="username">
                                    </div>
                                    <div class="form-group mb-5">
                                        <label for="password">Password</label>
                                        <input type="password" class="form-control" id="password" name="password">
                                    </div>

                                    <input type="hidden"
                                           name="${_csrf.parameterName}"
                                           value="${_csrf.token}"/>

                                    <button type="submit" class="btn btn-theme">Login</button>
                                    <a href="/forgot-password" class="forgot-link float-right text-primary">Forgot password?</a>

                                </form:form>
                            </div>
                        </div>

                        <div class="col-lg-6 d-none d-lg-inline-block">
                            <div class="account-block rounded-right">
                                <div class="overlay rounded-right"></div>
                                <div class="account-testimonial">
                                    <h4 class="text-white mb-4">MyTodos Management App!</h4>
                                    <p class="lead text-white">"Manage your plans by recording it"</p>
                                    <p>- Admin User</p>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- end card-body -->
            </div>
            <!-- end card -->

            <p class="text-muted text-center mt-3 mb-0">Don't have an account? <a href="/register" class="text-primary ml-1">register</a></p>

        </div>
        <!-- end col -->
    </div>
    <!-- Row -->
</div>



</body>

</html>
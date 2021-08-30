<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
    <title>Register Form</title>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="webjars/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker3.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/register-form.css">

</head>

<body>

<div class="container h-100">
    <div class="row h-100">
        <div class="col-sm-10 col-md-8 col-lg-6 mx-auto d-table h-100">
            <div class="d-table-cell align-middle">

                <div class="text-center mt-4">
                    <h1 class="h2">Get started</h1>
                    <p class="lead">
                        Fill out our registration form
                    </p>
                </div>

                <div class="card">
                    <div class="card-body">
                        <div class="m-sm-4">
                            <form:form method="post" modelAttribute="user">

                         <%-- Place for error messages--%>
                                <div class="form-group">
                                    <div class="col-xs-15">

                                        <form:errors path="firstName"
                                                     cssClass="alert alert-danger col-xs-offset-1 col-xs-10" />
                                        <br>
                                        <form:errors path="email"
                                                     cssClass="alert alert-danger col-xs-offset-1 col-xs-12" />
                                        <br>
                                        <form:errors path="password"
                                                     cssClass="alert alert-danger col-xs-offset-1 col-xs-10" />
                                        <br>
                                        <form:errors path="passwordMatching"
                                                     cssClass="alert alert-danger col-xs-offset-1 col-xs-10" />
                                        <br>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label>First Name*</label>
                                    <form:input class="form-control form-control-lg" type="text" path="firstName" placeholder="Enter your name"/>
                                </div>
                                <div class="form-group">
                                    <label>Last Name</label>
                                    <form:input class="form-control form-control-lg" type="text" path="lastName" placeholder="Enter your surname"/>
                                </div>
<%--                                <div class="form-group">--%>
<%--                                    <label>Date of birth</label>--%>
<%--                                    <input class="form-control form-control-lg" type="text" id="bday" name="birthday" placeholder="Enter your date of birth">--%>
<%--                                </div>--%>
                                <div class="form-group">
                                    <label>Email*</label>
                                    <form:input class="form-control form-control-lg" type="email" path="email" placeholder="Enter your email"/>
                                </div>
                                <div class="form-group">
                                    <label>Password*</label>
                                    <form:password class="form-control form-control-lg" path="password" placeholder="Enter password"/>
                                </div>
                                <div class="form-group">
                                    <label>Confirm Password*</label>
                                    <form:password class="form-control form-control-lg" path="passwordMatching" placeholder="Confirm password"/>
                                </div>
<%--                                <!-- Error message -->--%>
<%--                                <c:if test="${registerMessage != null}">--%>
<%--                                    <div class="alert alert-danger" role="alert">--%>
<%--                                            ${registerMessage}--%>
<%--                                    </div>--%>
<%--                                </c:if>--%>

                                <div class="text-center mt-3">
                                    <a href="/show-login-page"><input type="button" class="btn btn-secondary" value="Back"/></a>
                                    <input type="submit" class="btn btn-lg btn-primary" value="Sign up"/>

                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.js"></script>

<script>
    $('#bday').datepicker({
        format: 'dd/mm/yyyy',
    });
</script>

</body>
</html>
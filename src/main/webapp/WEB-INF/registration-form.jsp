<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
    <title>Register Form</title>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/register-form.css">

</head>

<body>

<section class="vh-100">
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-12 col-xl-11">
                <div class="card text-black" style="border-radius: 25px;">
                    <div class="card-body p-md-5">
                        <div class="row justify-content-center">
                            <div class="col-md-12">

                                <p class="h1 fw-bold mb-5 mt-4">Sign up</p>



                                <form:form method="post" class="w-100" modelAttribute="user">



                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <label class="form-label text-nowrap other-input-label" for="firstName">First Name</label>
                                        <form:input type="text" path="firstName" id="firstName" class="form-control col-md-4"/>
                                        <form:errors path="firstName" cssClass="alert alert-danger col-md-4"/>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <label class="form-label text-nowrap other-input-label" for="lastName">Last Name</label>
                                        <form:input type="text" path="lastName" id="lastName" class="form-control col-md-4" />
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <label class="form-label text-nowrap other-input-label" for="email">Your Email</label>
                                        <form:input type="email" path="email" id="email" class="form-control col-md-4" />
                                        <form:errors path="email" cssClass="alert alert-danger col-md-4" />
                                        <c:if test="${emailIsNotValidErrorMessage != null}">
                                            <div class="alert alert-danger col-md-4">
                                                    ${emailIsNotValidErrorMessage}
                                            </div>
                                        </c:if>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <label class="form-label text-nowrap other-input-label" for="password">Password</label>
                                        <form:input type="password" path="password" id="password" class="form-control col-md-4" cssStyle="margin-left: 7px;" />
                                        <form:errors path="password" cssClass="alert alert-danger col-md-4" />
                                    </div>


                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <label class="form-label confirm-password-label" for="passwordMatching">Confirm password</label>
                                        <form:input type="password" path="passwordMatching" id="passwordMatching" class="form-control col-md-4" />
                                        <form:errors path="passwordMatching" cssClass="alert alert-danger col-md-4"/>
                                    </div>


                                    <div class="">
                                        <button type="submit" class="btn btn-primary btn-lg">Register</button>
                                        <a href="/show-login-page"><input type="button" class="btn btn-dark btn-primary btn-lg" value="Back"/></a>
                                    </div>

                                </form:form>

                            </div>


                            </div>

                        </div>
                    </div>
                </div>
        </div>
    </div>
</section>


</body>
</html>
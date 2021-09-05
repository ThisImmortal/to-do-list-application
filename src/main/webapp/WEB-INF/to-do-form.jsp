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
    <title>New Todo Form</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="webjars/bootstrap/5.0.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="webjars/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker3.css" rel="stylesheet">
    <link href="../css/to-do-form.css" rel="stylesheet">
</head>
<body style="background-color: beige">

<div class="container h-100">
    <div class="row h-100">
        <div class="col-sm-10 col-md-8 col-lg-6 mx-auto d-table h-100">
            <div class="d-table-cell align-middle">
                <div class="card font-weight-bold">
                    <div class="card-body">
                        <div class="card-title">
                            <h2 class="h4 fw-bold text-center">New Todo Form</h2>
                        </div>
                        <div class="m-sm-5">
                            <form:form method="post" modelAttribute="planToDo">
                                <div class="form-group mb-4">
                                    <label for="descriptionId">Description</label>
                                    <form:textarea type="text" path="description" rows="3" class="form-control form-control-lg" id="descriptionId"
                                                   placeholder="Describe your todo"/>
                                    <div class="my-alert">
                                        <form:errors path="description"/>
                                    </div>
                                </div>

                                <div class="form-group mb-4">
                                    <label for="bday">Begin Date</label>
                                    <form:input type="text" path="beginDate" class="form-control form-control-lg" id="bday"
                                                placeholder="Select begin date"/>
                                    <div class="my-alert">
                                        <form:errors path="beginDate"/>
                                    </div>
                                </div>
                                <div class="form-group mb-4">
                                    <label for="eday">End Date</label>
                                    <form:input type="text" path="endDate" class="form-control form-control-lg" id="eday"
                                                placeholder="Select end date"/>
<%--                                    <form:errors path="endDate" cssClass="alert alert-danger col-md-4"/>--%>
                                    <div class="my-alert">
                                        <form:errors path="endDate"/>
                                    </div>
                                </div>
                                <button type="submit" class="btn btn-primary">Create</button>
                                <a href="/" type="button" class="btn btn-warning btn-dark">Back</a>
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
    var dateToday = new Date();


    $('#bday').datepicker({
        startDate: dateToday,
        format: 'yyyy-mm-dd'
    }).val();



    $('#eday').datepicker({
        startDate: dateToday,
        format: 'yyyy-mm-dd',
    }).val();

</script>

<jsp:include page="includes/footer-copyright.jsp"/>
</body>
</html>

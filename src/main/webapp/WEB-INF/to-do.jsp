<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>

<head>
    <title>Plan Form</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="webjars/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker3.css" rel="stylesheet">
    <link href="../css/to-do.css" rel="stylesheet">
</head>

<body style="background-color: beige">

<br>
<br>
<div class="page-header">
    <h1 style="text-align: center">New Todo form:</h1>
</div>

<div class="container">
    <form:form method="post" modelAttribute="planToDo">
        <form:hidden path="id"/>
        <fieldset class="form-group d-flex flex-row align-items-center mb-4">
                <form:label path="description" for="description" cssClass="description-label">Description</form:label>
                <form:input path="description" type="text" name="description" class="form-control col-md-4"/>
                <form:errors path="description" cssClass="alert alert-danger col-md-4"/>
        </fieldset>
        <fieldset class="form-group d-flex flex-row align-items-center mb-4">
                <form:label path="description" for="bday" cssClass="begin-date-label">Begin Date</form:label>
                <form:input path="beginDate" type="text" name="beginDate" id="bday" class="form-control col-md-4"/>
                <form:errors path="beginDate" cssClass="alert alert-danger col-md-4"/>
        </fieldset>
        <fieldset class="form-group d-flex flex-row align-items-center mb-4">
                <form:label path="description" for="eday" cssClass="end-date-label">End Date</form:label>
                <form:input path="endDate" type="text" name="endDate" id="eday" class="form-control col-md-4"/>
                <form:errors path="endDate" cssClass="alert alert-danger col-md-4"/>
        </fieldset>
        <button type="submit" class="btn btn-success">Add</button>
        <a href="/" type="button" class="btn btn-warning">Back</a>
    </form:form>


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
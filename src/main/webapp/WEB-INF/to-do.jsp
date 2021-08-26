<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>

<head>
    <title>Plan Form</title>
    <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="webjars/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker3.css" rel="stylesheet">
</head>

<body>


<div class="container">
    <form:form method="post" modelAttribute="planToDo">
        <form:hidden path="id"/>
        <fieldset class="form-group">
            <form:label path="description">Description</form:label>
            <form:input path="description" type="text" name="description" class="form-control"/>
            <form:errors path="description" cssClass="text-warning"/>
        </fieldset>
        <fieldset class="form-group">
            <form:label path="description">Begin Date</form:label>
            <form:input path="beginDate" type="text" name="beginDate" id="bday" class="form-control"/>
            <form:errors path="beginDate" cssClass="text-warning"/>
        </fieldset>
        <fieldset class="form-group">
            <form:label path="description">End Date</form:label>
            <form:input path="endDate" type="text" name="endDate" id="eday" class="form-control"/>
            <form:errors path="endDate" cssClass="text-warning"/>
        </fieldset>
        <button type="submit" class="btn btn-success">Add</button>
        <a href="/" type="button" class="btn btn-warning">Back</a>
    </form:form>


</div>


<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.js"></script>

<script>
    $('#bday').datepicker({
        format: 'dd/mm/yyyy',
    });
</script>
<script>
    $('#eday').datepicker({
        format: 'dd/mm/yyyy',
    });
</script>
</body>

</html>
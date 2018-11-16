<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
        integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

  <meta charset="UTF-8">
  <h2>NBA championship</h2>
</head>
<body>
<p class="text-center">Add new division</p>

<form:form method="post" modelAttribute="division">
  <div class="form-group">
    <form:label path="divisionTitle">Title</form:label>
    <form:input path="divisionTitle" type="text"/>

    <div class="form-group">
      <form:label path="divisionConference">Select conference:</form:label>
      <form:select path="divisionConference" class="form-control">
          <form:options items="${conference}" itemLabel="conferenceTitle"/>
      </form:select>
    </div>

    <button type="submit" class="btn btn-success">Add</button>
  </div>
</form:form>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>

</body>
</html>
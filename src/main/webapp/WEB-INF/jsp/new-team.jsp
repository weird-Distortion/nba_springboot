<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
        integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

  <meta charset="UTF-8">
  <conferenceTitle>NBA championship</conferenceTitle>
</head>
<body>
<p class="text-center">Add new team</p>

<form:form method="post" modelAttribute="team">
  <div>
    <form:label path="teamTitle">Title</form:label>
    <form:input path="teamTitle" type="text"/>
    <form:label path="teamCity">City</form:label>
    <form:input path="teamCity" type="text"/>

    <div class="form-group">
      <label for="conferenceList">Select conference:</label>
      <form:select path="teamConference" id="conferenceList">
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
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
<p class="text-center">Player profile</p>

<%--PLAYER INFO--%>
<%--in the end - refactor to remove duplicate code (template)--%>

<form:form method="post" modelAttribute="playerAttribute">
  <div class="form-group">
    <div>
      <form:label path="playerFirstName">First name:</form:label>
      <form:input path="playerFirstName" type="text"/>
    </div>
    <div>
      <form:label path="playerLastName">Last name:</form:label>
      <form:input path="playerLastName" type="text"/></div>
    <div>
      <form:label path="playerNumber">Number:</form:label>
      <form:input path="playerNumber" type="number" min="0"/>
    </div>
    <div>
      <form:label path="playerAttackRate">Attack rate:</form:label>
      <form:input path="playerAttackRate" type="number" step="0.01" min="0"/>
    </div>
    <div>
      <form:label path="playerDefenceRate">Defence rate:</form:label>
      <form:input path="playerDefenceRate" type="number" step="0.01" min="0"/>
    </div>
    <div>
      <form:label path="playerLongShotRate">3-point shot rate:</form:label>
      <form:input path="playerLongShotRate" type="number" step="0.01" min="0"/>
    </div>
    <div class="form-group">
      <form:label path="playerTeam">Team:</form:label>
      <form:select path="playerTeam" class="form-control">
        <form:options items="${teams}" itemLabel="teamTitle"/>
      </form:select>
    </div>

    <button type="submit" class="btn btn-success">Save</button>
    <a class="btn btn-primary" href="/schedule">Back to regular season</a>


  </div>
</form:form>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>

</body>
</html>
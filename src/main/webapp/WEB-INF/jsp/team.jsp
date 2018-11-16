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
<p class="text-center">Team info</p>
<a class="btn btn-success" href="/schedule" role="button">Back to schedule</a>
<form:form method="post" modelAttribute="teamAttribute">
  <div class="form-group">
    <div>
      <form:label path="teamTitle">Title:</form:label>
      <form:input path="teamTitle" type="text"/>
    </div>
    <div>
      <form:label path="teamCity">City:</form:label>
      <form:input path="teamCity" type="text"/>
    </div>
  </div>
</form:form>

<div class="form-group">
  <div>
    <label for="divisionDiv">Division:</label>
    <input type="text" value="${division.divisionTitle}" id="divisionDiv" readonly>
  </div>
  <div>
    <label for="conferenceDiv">Conference:</label>
    <input type="text" value="${conference.conferenceTitle}" id="conferenceDiv" readonly>
  </div>
</div>

<div class="container">
  <div class="row">
    <div class="col-sm-6">
      <table class="table">
        <thead class="thead-dark">
        <tr>
          <th>#</th>
          <th>Name</th>
          <th>Attack rate</th>
          <th>Defence rate</th>
          <th>3-point rate</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${players}" var="player">
          <tr>
            <td scope="row">${player.playerNumber}</td>
            <td scope="row"><a
                    href="/player?id=${player.playerId}">${player.playerFirstName} ${player.playerLastName}</a></td>
            <td scope="row">${player.playerAttackRate}</td>
            <td scope="row">${player.playerDefenceRate}</td>
            <td scope="row">${player.playerLongShotRate}</td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>

</body>
</html>
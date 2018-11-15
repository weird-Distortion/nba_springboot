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

<form:form method="post" modelAttribute="teamAttribute">
  <div class="form-group">
    <form:label path="teamTitle">${teamAttribute.teamTitle}</form:label>
    <form:input path="teamTitle" type="text"/>
    <form:label path="teamCity">${teamAttribute.teamCity}</form:label>
    <form:input path="teamCity" type="text"/>

    <div class="form-group">
      <form:label path="teamConference">Select conference:</form:label>
      <form:select path="teamConference" class="form-control">
          <form:options items="${conference}" itemLabel="conferenceTitle"/>
      </form:select>
    </div>

    <div class="form-group">
      <form:label path="teamDivision">Select division:</form:label>
      <form:select path="teamDivision" class="form-control">
        <form:options items="${division}" itemLabel="divisionTitle"/>
      </form:select>
    </div>

    <button type="submit" class="btn btn-success">Save</button>
    <a class="btn btn-success" href="/schedule" role="button">Back to schedule</a>
  </div>
</form:form>

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
          <%--<c:if test="${player.playerTeam.teamId == team.teamId}">--%>
            <tr>
              <td scope="row">${player.playerNumber}</td>
              <td scope="row"><a href="/player?id=${player.playerId}">${player.playerFirstName} ${player.playerLastName}</a></td>
              <td scope="row">${player.playerAttackRate}</td>
              <td scope="row">${player.playerDefenceRate}</td>
              <td scope="row">${player.playerLongShotRate}</td>
            </tr>
          <%--</c:if>--%>
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
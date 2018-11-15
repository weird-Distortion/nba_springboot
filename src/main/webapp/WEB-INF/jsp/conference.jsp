<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
        integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

  <meta charset="UTF-8">
  <conferenceTitle>NBA championship</conferenceTitle>
</head>
<body>
<p class="text-center">Conference info</p>

<a class="btn btn-primary" href="/schedule">Back to regular season</a>

<div class="container">
  <div class="row">
    <div class="col-sm-12">
      <div>${conferenceAttribute.conferenceTitle}</div>
      <table class="table">
        <thead class="thead-dark">
        <tr>
          <th>#</th>
          <th>Team</th>
          <th>Players</th>
          <th>Games</th>
          <th>W</th>
          <th>L</th>
          <th>%</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${teams}" var="team">
          <c:if test="${team.teamConference.conferenceId == conference.conferenceId}">
            <tr>
              <td scope="row">#N</td>
              <td scope="row"><a href="/team?id=${team.teamId}">${team.teamTitle}</a></td>
              <td scope="row">#P</td>
              <td scope="row">G</td>
              <td scope="row">#W</td>
              <td scope="row">#L</td>
              <td scope="row">#%</td>
            </tr>
          </c:if>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>

<div class="container">
  <div class="row">
    <c:forEach items="${divisions}" var="division">
      <div class="col-sm-4">
        <div>${division.divisionTitle}</div>
        <table class="table">
          <thead class="thead-dark">
          <tr>
            <th>#</th>
            <th>Team</th>
            <th>Games</th>
            <th>W</th>
            <th>L</th>
            <th>%</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${teams}" var="team">
            <c:if test="${team.teamDivision.divisionId == division.divisionId}">
              <tr>
                <td scope="row">#N</td>
                <td scope="row"><a href="/team?id=${team.teamId}">${team.teamTitle}</a></td>
                <td scope="row">G</td>
                <td scope="row">#W</td>
                <td scope="row">#L</td>
                <td scope="row">#%</td>
              </tr>
            </c:if>
          </c:forEach>
          </tbody>
        </table>
      </div>
    </c:forEach>
  </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>

</body>
</html>
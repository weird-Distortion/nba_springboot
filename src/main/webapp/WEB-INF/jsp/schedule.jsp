<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <%--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"--%>
  <%--integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">--%>
  <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>--%>
  <%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>

  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
        integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
          integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
          crossorigin="anonymous"></script>
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
          integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
          crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
          integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
          crossorigin="anonymous"></script>
  <meta charset="UTF-8">
</head>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">NBA Simulator</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
          aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link" href="/schedule">Regular season <span class="sr-only">(current)</span></a>
      <a class="nav-item nav-link" href="#">Playoff</a>
      <a class="nav-item nav-link" href="#">Finals</a>
    </div>
  </div>
</nav>

<p class="text-center">Regular season</p>
<a class="btn btn-primary" href="/new-player">Add player</a>
<a class="btn btn-primary" href="/new-team">Add team</a>
<a class="btn btn-primary" href="/new-division">Add division</a>
<a class="btn btn-primary" href="/new-conference">Add conference</a>
<a class="btn btn-warning" href="/autofill">Autofill</a>
<a class="btn btn-danger" href="/clear-data">Clear</a>
<div class="container">
  <form:form method="post" modelAttribute="conf">
    <div class="row">
      <c:forEach items="${conferences}" var="conference">
        <div class="col-sm">
          <div><a href="/conference?id=${conference.conferenceId}">${conference.conferenceTitle}</a></div>
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
            <c:forEach items="${conference.getConferenceTeams()}" var="team">
              <c:if test="${team.teamConference.conferenceId == conference.conferenceId}">
                <tr>
                  <td scope="row">${conference.getConferenceTeams().indexOf(team) + 1}</td>
                  <td scope="row"><a href="/team?id=${team.teamId}">${team.teamTitle}</a></td>
                  <td scope="row">${team.teamPlayers.size()}</td>
                  <td scope="row">${team.gamesPlayed}</td>
                  <td scope="row">${team.teamWin}</td>
                  <td scope="row">${team.teamLose}</td>
                  <td scope="row">${team.teamWinrate}</td>
                </tr>
              </c:if>
            </c:forEach>
            </tbody>
          </table>
        </div>
      </c:forEach>
    </div>
    <button class="btn btn-success" type="submit">Play regular season</button>
  </form:form>
</div>
<a class="btn btn-info" href="/play-again">Play again</a>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>

</body>
</html>
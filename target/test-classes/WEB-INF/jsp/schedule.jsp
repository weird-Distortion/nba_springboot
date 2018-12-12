<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
  <p class="text-center">Regular season</p>
  <a class="btn btn-primary" href="/new-player">Add player</a>
  <a class="btn btn-primary" href="/new-team">Add team</a>
  <a class="btn btn-primary" href="/new-division">Add division</a>
  <a class="btn btn-primary" href="/new-conference">Add conference</a>
  <a class="btn btn-warning" href="/autofill">Autofill</a>
  <a class="btn btn-danger" href="/clear-data">Clear</a>
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
  <a class="btn btn-info" href="/play-again">Play again</a>
</div>

<%@ include file="common/footer.jspf" %>

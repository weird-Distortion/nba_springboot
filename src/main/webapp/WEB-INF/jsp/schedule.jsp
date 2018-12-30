<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
  <div class="text-center page-title">Regular season</div>
  <div class="d-flex justify-content-center">
    <div class="mr-3 my-2"><a class="btn btn-primary" href="/new-conference">Add conference</a></div>
    <div class="mr-3 my-2"><a class="btn btn-primary" href="/new-division">Add division</a></div>
    <div class="mr-3 my-2"><a class="btn btn-primary" href="/new-team">Add team</a></div>
    <div class="mr-3 my-2"><a class="btn btn-primary" href="/new-player">Add player</a></div>
  </div>
  <div class="d-flex justify-content-center">
    <div class="mr-3 my-2"><a class="btn btn-warning" href="/autofill">Autofill</a></div>
    <div class="mr-3 my-2"><a class="btn btn-danger" href="/clear-data">Clear</a></div>
  </div>
  <div class="container">
    <div class="row">
      <c:forEach items="${conferences}" var="conference">
        <div class="col-sm">
          <div class="d-flex justify-content-center conference-title">
            <a href="/conference?id=${conference.conferenceId}">${conference.conferenceTitle}</a>
          </div>
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
    <form:form method="post" modelAttribute="conf">
      <div class="d-flex align-items-center flex-column" id="test">
        <div class="mr-3 my-2">
          <button class="btn btn-success" type="submit">Play regular season</button>
        </div>
        <div class="mr-3 my-2">
          <a class="btn btn-info" href="/play-again">Play again</a>
        </div>
      </div>
    </form:form>
  </div>
</div>

<%@ include file="common/footer.jspf" %>

<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
  <p class="text-center">Conference info</p>

  <a class="btn btn-primary" href="/schedule">Back</a>

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
                <td scope="row">${conferenceAttribute.getConferenceTeams().indexOf(team) + 1}</td>
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
    </div>
  </div>

  <div class="container">
    <div class="row">
      <c:forEach items="${divisions}" var="division">
        <div class="col-xs-4">
          <div>${division.divisionTitle} division</div>
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
                  <td scope="row">${division.getSortedDivisionTeams().indexOf(team) + 1}</td>
                  <td scope="row"><a href="/team?id=${team.teamId}">${team.teamTitle}</a></td>
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
  </div>
</div>

<%@ include file="common/footer.jspf" %>
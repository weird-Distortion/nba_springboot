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
</div>

<%@ include file="common/footer.jspf" %>
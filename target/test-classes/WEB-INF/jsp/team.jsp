<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
  <p class="text-center">Team info</p>
  <a class="btn btn-success" href="/schedule" role="button">Back to schedule</a>
  <form:form method="post" modelAttribute="team">
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
    <div>
      <label for="attackRateDiv">Team attack rate:</label>
      <input type="number" value="${team.getTeamAttackRate()}" id="attackRateDiv" readonly>
    </div>
    <div>
      <label for="defenceRateDiv">Team defence rate:</label>
      <input type="number" value="${team.getTeamDefenceRate()}" id="defenceRateDiv" readonly>
    </div>
    <div>
      <label for="threePointRateDiv">Team three point rate:</label>
      <input type="number" value="${team.getTeamThreePointRate()}" id="threePointRateDiv" readonly>
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
              <td scope="row">${player.playerThreePointRate}</td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>

<%@ include file="common/footer.jspf" %>
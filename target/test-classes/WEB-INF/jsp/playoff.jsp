<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
  <p class="text-center">NBA playoff</p>

  <div class="row">
    <div class="col-sm-3" style="border: solid indigo">
      <div style="height: 100px; width: 150px; border: solid darkgreen">
        <div>${westTeams.get(0).getTeamTitle()}</div>
      </div>
      <div style="height: 100px; width: 150px; border: solid darkgreen">
        <div>${westTeams.get(7).getTeamTitle()}</div>
      </div>
      <div style="height: 100px; width: 150px; border: solid darkgreen">
        <div>${westTeams.get(1).getTeamTitle()}</div>
      </div>
      <div style="height: 100px; width: 150px; border: solid darkgreen">
        <div>${westTeams.get(6).getTeamTitle()}</div>
      </div>
      <div style="height: 100px; width: 150px; border: solid darkgreen">
        <div>${westTeams.get(2).getTeamTitle()}</div>
      </div>
      <div style="height: 100px; width: 150px; border: solid darkgreen">
        <div>${westTeams.get(5).getTeamTitle()}</div>
      </div>
      <div style="height: 100px; width: 150px; border: solid darkgreen">
        <div>${westTeams.get(3).getTeamTitle()}</div>
      </div>
      <div style="height: 100px; width: 150px; border: solid darkgreen">
        <div>${westTeams.get(4).getTeamTitle()}</div>
      </div>
    </div>

    <div class="col-sm-3" style="border: solid indigo">
      <div style="height: 100px; width: 150px; border: solid darkgreen">
        <div>${westWinner.getTeamTitle()}</div>
      </div>
    </div>

    <div class="col-sm-3" style="border: solid indigo">
      <div style="height: 100px; width: 150px; border: solid darkgreen">
        <div>${eastWinner.getTeamTitle()}</div>
      </div>
    </div>

    <div class="col-sm-3" style="border: solid indigo">
      <div style="height: 100px; width: 150px; border: solid darkgreen">
        <div>${eastTeams.get(0).getTeamTitle()}</div>
      </div>
      <div style="height: 100px; width: 150px; border: solid darkgreen">
        <div>${eastTeams.get(7).getTeamTitle()}</div>
      </div>
      <div style="height: 100px; width: 150px; border: solid darkgreen">
        <div>${eastTeams.get(1).getTeamTitle()}</div>
      </div>
      <div style="height: 100px; width: 150px; border: solid darkgreen">
        <div>${eastTeams.get(6).getTeamTitle()}</div>
      </div>
      <div style="height: 100px; width: 150px; border: solid darkgreen">
        <div>${eastTeams.get(2).getTeamTitle()}</div>
      </div>
      <div style="height: 100px; width: 150px; border: solid darkgreen">
        <div>${eastTeams.get(5).getTeamTitle()}</div>
      </div>
      <div style="height: 100px; width: 150px; border: solid darkgreen">
        <div>${eastTeams.get(3).getTeamTitle()}</div>
      </div>
      <div style="height: 100px; width: 150px; border: solid darkgreen">
        <div>${eastTeams.get(4).getTeamTitle()}</div>
      </div>
    </div>
  </div>
</div>

<form:form method="post" modelAttribute="playoffPlay">
  <div class="d-flex align-items-center flex-column" id="test">
    <div class="mr-3 my-2">
      <button class="btn btn-success" type="submit">Play playoff</button>
    </div>
    <div class="mr-3 my-2">
      <a class="btn btn-info" href="/play-again">Play again</a>
    </div>
  </div>
</form:form>
</div>

<%@ include file="common/footer.jspf" %>

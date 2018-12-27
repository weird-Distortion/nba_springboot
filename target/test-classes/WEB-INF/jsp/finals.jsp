<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
  <div class="text-center page-title">NBA finals</div>
  <div class="title-flex-container">
    <div class="conference-title">West champion</div>
    <div class="conference-title">East champion</div>
  </div>

  <div class="flex-container">
    <div class="outer">
      <div class="champs">
        <div class="team-title">${westChampion.getTeamTitle()}</div>
      </div>
    </div>

    <div class="outer">
      <div class="champs">
        <div class="team-title" id="champion">${champion.getTeamTitle()}</div>
      </div>
    </div>

    <div class="outer">
      <div class="champs">
        <div class="team-title">${eastChampion.getTeamTitle()}</div>
      </div>
    </div>
  </div>
</div>

<form:form method="post" modelAttribute="playoffPlay">
  <div class="d-flex align-items-center flex-column" id="test">
    <div class="mr-3 my-2">
      <button class="btn btn-success" type="submit">Play finals</button>
    </div>
    <div class="mr-3 my-2">
      <a class="btn btn-info" href="/play-again">Play again</a>
    </div>
  </div>
</form:form>
</div>

<%@ include file="common/footer.jspf" %>

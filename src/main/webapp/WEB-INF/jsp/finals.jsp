<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
  <p class="text-center">NBA finals</p>

  <div class="row">
    <div class="col-sm-4" style="border: solid indigo">
      <div style="height: 100px; width: 150px; border: solid darkgreen">
        <div>${champions.get(0).getTeamTitle()}</div>
      </div>
    </div>

    <div class="col-sm-4" style="border: solid indigo">
      <div style="height: 100px; width: 150px; border: solid red">
        <div>${champion.getTeamTitle()}</div>
      </div>
    </div>

    <div class="col-sm-4" style="border: solid indigo">
      <div style="height: 100px; width: 150px; border: solid darkgreen">
        <div>${champions.get(1).getTeamTitle()}</div>
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

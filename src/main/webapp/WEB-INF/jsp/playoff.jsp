<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
  <p class="text-center">NBA playoff</p>

  <div class="row">
    <div class="col-sm outer">
      <c:forEach items="${westPairs}" var="pair">
        <div class="inner-div">
          <div>${pair.get(0).getTeamTitle()}</div>
        </div>
        <div class="inner-div">
          <div>${pair.get(1).getTeamTitle()}</div>
        </div>
      </c:forEach>
    </div>

    <c:forEach items="${rounds}" var="round">
      <div class="col-sm outer">
        <c:forEach items="${round}" var="team">
          <div class="inner-div inner-round">
            <div>${team.getTeamTitle()}</div>
          </div>
        </c:forEach>
      </div>
    </c:forEach>

    <div class="col-sm outer">
      <c:forEach items="${eastPairs}" var="pair">
        <div class="inner-div">
          <div>${pair.get(0).getTeamTitle()}</div>
        </div>
        <div class="inner-div">
          <div>${pair.get(1).getTeamTitle()}</div>
        </div>
      </c:forEach>
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

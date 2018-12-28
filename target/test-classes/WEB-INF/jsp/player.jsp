<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
  <div class="text-center page-title">Player profile</div>

  <form:form method="post" modelAttribute="playerAttribute">
    <div class="d-flex flex-nowrap justify-content-around">
      <div class="form-group text-center">
        <div>
          <div>
            <div><form:label path="playerFirstName">First name:</form:label></div>
            <div><form:input path="playerFirstName" type="text"/></div>
          </div>
          <div>
            <div><form:label path="playerLastName">Last name:</form:label></div>
            <div><form:input path="playerLastName" type="text"/></div>
          </div>
          <div>
            <div><form:label path="playerNumber">Number:</form:label></div>
            <div><form:input path="playerNumber" type="number" min="0"/></div>
          </div>
        </div>
      </div>
      <div class="form-group text-center">
        <div>
          <div>
            <div><form:label path="playerAttackRate">Attack rate:</form:label></div>
            <div><form:input path="playerAttackRate" type="number" step="0.01" min="0"/></div>
          </div>
          <div>
            <div><form:label path="playerDefenceRate">Defence rate:</form:label></div>
            <div><form:input path="playerDefenceRate" type="number" step="0.01" min="0"/></div>
          </div>
          <div>
            <div><form:label path="playerThreePointRate">3-point shot rate:</form:label></div>
            <div><form:input path="playerThreePointRate" type="number" step="0.01" min="0"/></div>
          </div>
        </div>
      </div>
    </div>
    <div class="d-flex flex-column text-center">
      <div>
        <div class="form-group new-form">
          <form:label path="playerTeam">Team:</form:label>
          <form:select path="playerTeam" class="form-control">
            <form:options items="${teams}" itemLabel="teamTitle"/>
          </form:select>
        </div>

        <button type="submit" class="btn btn-success">Save</button>
        <a class="btn btn-primary" href="/schedule">Back to regular season</a>
      </div>
    </div>
  </form:form>
</div>

<%@ include file="common/footer.jspf" %>
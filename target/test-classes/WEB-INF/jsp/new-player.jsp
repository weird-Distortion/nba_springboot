<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
  <div class="text-center page-title">Add new player</div>

  <div class="d-flex flex-column text-center">
    <form:form method="post" modelAttribute="newPlayer">
      <div class="form-group">
        <div><form:label path="playerFirstName">First name</form:label></div>
          <div><form:input path="playerFirstName" type="text"/></div>
        <div><form:label path="playerLastName">Last name</form:label></div>
          <div><form:input path="playerLastName" type="text"/></div>
        <div><form:label path="playerNumber">Player number</form:label></div>
          <div><form:input path="playerNumber" type="number" min="0"/></div>
        <div><form:label path="playerAttackRate">Attack rate</form:label></div>
          <div><form:input path="playerAttackRate" type="number" step="0.01" min="0"/></div>
      <div><form:label path="playerDefenceRate">Defence rate</form:label></div>
          <div><form:input path="playerDefenceRate" type="number" step="0.01" min="0"/></div>
      <div><form:label path="playerThreePointRate">3-point rate</form:label></div>
          <div><form:input path="playerThreePointRate" type="number" step="0.01" min="0"/></div>

        <div class="form-group new-form">
          <form:label path="playerTeam">Select team:</form:label>
          <form:select path="playerTeam" class="form-control">
            <form:options items="${team}" itemLabel="teamTitle"/>
          </form:select>
        </div>

        <button type="submit" class="btn btn-success">Add</button>
      </div>
    </form:form>
  </div>
</div>

<%@ include file="common/footer.jspf" %>
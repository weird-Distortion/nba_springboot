<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
  <p class="text-center">Add new player</p>

  <form:form method="post" modelAttribute="newPlayer">
    <div class="form-group">
      <form:label path="playerFirstName">First name</form:label>
      <form:input path="playerFirstName" type="text"/>
      <form:label path="playerLastName">Last name</form:label>
      <form:input path="playerLastName" type="text"/>
      <form:label path="playerNumber">Player number</form:label>
      <form:input path="playerNumber" type="number" min="0"/>
      <form:label path="playerAttackRate">Attack rate</form:label>
      <form:input path="playerAttackRate" type="number" step="0.01" min="0"/>
      <form:label path="playerDefenceRate">Defence rate</form:label>
      <form:input path="playerDefenceRate" type="number" step="0.01" min="0"/>
      <form:label path="playerThreePointRate">3-point rate</form:label>
      <form:input path="playerThreePointRate" type="number" step="0.01" min="0"/>

      <div class="form-group">
        <form:label path="playerTeam">Select team:</form:label>
        <form:select path="playerTeam" class="form-control">
          <form:options items="${team}" itemLabel="teamTitle"/>
        </form:select>
      </div>

      <button type="submit" class="btn btn-success">Add</button>
    </div>
  </form:form>
</div>

<%@ include file="common/footer.jspf" %>
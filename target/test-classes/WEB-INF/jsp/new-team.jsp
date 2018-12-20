<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
  <p class="text-center">Add new team</p>

  <form:form method="post" modelAttribute="team">
    <div class="form-group">
      <form:label path="teamTitle">Title</form:label>
      <form:input path="teamTitle" type="text"/>
      <form:label path="teamCity">City</form:label>
      <form:input path="teamCity" type="text"/>

      <div class="form-group">
        <form:label path="teamConference">Select conference:</form:label>
        <form:select path="teamConference" class="form-control">
          <form:options items="${conferences}" itemLabel="conferenceTitle"/>
        </form:select>
      </div>

      <div class="form-group">
        <form:label path="teamDivision">Select division:</form:label>
        <form:select path="teamDivision" class="form-control">
          <form:options items="${division}" itemLabel="divisionTitle"/>
        </form:select>
      </div>

      <button type="submit" class="btn btn-success">Add</button>
    </div>
  </form:form>
</div>

<%@ include file="common/footer.jspf" %>
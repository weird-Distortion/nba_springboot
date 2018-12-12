<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
  <p class="text-center">Add new division</p>

  <form:form method="post" modelAttribute="division">
    <div class="form-group">
      <form:label path="divisionTitle">Title</form:label>
      <form:input path="divisionTitle" type="text"/>

      <div class="form-group">
        <form:label path="divisionConference">Select conference:</form:label>
        <form:select path="divisionConference" class="form-control">
          <form:options items="${conference}" itemLabel="conferenceTitle"/>
        </form:select>
      </div>

      <button type="submit" class="btn btn-success">Add</button>
    </div>
  </form:form>
</div>

<%@ include file="common/footer.jspf" %>
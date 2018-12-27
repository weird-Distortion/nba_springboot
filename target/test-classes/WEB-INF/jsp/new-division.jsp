<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
  <div class="text-center page-title">Add new division</div>

  <div class="d-flex flex-column text-center">
    <form:form method="post" modelAttribute="division">
      <div>

        <form:label path="divisionTitle">Title</form:label>
        <form:input path="divisionTitle" type="text"/>

        <div class="form-group new-form">
          <form:label path="divisionConference">Select conference:</form:label>
          <form:select path="divisionConference" class="form-control">
            <form:options items="${conference}" itemLabel="conferenceTitle"/>
          </form:select>
        </div>
      </div>

      <button type="submit" class="btn btn-success">Add</button>
    </form:form>
  </div>
</div>

<%@ include file="common/footer.jspf" %>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
  <div class="text-center page-title">Add new conference</div>

  <div class="d-flex flex-column text-center">
    <form:form method="post" modelAttribute="conference">
        <div><form:label path="conferenceTitle">Title</form:label></div>
        <div class="new-form"><form:input path="conferenceTitle" type="text"/></div>
        <button type="submit" class="btn btn-success">Add</button>
    </form:form>
  </div>
</div>

<%@ include file="common/footer.jspf" %>
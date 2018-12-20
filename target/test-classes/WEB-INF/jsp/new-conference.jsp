<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
  <p class="text-center">Add new conference</p>

  <form:form method="post" modelAttribute="conference">
    <div>
      <form:label path="conferenceTitle">Title</form:label>
      <form:input path="conferenceTitle" type="text"/>
    </div>
    <button type="submit" class="btn btn-success">Add</button>
  </form:form>
</div>

<%@ include file="common/footer.jspf" %>
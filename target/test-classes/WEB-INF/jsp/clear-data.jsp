<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
  <div class="text-center page-title">Clear data</div>
  <div class="d-flex flex-column text-center">
    <div class="text-center war-sign">Your data will be removed!</div>
    <form:form method="post" modelAttribute="conference">
      <button class="btn btn-danger" type="submit">Clear data</button>
    </form:form>
  </div>
</div>

<%@ include file="common/footer.jspf" %>
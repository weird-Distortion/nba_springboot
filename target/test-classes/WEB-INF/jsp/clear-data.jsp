<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
  <p class="text-center">CLEAR DATA</p>
  <p class="text-center">Your data will be removed! Are you sure?</p>
  <form:form method="post" modelAttribute="conference">
    <button class="btn btn-danger" type="submit">Clear data</button>
  </form:form>
</div>

<%@ include file="common/footer.jspf" %>
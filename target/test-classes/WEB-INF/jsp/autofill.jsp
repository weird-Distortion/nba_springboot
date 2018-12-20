<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf"%>

<div class="container">
  <p class="text-center">AUTOFILL DATA</p>
  <p class="text-center">Your data will be removed and replaced!</p>
  <form:form method="post" modelAttribute="conference">
    <button class="btn btn-warning" type="submit">Autofill</button>
  </form:form>
</div>

<%@ include file="common/footer.jspf" %>
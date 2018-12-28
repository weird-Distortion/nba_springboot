<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
  <div class="text-center page-title">Play again?</div>
  <div class="d-flex flex-column text-center">
    <div class="text-center war-sign">Your season results will be removed!</div>
    <form:form method="post" modelAttribute="conference">
      <button class="btn btn-info" type="submit">Play again</button>
    </form:form>
  </div>
</div>

<%@ include file="common/footer.jspf" %>
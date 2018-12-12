<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
  <p class="text-center">Play again?</p>
  <p class="text-center">Your season results will be removed!</p>
  <form:form method="post" modelAttribute="conference">
    <button class="btn btn-info" type="submit">Play again</button>
  </form:form>
</div>

<%@ include file="common/footer.jspf" %>
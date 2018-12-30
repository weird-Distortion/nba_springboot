<%@ include file="common/header.jspf" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">NBA Simulator</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
          aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link disabled" href="#">Regular season <span class="sr-only">(current)</span></a>
      <a class="nav-item nav-link disabled" href="#">Playoff</a>
      <a class="nav-item nav-link disabled" href="#">Finals</a>
    </div>
  </div>
</nav>

<div class="container">
  <div class="d-flex flex-column text-center">
    <div id="welcome-title">Welcome to the NBA championship!</div>
    <form:form method="post" modelAttribute="playoffPlay">
      <div>
        <button class="btn btn-success" type="submit">START</button>
      </div>
    </form:form>
  </div>
</div>

<%@ include file="common/footer.jspf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
        integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

  <meta charset="UTF-8">
  <conferenceTitle>NBA championship</conferenceTitle>
</head>
<body>
<p class="text-center">Regular season</p>
<a class="btn btn-primary" href="/new-team">Add team</a>
<div class="container">
  <div class="row">
    <div class="col-sm-6">
      <div>West</div>
      <table class="table">
        <thead class="thead-dark">
        <tr>
          <th>#</th>
          <th>Team</th>
          <th>Players</th>
          <th>Games</th>
          <th>W</th>
          <th>L</th>
          <th>%</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${teams}" var="team">
          <tr>
            <td scope="row">#N</td>
            <td scope="row">${team.teamTitle}</td>
            <td scope="row">#P</td>
            <td scope="row">G</td>
            <td scope="row">#W</td>
            <td scope="row">#L</td>
            <td scope="row">#%</td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>

    <div class="col-sm-6">
      <div>East</div>
      <table class="table">
        <thead class="thead-dark">
        <tr>
          <th>#</th>
          <th>Team</th>
          <th>Players</th>
          <th>Games</th>
          <th>W</th>
          <th>L</th>
          <th>%</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${teams}" var="team">
          <tr>
            <td scope="row">#N</td>
            <td scope="row">${team.teamTitle}</td>
            <td scope="row">#P</td>
            <td scope="row">G</td>
            <td scope="row">#W</td>
            <td scope="row">#L</td>
            <td scope="row">#%</td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>

</body>
</html>
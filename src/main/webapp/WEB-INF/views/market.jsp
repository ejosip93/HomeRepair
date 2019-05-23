<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row p-1">
<c:forEach items="${jobs }" var="job">
<div class="card offset-sm-1 col-sm-4" style="width: 18rem;  margin-bottom:50px;">
  <img class="card-img-top" src="data:image/jpeg;base64,${job.picture}" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">${job.name }</h5>
    <p class="card-text">${job.description }</p>
    <a href="#" class="btn btn-primary">${job.price }</a>
  </div>
</div>
</c:forEach>

</div>


<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="jumbotron row" style="height:200px">
		<div class="col-sm-3">
		<img style="width:150px;height:100px;" src="resources/home.png">
		</div>
		<div class="offset-sm-1 col-sm-5">
		<h1 style="font-family: 'Comic Sans MS', 'Comic Sans', cursive; font-size:50px;">HOME REPAIR</h1>
		</div>
		<sec:authorize access="isAuthenticated()">
			<sec:authentication var="principal" property="principal" />
			<div class="dropdown" style="float: right; margin-right: 50px;">
				<button type="button" class="btn btn-primary dropdown-toggle"
					data-toggle="dropdown">
					${principal.username}
				</button>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="<c:url value="/logout" />">Logout</a>

				</div>
			</div>
		</sec:authorize>
	
</div>

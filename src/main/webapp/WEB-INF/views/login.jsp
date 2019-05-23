<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="row row-centered">
	<div class="col-sm-8 col-md-6 col-lg-4 col-centered">
		<form action="login" method="POST">
			<div class="container">
				<c:if test="${not empty message}">
    				${message }
				</c:if>
				<div class="form-group">
					<label for="username"><b>Korisnik</b></label> <input type="text"
						class="form-control" placeholder="Username" name="username"
						required>
				</div>
				<div class="form-group">
					<label for="password"><b>Lozinka</b></label> <input
						type="password" class="form-control" placeholder="Password"
						name="password" required>
				</div>
				<button class="btn btn-primary" type="submit">Login</button>
			</div>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token }" />
		</form>
	</div>
	<div class="col-sm-4 col-md-2 col-lg-1 col-centered">
		<button type="button" class="btn btn-link" data-toggle="modal"
			data-target="#reg">Register</button>
	</div>
	<div id="reg" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Registriraj se</h4>
				</div>
				<div class="modal-body">
					<c:url var="post_url"  value="register" />
					<form:form action="${post_url }"  method="POST" model-attribute="user" enctype="multipart/form-data">
						<div class="container">
							<div class="form-group">
								<form:label for="email" path="email"><b>E-mail</b></form:label> 
								<form:input type="email" path="email" class="form-control" placeholder="E-mail" name="email" pattern=".*@[a-z]+\\.[a-z]{2,3}" required="true" oninvalid="this.setCustomValidity('Unesite ispravan mail')" oninput="this.setCustomValidity('')"/>
							</div>
							<div class="form-group">
								<form:label path="username" for="username"><b>Korisnik</b></form:label> <form:input type="text"
									class="form-control" path="username" placeholder="Username" name="username" pattern="[a-zA-Z0-9]{5,16}" oninvalid="this.setCustomValidity('Unesite 5 do 16 slova i brojeva')" oninput="this.setCustomValidity('')"
									required="true"/>
							</div>
							<div class="form-group">
							
								<form:label path="password" for="password"><b>Lozinka</b></form:label> <form:input
									type="password" path="password" class="form-control" placeholder="Password"
									pattern="[a-zA-Z0-9]{8,16}" name="password" required="true" oninvalid="this.setCustomValidity('Unesite 8 do 16 slova i brojeva')" oninput="this.setCustomValidity('')"/>
							</div>
							<div class="form-group">
								<form:label path="picture"><b>Slika</b></form:label><br>
            					<form:input type="file" path="picture" name="picture"/>
							</div>
							<div class="form-group">
								<form:label path="userType" for="userType"><b>Vrsta korisnika</b></form:label><br>
								<form:radiobutton path="userType" value="2"/> Korisnik<br>
  								<form:radiobutton path="userType" value="3"/> Majstor<br>
							</div>
							<button class="btn btn-primary" type="submit">Register</button>
						</div>
					</form:form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>

</div>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="row row-centered">
	<div class="col-sm-8 col-md-6 col-lg-4">
		<form:form action="job" method="POST" model-attribute="jobForm">

			<div class="form-group">
				<form:label for="name" path="name">
					<b>Naziv</b>
				</form:label>
				<form:input type="text" path="name" class="form-control"
					placeholder="Naziv" name="name" 
					required="true" />
			</div>
			
			<div class="form-group">
				<form:label for="description" path="description">
					<b>Opis</b>
				</form:label>
				<form:textarea path="description" class="form-control"
					placeholder="Opis" name="description" rows="5" cols="30"
					required="true" />
			</div>
				
			<div class="form-group">
				<form:label for="price" path="price">
					<b>Cijena</b>
				</form:label>
				<form:input type="number" path="price" class="form-control"
					placeholder="Cijena" name="price" 
					required="true" />
			</div>
						
			<button class="btn btn-primary" type="submit">Dodaj posao</button>

		</form:form>
	</div>
</div>
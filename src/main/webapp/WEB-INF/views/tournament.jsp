<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="mySidenav" class="sidenav">
	<a href="<c:url value="/users" />" id="about">Korisnici</a>
</div>
<div class="row row-centered" style="margin-left: 60px;">

	<div class="col-lg-3 col-md-3 col-sm-1">

		<input class="form-control" type="text" id="nazivTima" />
		<button class="btn btn-primary" type="submit" id="dodaj"
			onclick="dodajNoviTim()">Dodaj tim</button>
		<br> <br> <br>
		
			<label for="domacin">Host</label> <select class="form-control"
				id="domacin">
				<option>Izaberi...</option>
			</select> 
			<br>
			<label for="gost">Guest</label> <select class="form-control"
				id="gost">
				<option>Izaberi...</option>
			</select>
			<br>
			<div class="form-group">
				<input style="width: 50%;" type="text" class="form-control"
					placeholder="rez1:rez2" id="rez"/>
			</div>
			<button class="btn btn-primary" id="rezultat" onclick="rezultat()">Potvrdi rezultat</button>
		

	</div>

	<div class="col-centered col-lg-9 col-md-10 col-md-11">
		<table id="tablica" class="table table-bordered">
			<thead>
				<tr>
					<th>Naziv tima</th>
					<th>Odigrane utakmice</th>
					<th>Zabijeni golovi</th>
					<th>Primljeni golovi</th>
					<th>Gol razlika</th>
					<th>Bodovi</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>

	</div>
</div>
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
<script type="text/javascript">
	var tablica = $("#tablica").dataTable();
	var ctx = "${pageContext.request.contextPath}";

	osvjeziTablicu();
	popuniListe();
	
	function rezultat(){
		var dom = $("#domacin").val();
		var gost = $("#gost").val();
		var rez = $("#rez").val();
		var tekst = dom + ':' + gost + ':' + rez;
		
		$.ajax({
			type : "POST",
			url : ctx + "/result",
			data : tekst,
			success : function(resp){
				osvjeziTablicu();
			},
			errorr : function(){
				alert('errorr');
			}
		});
	};
	
	function dodajNoviTim() {

		var nazivTima = $("#nazivTima").val();

		$.ajax({
			type : "GET",
			url : ctx + "/dodajTim/" + nazivTima,
			success : function() {
				osvjeziTablicu();
				deleteDups();
				$("#domacin").append('<option>Izaberi...</option>');
				$("#gost").append('<option>Izaberi...</option>');
				popuniListe();
				
			},
			error : function() {
				alert('error');
			}
		});
	};

	function osvjeziTablicu() {
		$.ajax({
			url : ctx + "/getTeams",
			success : function(res) {
				tablica.fnClearTable();
				var json = $.parseJSON(res);
				for ( var i in json) {
					tablica.fnAddData([ json[i].name, json[i].played,
							json[i].scored, json[i].received,
							json[i].difference, json[i].points ]);
				}
			},
			error : function() {
				alert('error');
			}
		});
	}
	
	function popuniListe(){
		$.ajax({
			url : ctx + "/fillSelect",
			success : function(res){
				
				var json = $.parseJSON(res);
				for ( var i in json) {
					$("#domacin").append('<option value="' + json[i].id + '">' + json[i].name + '</option>');
					$("#gost").append('<option value="' + json[i].id + '">' + json[i].name + '</option>');

				}
			},
			errorr : function(){
				alert('error');
			}
		});
	}
	
	function deleteDups(){
		    $("#domacin option").remove();
		    $("#gost option").remove();
	}
</script>

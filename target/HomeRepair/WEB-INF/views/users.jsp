<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table id="korisnici"  class="hover" style="width:100%">
	<thead>
		<tr>
			<th>Username</th>
			<th>Email</th>
			<th>Password</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${korisnici}" var="korisnik">
			<tr>
				<td style="background-color:white;">${korisnik.username }</td>
				<td style="background-color:white;">${korisnik.email }</td>
				<td style="background-color:white;">${korisnik.password }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
<script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
<script>
	$(function() {
		$("#korisnici").dataTable();
	})
</script>
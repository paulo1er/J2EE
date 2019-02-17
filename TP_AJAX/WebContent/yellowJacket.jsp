<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TP AJAX</title>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
</head>
<body>
	<h1>Nombre de gilets jaunes en Live !!</h1>
	<p>
		<label id="pays"></label> : <label id="nb"></label>
	</p>
	<br />
	<img id="graph" src="/TP_AJAX/GraphicYellowJacket?pays=France">
	<br />

	<div>
		<select name='pays' id="paysSelect">
			<option value='France'>France</option>
			<option value='Allemagne'>Allemagne</option>
			<option value='Pologne'>Pologne</option>
		</select> <input type="checkbox" id="refresh"> <label for="refresh">refresh</label>
		<button id="replaceContent">load</button>
	</div>
	<br />
	<p>DRU Guillaume ; MADELINE Paul</p>
	<script type="text/Javascript">
		$(document).ready(
				function() {
					function load() {
						var pays = $("#paysSelect").val();
						var refresh = $("#refresh").is(":checked");
						console.log(pays + " : " + refresh);
						$.getJSON("Ajax?pays=" + pays + "&refresh=" + refresh,
								function(data) {
									console.log(data);
									$("#pays").text(data.pays);
									$("#nb").text(data.nb);
									$("#graph").attr(
											"src",
											"/TP_AJAX/GraphicYellowJacket?pays="
													+ data.pays);
								});
					}
					load();
					$("#replaceContent").click(load);
				});
	</script>
</body>
</html>
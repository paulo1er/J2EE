<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
</head>
<body>

	<div id="quote">
		<hr>
		<p>Hello</p>
		<hr />
	</div>
	<input type="text" id="name" value="Stephane">
	<input type="submit" id="replaceContent" value="Refresh local"></input>
	<script type="text/Javascript">
		$(document).ready(function() {
			$("#replaceContent").click(function() {
				var name = $("#name").val();
				$.getJSON("Ajax?name=" + name, function(data) {
					console.log(data);
					var helloWorldData = data.content;
					$("#quote p").html("<p>" + helloWorldData + "</p>");
				});
			});
		});
	</script>
</body>
</html>
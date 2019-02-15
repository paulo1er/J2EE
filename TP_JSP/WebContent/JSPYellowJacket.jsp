<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Hello JSP</h2>
	<p><%=request.getParameter("pays")%>
		:
		<%=request.getParameter("nb")%></p>
	<img src="/TP_JSP/GraphicYellowJacket?pays=<%=request.getParameter("pays")%>">
	<form action='/TP_JSP/JSPYellowJacket' method='post'>
		<select name='pays'>
			<option value='France'>France</option>
			<option value='Allemagne'>Allemagne</option>
			<option value='Pologne'>Pologne</option>
		</select> <input type='checkbox' name='refresh' value='true'>refresh<br>
		<input type='submit' />
	</form>
</body>
</html>
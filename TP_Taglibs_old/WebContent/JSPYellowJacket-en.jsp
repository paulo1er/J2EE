<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TP Taglib</title>
</head>
<body>
	<h2>Number of Yellow Jackets</h2>
	<p><%=request.getParameter("paysName")%>
		:
		<%=request.getParameter("nb")%></p>
	<img src="/TP_Taglibs/GraphicYellowJacket?pays=<%=request.getParameter("pays")%>">
	<form action='/TP_Taglibs/JSPMultiLanguageYellowJacket' method='post'>
	<h3>Select a country</h3>
		<select name='pays'>
			<option value='France'>France</option>
			<option value='Allemagne'>Germany</option>
			<option value='Pologne'>Poland</option>
		</select> <input type='checkbox' name='refresh' value='true'>refresh<br>
		<h3>Select your language</h3>
		<select name='langue'>
			<option value='English'>English</option>
			<option value='Français'>Français</option>
		</select>
		
		<input type='submit' value="Submit" />
	</form>
	<br />
	<p>DRU Guillaume ; MADELINE Paul</p>
</body>
</html>
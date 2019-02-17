<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TP Taglibs</title>
<%@ taglib uri="taglib1" prefix="mytags"%>
</head>
<body>

	<h2>Tag Libs</h2>

	<mytags:displayInfo lang='<%=request.getParameter("lang")%>'
		key='<%=request.getParameter("pays")%>' />
	<br>
	<br>

	<img
		src="/TP_Taglibs/GraphicYellowJacket?pays=<%=request.getParameter("pays")%>">

	<form action='/TP_Taglibs/TagLibMultiLanguageYellowJacket'
		method='post'>


		<select name='pays'>
			<mytags:chooseCountry lang='<%=request.getParameter("lang")%>'
				key='Allemagne' />
			<mytags:chooseCountry lang='<%=request.getParameter("lang")%>'
				key='France' />
			<mytags:chooseCountry lang='<%=request.getParameter("lang")%>'
				key='Pologne' />
		</select> <select name='lang'>
			<option value='Français'>Francais</option>
			<option value='English'>English</option>
		</select> <input type='submit' />
	</form>
	<br>
	<p>DRU Guillaume ; MADELINE Paul</p>

</body>
</html>

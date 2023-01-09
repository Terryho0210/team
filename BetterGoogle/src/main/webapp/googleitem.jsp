<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Better Google</title>
<style type="text/css">
#padding{
	padding: 0px 0px 15px 15px;
}
a {
	color: #2D2926;
	font-size: 18px;
	font-weight: bold;
	text-decoration: none;
}
a:hover{
text-decoration:underline;
}
.border-style {
	border-radius: 90px/90px;
}
</style>
</head>
<img src="images/background2_11zon.jpg" style='position:fixed;width:1300px;left:0%;top:0%;margin-top:0px;margin-left:0px '>
<form action='${requestUri}' method='get'>

	<div style='position: absolute;margin-top:150px;margin-left:50px'>
		<%
		String[][] orderList = (String[][]) request.getAttribute("query");
		for (int i = 0; i < orderList.length; i++) {
			String s=orderList[i][1];
			//s=s.substring(7);
		%>
		
		<a href='<%=s%>'target="_blank"><%=orderList[i][0]%> </a> <p>
		<%
}
%>
	</div>

		<div>
		<input type='text' class="border-style" id="padding" name='keyword'
			style='font-size: 120%; position: absolute; left: 50%; top: 50%; margin-top: -250px; margin-left: -400px; width: 800px; height: 25px'
			placeholder = '輸入關鍵字' value='<%=request.getParameter("keyword")%>'/>
			</div>
</form>
</body>
</html>
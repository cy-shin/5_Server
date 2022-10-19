<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- <%@ %> 페이지 지시자
    	java 형식으로 작성함
    	contentType도 지정함
    
     --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과 페이지</title> ㅠ

<style>
	h1{
		background-color: yellow;
		color: red;
	}
</style>

</head>
<body>
	<h1>로그인 결과</h1>
	
	<!-- jsp에서 자바코드의 값을 출력하는 방법 -->
	<%= request.getParameter("inputId") %>
	
	<br>
	
	<%= request.getParameter("inputPw") %>

	<br>
	
	<!-- jsp에서 자바코드의 값을 출력하는 방법 -->
	<%-- <%= 2 * 5 + 10 %> --%>
	
	<!-- jsp에서 자바코드를 작성하는 방법 -->
	
	<% 
		// request.getAttribute("key") -> value(object 타입)
		String res = (String)request.getAttribute("r");
						// -> 다운캐스팅 필요
	%>
						<!-- res 변수에 저장된 값이 출력됨 -->
	<h3 style='color:green;'> <%= res %></h3>
	
	<button type='button' onclick='history.back();'> 돌아가기 </button>
</body>
</html>
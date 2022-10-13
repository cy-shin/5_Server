<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%-- Person 클래스 import --%>
<%-- <%@ page import="edu.kh.jsp.model.vo.Person" %> --%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EL 결과</title>
</head>
<body>

	<h3>EL을 이용해서 출력하기</h3>
	
	<h3>파라미터</h3>
	<pre>
        EL로 request에 세팅된 파라미터를 얻어오는 방법
		\${ param.name속성값}
		
		+ 데이터 파싱(String -> int)도 자동으로 된다!
	</pre>

    이름 : ${param.inputName} <br>
    나이 : ${param.inputAge} <br>
    주소 : ${param.inputAddress} <br>
	
	<h4>추가 세팅된 값</h4>
	<pre>
		\${ 세팅한 key 값 }
		1) request에 추가 세팅된 값을 얻어올 때 별도로 다운 캐스팅을 하지 않아도 됨
		2) import 구문도 생략
		3) 객체에 저장된 값을 얻어올 때 getter를 호출할 때 "get필드명()" 형식이 아니라
		   필드명만 작성하면 된다!
		   
		+ 데이터 파싱(String -> int)도 자동으로 된다!
		
	</pre>
	
	메세지 : ${ message } <br>
	
	person의 name : ${person.name } <br>
	person의 age : ${person.age +100 } <br>
	person의 address : ${person.address } <br>
	
	person.toString() : ${ person } <!-- 자동으로 toString 적용 -->
	
	<hr>

    <%-- Scriptlet, Expression --%>
    <%
        // 파라미터 얻어오기
        String inputName = request.getParameter("inputName");
        int inputAge = Integer.parseInt(request.getParameter("inputAge"));
        String inputAddress = request.getParameter("inputAddress");

        // 추가 세팅된 값 얻어오기
        String message = (String)request.getAttribute("message");
        // Person person = (Person)request.getAttribute("person");

    %>

    <h4>파라미터</h4>
    이름 : <%= inputName %> <br>
    나이 : <%= inputAge %> <br>
    주소 : <%= inputAddress %> 

    <h4>추가 세팅된 값</h4>
    메세지 : <%= message %> <br>
    
<%--
    person의 name : <%= person.getName() %> <br>
    person의 age : <%= person.getAge() %> <br>
    person의 address : <%= person.getAddress() %> <br>

    person.toString() : <%= person.toString() %>
--%>    


    <hr>

    <h3>EL에서 null과 '비어있다'에 대한 처리 방법</h3>
    <%-- null : 참조 X, 비어있다 : 객체 O 내용 X --%>
    <h4 style="color:red">EL은 null도 빈칸으로 인식 -> null과 비어있다를 구별하지 못함</h4>

    <h4>empty : 비어있거나 null인지를 검사하는 연산자</h4>

    <% 
        List<String> list = null; // import 필요
    %>
	<pre>
		list2 = null; // null
		list3 = new ArrayList(); // 비어있는 리스트
		list4 = new ArrayList();
		list4.add("테스트");
		
    	[표현식]
    	list2 : <%= request.getAttribute("list2") == null %>
    	list3 : <%= request.getAttribute("list3") == null %>
    	list4 : <%= request.getAttribute("list4") == null %>
	
		[empty]
		list2 : ${empty list2 } <!-- true -->
		list3 : ${empty list3 } <!-- true -->
		list4 : ${empty list4 } <!-- false -->
		
		* empty 연산자를 이용하면 null과 비어있다를 구분할 수 없기 때문에
		  servlet에서 추가적인 값을 세팅해서 위임하기 전에
		  이를 구분할 수 있는 방법을 작성해야 한다.
	</pre>
</body>
</html>
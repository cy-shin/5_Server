<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%-- JSP 액션 태그; --%>
 
 <!--  
 	JSP 액션 태그 중 forward 
 	- servlet -> jsp(==servlet) 요청 위임
 	- jsp 위임 시 jsp 파일 경로 사용

	- jsp(==servlet) -> servlet 요청 위임
	- Servlet 위임 시 요청 주소 작성 		
 -->
 
 <jsp:forward page="main"/>;
 <%-- 메인 페이지(index.jsp) 요청이 왔을 때
 		요청 주소가 /main인 servlet으로 요청 위임
 		-> servlet == back-End -> db 연결 가능
 		-> 다시 jsp 위임 가능
 --%>
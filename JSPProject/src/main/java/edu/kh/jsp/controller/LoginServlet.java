package edu.kh.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login") // web.xml에 작성하던 <servlet>, <servlet-mapping> 태그를 대체하는 어노테이션

/* WebServlet 사용 시 아래의 내용이 자동입력됨
 * 
 * - Servlet 등록 + 이름 지정
 * <servlet>
 * 	<servlet-name>loginServlet</servlet-name>
 * 	<servlet-class>edu.kh.jsp.controller.LoginServlet</servlet-class>
 * </servlet>
 * 
 * - 요청 주소에 따라 처리할 Servlet을 지정
 * <servlet-mapping>
 * 	<servlet-name>loginServlet</servlet-name>
 * 	<url-pattern>/login</url-pattern>
 * </servlet-mapping>
 * 
 **/

		
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 전달 받은 파라미터를 얻어와 변수에 저장
		
		// post 방식 요청 데이터 문자 인코딩 처리
		req.setCharacterEncoding("UTF-8");
		
		// 전달 받은 파라미터를 얻어와 변수에 저장
		String id = req.getParameter("inputId"); 
		String pw = req.getParameter("inputPw");

		
		System.out.println(id);
		System.out.println(pw);
		
		String result = null;
		
		if(id.equals("user01") && pw.equals("pass01")) { // 아이디가 user01, 비밀번호가 pass01!인 경우
			result = "로그인 성공";
		} else {
			result = "아이디 또는 비밀번호가 일치하지 않습니다.";
		}
		
//		// 응답하려는 형식, 문자 인코딩 지정
//		resp.setContentType("text/html; charset=UTF-8");
//		
//		// 클라이언트 응답용 스트림
//		PrintWriter out = resp.getWriter();
//		
//		out.println("<!DOCTYPE html>");
//		out.println("<html>");
//		
//		out.println("<head>");
//		out.println("<title>로그인 결과 페이지</title>");
//		out.println("</head>");
//		
//		out.println("<body>");
//		out.println("<h1>로그인 결과</h1>");
//		out.printf("<h3 style='color:green;'> %s </h3>", result);
//		out.println("<button type='button' onclick='history.back()'> 돌아가기 </button>");
//		out.println("</body>");
//		
//		out.println("</html>");
		
		// **************************************************************************************
		
		// ** JSP를 이용해 응답하기 **
		
		// Dispatcher : 발송자, 필요한 정보를 제공하는 자, 역할을 넘긴다(==위임)
		// RequestDispatcher == 요청을 위임하는 역할의 객체
		// 어디로? /WEB-INF/views/ 위치에 있는 loginResult.jsp 파일
		// 무엇을? 요청에 대한 응답화면을 만들어 클라이언트에게 출력하는 역할
		
		// req.getRequestDispatcher("JSP 경로")
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/loginResult.jsp");
		dispatcher.forward(req, resp);
		
		
	}
}

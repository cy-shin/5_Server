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
		// - HttpServletRequest 객체가 생성될 때
		//   내부에 요청을 위임하는 객체를 생성하는 방법을 포함하고 있음
		
		// ** JSP 경로 작성 방법 **
		// **** -> webapp폴더를 기준으로 파일 경로 작성 *****
		
		// ex) /WEB-INF/views/loginResult.jsp
		// webapp 폴더 내부에 존재하는 WEB-INF 폴더
		// WEB-INF 폴더 내부에 존재하는 views 폴더
		// views 폴더 내부에 존재하는 loginResult.jsp 파일 선택
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/loginResult.jsp");
		
		// ***** forward *****
		// - 보내다, 전달하다, 전송하다
		// - HttpServletRequest, HttpServletResponse를 매개변수로 전달
		//   왜? JSP가 요청 데이터(req)를 이용해서 화면을 만들고
		//   클라이언트에게 응답(resp)하기 위해서 매개변수로 전달
		
		// - forward는 페이지 이동을 직접 하지 않음
		//   Servlet의 역할 중 응답화면 출력 역할을 분업한 JSP에게 req, resp를 전달만 해줌
		//   -> jsp가 응답을 대신해줄 뿐임
		//   결론 : 페이지 이동 X -> 주소창의 요청 주소도 변하지 않는다!
		
		// req.setAttribute(String key, Object value)(Map형식)
		// Attribute 데이터(값)을 의미함
		
		req.setAttribute("r", result);
							// Object로 업캐스팅 된 상태
		
		dispatcher.forward(req, resp);
		// req 요청 관련 정보, 데이터 <-- 값을 저장하는 용도에 적합함
		// resp 응답 관련 기능, 속성 등
		
	}
}

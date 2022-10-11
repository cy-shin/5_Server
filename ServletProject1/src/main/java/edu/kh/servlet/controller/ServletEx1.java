package edu.kh.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Controller: 요청에 따라 응답할 코드를 제어 mvc모델?

// Servlet 클래스를 만들기 위해서는
// javax.servlet.http.HttpServlet 추상클래스를 반드시 상속받아야 함
// - 요청, 응답을 위한 방법(메서드)를 제공하는 추상클래스
// - tomcat에서 제공하는 클래스
// - * javax는 java가 아닌 외부에서 만들어 제공한 클래스

// - 이 클래스를 상속받았을 때, override 경고가 뜨지 않음 -> 추상 클래스지만 추상 메서드가 없다!
// - Q. 왜 추상메서드를 사용하지 않는데도 추상클래스로 만들었을까?
// - A. 사용자가 별도의 객체를 직접 만들수 없게 하려고

public class ServletEx1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// HttpServletRequest : 클라이언트의 정보 + 요청 관련 정보가 담긴 객체
		// HttpServletResponse : 서버가 클라이언트에게 응답하는 방법을 제공하는 객체
		
		// 수정할 때 서버를 끄고 해야 오류가 발생할 일이 줄어듬
		
		System.out.println("이름, 나이를 제출 받아서 처리할 코드 수행");
		
		// 요청 시 함께 전달된 input 태그의 값(==Parameter)을 얻어오는 방법
		
		// req.getParameter("input 태그의 name 속성 값");
		// -> String 형태로 입력된 값 반환
		// ** 얻어온 파라미터는 무조건 String ! **
		
		String inputName = req.getParameter("inputName");
		String inputAge = req.getParameter("inputAge");
		// html문서에서 inputAge를 숫자로 설정했지만, servlet을 거치면 String으로 넘어옴
		
		System.out.println(inputName + " / " + inputAge);
		
		// resp.getWriter() : Server가 Client에게 응답할 수 있는 스트림을 얻어옴
		// -> PrintWriter : 출력 전용 스트림
		
		// 인코딩을 UTF-8형식으로 바꿈
		// resp.setCharacterEncoding("UTF-8"); -> 사용 X
		
		// 올바른 방식 : 문서 형식과 문자 인코딩을 지정함
		// -> html문서를 작성했으며, 문자는 utf-8형식으로 인코딩하였음을 브라우저에 알리는 용도
		// -> 브라우저가 문서 타입과 문자 인코팅 형식에 맞게 해석함
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		out.print(inputName + "님의 나이는 " + inputAge + "세 입니다.");
		
	}
}

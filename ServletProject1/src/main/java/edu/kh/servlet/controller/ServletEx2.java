package edu.kh.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Servlet 코드를 작성하기 위해서는 HttpServlet을 상속받아야 한다.
public class ServletEx2 extends HttpServlet {
	@Override
	// Get 방식 요청을 처리하는 메서드
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 전달된 input 태그의 값(파라미터)를 얻어와서 변수에 저장
		// 파라미터 = String
		String orderer = req.getParameter("orderer");
		
		// radio 버튼은 하나만 선택 가능 == 값 1개만
		String type = req.getParameter("type");

		// select 박스는 1개의 option만 선택 가능 == 값 1개만 서버로 제출됨
		String coffee = req.getParameter("coffee");
		
		// checkbox와 같이 하나의 name 속성으로 여러 값이 전달 될 경우
		// req.getParameter() -> 여러 값 중 첫 번째 값만 얻어옴(String type)
		// 여러개를 얻어오려면? req.getParameterValues(); 여러 값을 모두 얻어오는데 String[] 형태로 얻어옴
													// 단 값이 하나도 없으면 null
		// String opt = req.getParameter("opt");
		String opt[] = req.getParameterValues("opt");
		
		System.out.println("주문 내용을 정상적으로 전달받음");
		
		// 주문자명 : 홍길동
		// 주문한 메뉴 : 따뜻한 아메리카노
		// 			  아이스 아메리카노
		// 선택한 옵션(ul, 옵션이 있는 경우에만 보여줌)
		// -샷 추가
		// -시럽 추가
		// -포장하기
		
		// 응답을 위해 준비해야할 것
		// 1) 문서 형식 + 문자 인코딩 지정
		resp.setContentType("text/html; charset=UTF-8");
		
		// 2) 응답을 위한 서버 -> 클라이언트 스트림 얻어오기
		PrintWriter out = resp.getWriter();
		
		// 응답용 스트림을 이용해 html 코드를 출력 -> html 코드로 해석되어 보여짐
		// (html, css, js 등 브라우저가 해석할 수 있는 코드는 모두 해석되어 보여짐)
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");

		out.println("<head>");
		out.println("<title>" + orderer + "님의 주문 내역</title>");
		out.println("</head>");
		

		
		out.println("<body>");
		out.printf("<h3>주문자명 : %s\n</h3>",orderer);
		
		out.print("<h3>");
		out.print("주문한 메뉴 : ");
		
		if(type.equals("hot")) {
			out.print("따뜻한");
		}
		if(type.equals("ice")) {
			out.print("아이스");
		}
		out.print(coffee);
		out.print("</h3>");
		
		if(opt!=null) {
			out.print("<ul>");
			for(String o : opt) {
				String temp = "";
				switch(o) {
				case "addShot": temp="샷 추가"; break;
				case "addSyrup": temp="시럽 추가"; break;
				case "addPack": temp="포장하기"; break; 
				}
				out.printf("<li>%s</li>\n", temp);
			}
			out.print("</ul>");
		}
		out.println("</body>");
		out.println("</html>");
		
		/* Dynamic Web Project(동적 웹 프로젝트, 동적 웹 애플리케이션)
		 * - 요청에 따라서 응답되는 화면(html)을 실시간으로 만들어내서(동적)
		 * 	 클라이언트에게 전달(응답)하는 프로젝트
		 * */
	}
}

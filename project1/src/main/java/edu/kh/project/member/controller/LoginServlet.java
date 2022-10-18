package edu.kh.project.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.project.member.model.dao.MemberDAO;
import edu.kh.project.member.model.service.MemberService;
import edu.kh.project.member.model.vo.Member;

@WebServlet("/member/login")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 서비스 객체 생성
		MemberService service = new MemberService();
		
		try {
			// POST방식 인코딩
			req.setCharacterEncoding("UTF-8");
			
			// 파라미터 가져오기
			String inputEmail = req.getParameter("inputEmail");
			String inputPw = req.getParameter("inputPw");
			
			// Member 객체에 파라미터 저장
			Member member = new Member();
			member.setMemberEmail(inputEmail);
			member.setMemberPw(inputPw);
			
			// 로그인 service 호출 후 결과 반환
			Member loginMember = service.login(member);
			
			// forward를 하는 경우(로그인 상황에는 부적절한 예시)
			// forward : 요청을 다른 Servlet이나 JSP로 위임
			//			-> 어떤 요청이 위임됐는지 알아야 되기 때문에 주소창에 요청 주소가 계속 남아있다!
			/* RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/common/main.jsp");
			
			req.setAttribute("loginMember", loginMember);
			
			dispatcher.forward(req, resp); */
			
			// *** redirect(재요청) ***
			// - servlet이 다른 주소를 요청함
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

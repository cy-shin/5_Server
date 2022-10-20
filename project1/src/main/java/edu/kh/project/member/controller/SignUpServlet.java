package edu.kh.project.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.project.member.model.service.MemberService;
import edu.kh.project.member.model.vo.Member;

@WebServlet("/member/signUp")
public class SignUpServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/member/signUp.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberService service = new MemberService();

		// 데이터 문자 인코딩 변환
		// req.setCharacterEncoding("UTF-8");
		
		String memberEmail = req.getParameter("memberEmail");
		String memberPw = req.getParameter("memberPw");
		String memberNickName = req.getParameter("memberNickName");
		String memberTel = req.getParameter("memberTel");
		
		// 선택적으로 입력하는 값, 미입력 시 빈칸{,,}
		String[] arr = req.getParameterValues("memberAddress");
		
		String memberAddress = null;
		
		// 주소가 입력된 경우 하나의 문자열로 변환
		if(!arr[0].equals("") && !arr[1].equals("")) {
			memberAddress = String.join(",,", arr);
			
			// String.join("구분자", 배열)
			// 모든 배열 요소를 하나의 문자열로 반환
			// 요소 사이사이에 "구분자"를 추가함
			
		}
		
		Member member = new Member();
		
		member.setMemberEmail(memberEmail);
		member.setMemberPw(memberPw);
		member.setMemberNickName(memberNickName);
		member.setMemberTel(memberTel);
		member.setMemberAddress(memberAddress);
		
		
		try {
			// 회원가입
			int result = service.signUp(member);
			
			String path = null;
			HttpSession session = req.getSession();
			// 서비스 수행 결과에 따라 결과화면 제어ㅇ
			if(result > 0) { 
				path="/"; //메인 페이지
				session.setAttribute("message", "회원 가입 성공!");
			} else { 
				path="/member/signUp";	
				session.setAttribute("message", "회원 가입 실패!");
			}
			
			resp.sendRedirect(path);
			
		} catch (Exception e) {
			String errorMessage = "회원가입 중 문제가 발생했습니다.";
			
			req.setAttribute("errorMessage", errorMessage);
			req.setAttribute("e", e);
			
			String path = "/WEB-INF/views/common/error.jsp";
			
			req.getRequestDispatcher(path).forward(req, resp);
		}
	}
}

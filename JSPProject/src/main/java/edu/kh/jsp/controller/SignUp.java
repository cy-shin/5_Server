package edu.kh.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signUp")
public class SignUp extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 요청 데이터 문자 인코딩 처리
		req.setCharacterEncoding("UTF-8");
		
		// getParameter로 값을 가져옴
//		String id = req.getParameter("memberId");
//		String[] pw = req.getParameterValues("memberPw");
//		String name = req.getParameter("memberName");
//		String email = req.getParameter("memberEmail");
//		String[] hobby = req.getParameterValues("hobby");
//		
		// jsp로 요청 위임 작업
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/signUpResult.jsp");
		
		// forward
		dispatcher.forward(req, resp);
	}
}

package edu.kh.project.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/logout")
public class LogoutServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// HttpSession 객체를 얻어와서
		// Session을 무효화 하고
		// 메인 페이지를 재요청함
		
		HttpSession session = req.getSession(); // session 얻어오기
		
		session.invalidate(); // session 무효화
		
		resp.sendRedirect("/"); // redirect를 이용해서 재요청
	}
}

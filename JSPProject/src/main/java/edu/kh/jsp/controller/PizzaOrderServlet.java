package edu.kh.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pizzaOrder")
public class PizzaOrderServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		// 파라미터 얻어오기
		String size = req.getParameter("size"); // R 또는 L을 얻어옴
		
		// Integer.parseInt("문자열") : 숫자 형태 String -> int 변환
		int amount = Integer.parseInt( req.getParameter("amount") );
		
		//  총합 계산
		// (10000 + 사이즈(0/2000)) * n
		int temp = 0;
		if(size.equals("L")) temp = 2000;
		int total = ( 10000 + temp ) * amount; // 최종 금액
		
		// JSP 요청 위임을 위한 객체 생성(JSP 경로 지정)
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/orderResult.jsp");		
		// req에 total값 세팅
		req.setAttribute("tot", total);
		// req, resp 객체 jsp로 위임
		dispatcher.forward(req, resp);
		
		// req - 파라미터, tot
		// resp - 응답 방법 그중에서도 응답용 스트림
		
		
		
		
		
	}
}

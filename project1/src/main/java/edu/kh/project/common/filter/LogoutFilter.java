package edu.kh.project.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// urlPatterns에 배열을 집어넣을 수 있음
@WebFilter(filterName="logoutFilter", urlPatterns= {"/member/signUp"} )
public class LogoutFilter extends HttpFilter implements Filter {
       
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("로그아웃 상태인지 검사하는 필터 초기화");
	}
	
	public void destroy() {
		System.out.println("로그아웃 상태인지 검사하는 필터 파괴");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		// 로그인 상태를 검사하는 방법
		// == session에 loginMember가 null이 아닌지 검사
		
		// Session 객체를 HttpServletRequest에서만 얻어올 수 있는데, filter에는 부모 객체인 ServletRequest만 있음
		// -> 다운캐스팅이 필요함
		
		// 부모 타입 객체인 request를 (HttpServletRequest)형식으로 다운캐스팅
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		
		// 로그인 상태인 경우
		if(session.getAttribute("loginMember") != null) {
			session.setAttribute("message", "로그인 상태로는 이용할 수 없습니다.");
			resp.sendRedirect("/");
			// 메인 페이지로
		} else { // 로그아웃 상태
			chain.doFilter(request, response);
		}
		
	}


}

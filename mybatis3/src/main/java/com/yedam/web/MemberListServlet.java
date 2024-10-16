package com.yedam.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.dao.MemberMapper;
import com.yedam.vo.Member;

//IOC (제어의 역전)
//객체생성 -> init() -> service() -> destroy() : 서블릿의 생명주기
@WebServlet("/MemberListServlet")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();

		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		MemberMapper dao = sqlSession.getMapper(MemberMapper.class);

		List<Member> result = dao.members();
		for (Member member : result) {
			response.getWriter().print(member.toString());
			response.getWriter().print("<br>");
		}

		out.print("<table border='1'>");
		out.print("<tr><th>아이디</th><th>비밀번호</th><th>휴대폰</th><th>권한</th><th>등록일</th></tr>");
		for (Member member2 : result) {

			out.print("<tr><th><a href='member.action?mid=" + member2.getMemberId() + "'>" + member2.getMemberId()
					+ "</a></th><th>" + member2.getPassword() + "</th><th>" + member2.getPhone() + "</th><th>"
					+ member2.getResponsibility() + "</th><th>" + member2.getCreationDate() + "</th></tr>");
		}
		out.print("</table>");

		out.print("<a href='./'>첫 페이지</a>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}

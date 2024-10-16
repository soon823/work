package com.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.commom.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class MemberListControl implements Control {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		
		System.out.println("MemberListControl");
		
		MemberService svc = new MemberServiceImpl();
		List<MemberVO> list = svc.memberList();
		
		req.setAttribute("memberList", list);
		
		
		try {
			//memberList.do 로 요청된 페이지에서 memberList.jsp 요청재지정
			req.getRequestDispatcher("WEB-INF/jsp/memberList.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

package com.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.dao.MemberMapper;
import com.yedam.vo.Member;

public class Apptest {
	
	public static void main(String[] args) {
		//MemberDao dao = new MemberDao();
		SqlSession sqlSession = DataSource.getInstance().openSession();
		MemberMapper dao = sqlSession.getMapper(MemberMapper.class);
		
		//등록 
//		Member mbr = new Member();
//		mbr.setMemberId("test");
//		mbr.setMemberName("연습");
//		mbr.setPhone("010-123-1234");
//		mbr.setPassword("0000");
//		
//		if(dao.insertMember(mbr) == 1) {
//			sqlSession.commit();
//		}
		
		//수정
//		Member mbr = new Member();
//		mbr.setMemberId("test");
//		mbr.setMemberName("수정중");
//		mbr.setPhone("010-1234-9876");
//		mbr.setPassword("5555");
//		
//		if(dao.updateMember(mbr) == 1) {
//			sqlSession.commit();
//		}
		
		//삭제
		Member mbr = new Member();
		mbr.setMemberId("test");
		
		if(dao.deleteMember(mbr.getMemberId()) == 1) {
			sqlSession.commit();
		}
		
		
		List<Member> result = dao.members();
		for(Member member : result) {
			System.out.println(member.toString());
		}
	}//end main
	
}//end Class

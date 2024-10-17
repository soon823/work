package com.yedam.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.commom.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class AppTest {
	public static void main(String[] args) {
		SqlSession sqlSession = DataSource.getInstance().openSession();
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		List<BoardVO> list = mapper.listWithPage(2);
		for(BoardVO bvo : list) {
			System.out.println(bvo.toString());
		}
		
	}//end main
}//end Class

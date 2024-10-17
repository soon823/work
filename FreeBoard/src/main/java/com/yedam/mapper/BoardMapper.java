package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.BoardVO;

public interface BoardMapper {
	//글 목록
	List<BoardVO> boardList();
	List<BoardVO> listWithPage(int page);
	//글 등록
	int insertBoard(BoardVO board);
	//글 수정
	int updateBoard(BoardVO board);
	//글 삭제
	int deleteBoard(int board);
	//상세조회
	BoardVO selectBoard(int board);
	//조회수 증가
	int upadteCount(int board);
}

package com.ssafy.board.test;

import com.ssafy.board.config.MyAppSqlConfig;
import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dto.Board;

public class Test {
	public static void main(String[] args) {
		BoardDao dao = MyAppSqlConfig.getSession().getMapper(BoardDao.class);
		
		
//		Board board = new Board("자기주도형학습", "이수민", "이지");
		
//		dao.insertBoard(board);
		
//		dao.deleteBoard(6);
		
		dao.updateViewCnt(9);
		
		Board b = dao.selectOne(9);
		b.setTitle("자기주도형");
		b.setContent("이지하다");
		
		dao.updateBoard(b);
		
		for(Board bb : dao.selectAll()) {
			System.out.println(bb);
		}
	
//		System.out.println(dao.selectOne(6));
	}
}

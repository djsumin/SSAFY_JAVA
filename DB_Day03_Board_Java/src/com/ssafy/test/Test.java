package com.ssafy.test;

import java.sql.SQLException;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dao.BoardDaoImpl;
import com.ssafy.board.model.dto.Board;

public class Test {
	public static void main(String[] args) {
		BoardDao dao = BoardDaoImpl.getInstance();

//		Board board = new Board("±èÀºÁö2", "±èÀºÁö2","¹«ºùÀç¹Õ´Ù.2");
//		dao.insertBoard(board);

//		dao.deleteBoard(1);

	/*	try {
			dao.updateViewCnt(6);
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		
		System.out.println(dao.selectOne(12));
		
		
//		for (Board b : dao.selectAll()) {
//			System.out.println(b);
//		}
	}
}

package com.ssafy.board.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.board.model.dto.Board;

//DB 너낌 나게 작성해라
public interface BoardDao {
	// 전체 게시글을 몽땅 들고 오쎄용
		public List<Board> selectAll();

		// ID에 해당하는 게시글 하나 가져오기
		public Board selectOne(int id);

		// 게시글 등록
		public void insertBoard(Board board);

		// 게시글 삭제
		public void deleteBoard(int id);

		// 게시글 수정
		public void updateBoard(Board board);

		// 조회수 증가
		public void updateViewCnt(int id) throws SQLException;
}

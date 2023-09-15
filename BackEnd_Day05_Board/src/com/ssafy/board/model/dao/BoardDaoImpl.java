package com.ssafy.board.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.model.dto.Board;

import sun.security.jca.GetInstance;

public class BoardDaoImpl implements BoardDao {

	private static BoardDao dao = new BoardDaoImpl();

	private List<Board> list = new ArrayList<>(); // 데이터베이스 대신

	private BoardDaoImpl() {
		list.add(new Board("오늘 너무 어렵다.", "이수민", "따라치기 포기야.."));
		list.add(new Board("오늘 좀 빠른데?", "이수민2", "자체 0.8배속으로 간다"));
		list.add(new Board("밥먹고싶다", "김태윤", "점메추."));
	}

	public static BoardDao GetInstance() {
		return dao;
	}

	@Override
	public List<Board> selectAll() {
		return list;
	}

	@Override
	public void insertBoard(Board board) {
		list.add(board);
	}

	@Override
	public Board selectOne(int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id)
				return list.get(i);
		}
		return null;
	}

	@Override
	public void updateBoard(Board board) {
		for(int i=0;i<list.size();i++) {
			Board b = list.get(i);
			if(b.getId() == board.getId()) {
				b.setTitle(board.getTitle());
				b.setContent(board.getContent());
				return;
			}
		}
	}

	@Override
	public void deleteBoard(int id) {
		for(int i=0;i<list.size();i++) {
			Board b = list.get(i);
			if(b.getId() == id) {
				list.remove(i);
				return;
			}
		}
	}

	@Override
	public void updateViewCnt(int id) {
		for(int i=0;i<list.size();i++) {
			Board b = list.get(i);
			if(b.getId() == id) {
				int viewCnt = b.getViewCnt();
				b.setViewCnt(viewCnt+1);
				break;
			}
		}
	}

}

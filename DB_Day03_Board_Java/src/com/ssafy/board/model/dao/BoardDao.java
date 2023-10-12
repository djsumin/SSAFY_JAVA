package com.ssafy.board.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.board.model.dto.Board;

public interface BoardDao {

	// ��ü �Խñ��� ���� ��� �����
	public List<Board> selectAll();

	// ID�� �ش��ϴ� �Խñ� �ϳ� ��������
	public Board selectOne(int id);

	// �Խñ� ���
	public void insertBoard(Board board);

	// �Խñ� ����
	public void deleteBoard(int id);

	// �Խñ� ����
	public void updateBoard(Board board);

	// ��ȸ�� ����
	public void updateViewCnt(int id) throws SQLException;
}

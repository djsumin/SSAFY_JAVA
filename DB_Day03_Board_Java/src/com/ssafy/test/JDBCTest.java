package com.ssafy.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.model.dto.Board;

//1. JDBC ����̹� �ε�
//2. �����ͺ��̽� ����
//3. SQL �غ� �� ����
//4. �����ͺ��̽� ���� ����

public class JDBCTest {
	public JDBCTest() {

		// Class��� �ϴ� Ŭ������ ���� ���� �޼ҵ� forName�� ����ϰ� �Ǹ� �޸𸮿� �̸� �÷���
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("����̹��ε� ����!!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		JDBCTest db = new JDBCTest();
		
		for(Board b : db.selectAll()) {
			System.out.println(b);
		}
	}

	public List<Board> selectAll() {
		List<Board> list = new ArrayList<>();

		// 2. �����ͺ��̽� ����
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafy_board?serverTimezone=UTC",
					"ssafy", "ssafy");

			// 3.SQL �غ� �� ����
			Statement stmt = conn.createStatement();
			// SQL (��ü �Խñ� ������)
			String sql = "SELECT * FROM board";

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Board board = new Board();
//				board.setId(rs.getInt("id"));
//				board.setTitle(rs.getString("title"));
//				board.setWriter(rs.getString("writer"));
//				board.setContent(rs.getString("content"));
//				board.setRegDate(rs.getString("reg_date"));
//				board.setViewCnt(rs.getInt("view_cnt"));
				// ""�ȿ��� �����ͺ��̽��� �÷���

				board.setId(rs.getInt(1));
				board.setTitle(rs.getString(3));
				board.setWriter(rs.getString(2));
				board.setContent(rs.getString(4));
				board.setRegDate(rs.getString(6));
				board.setViewCnt(rs.getInt(5));
				list.add(board);

			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}

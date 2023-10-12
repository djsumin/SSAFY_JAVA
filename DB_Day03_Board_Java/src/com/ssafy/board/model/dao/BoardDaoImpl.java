package com.ssafy.board.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.util.DBUtil;

//싱글톤으로 만들어 보자
public class BoardDaoImpl implements BoardDao {

	// DBUtil을 들고와야겠다.
	private DBUtil util = DBUtil.getInstance();

	private static BoardDaoImpl instance = new BoardDaoImpl();

	private BoardDaoImpl() {
	}

	public static BoardDaoImpl getInstance() {
		return instance;
	}// 싱글턴 끝

	@Override
	public List<Board> selectAll() {
		List<Board> list = new ArrayList<>();
		// SQL (전체 게시글 가져와)
		String sql = "SELECT * FROM board";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = util.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Board board = new Board();
				board.setId(rs.getInt("id"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getString("reg_date"));
				board.setViewCnt(rs.getInt("view_cnt"));
				// ""안에는 데이터베이스의 컬럼명

				list.add(board);

			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(rs, stmt, conn);
		}
		return list;
	}

	@Override
	public Board selectOne(int id) {
		String sql = "SELECT * FROM board WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		//없으면 바구니가 반환이 된다.. 고민해보자.. ㅎ
		Board board = new Board();

		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();

//			rs.next();

			while (rs.next()) {
				board.setId(rs.getInt(1));
				board.setTitle(rs.getString(3));
				board.setWriter(rs.getString(2));
				board.setContent(rs.getString(4));
				board.setRegDate(rs.getString(6));
				board.setViewCnt(rs.getInt(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(conn, pstmt, rs);
		}

		return board;
	}

	@Override
	public void insertBoard(Board board) {
		// 아래처럼 쓰면 너무 복잡해
//		String sql = "INSERT INTO board (title, writer, content) VALUES ('"+board.getTitle()+"')";
		String sql = "INSERT INTO board (title, writer, content) VALUES (?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = util.getConnection();
			// autocommit
			conn.setAutoCommit(false); // 오토커밋안됨

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());

			int result = pstmt.executeUpdate();

			conn.commit();
//			System.out.println(result);
		} catch (SQLException e) {
//			conn.rollback();
		} finally {
			util.close(pstmt, conn);
		}

	}

	@Override
	public void deleteBoard(int id) {
		String sql = "DELETE FROM board WHERE id=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, id);

			int result = pstmt.executeUpdate();
//			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}
	}

	@Override
	public void updateBoard(Board board) {
		String sql = "UPDATE board SET title=?, content=? WHERE id=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = util.getConnection();

			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getId());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}
	}

	@Override
	public void updateViewCnt(int id) throws SQLException {
		String sql = "UPDATE board SET view_cnt = view_cnt + 1 WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			pstmt.executeUpdate();
		} finally {
			util.close(pstmt, conn);
		}

	}

}

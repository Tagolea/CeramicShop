package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import common.JDBCUtill;
import vo.User_vo;

public class User_dao {

	Connection conn;
	PreparedStatement pstmt;

	final String insert = "insert into users values(?,?,?,?,?,?,?)";
	final String idCheck = "select * from users where uuid=?";
	final String login = "select upw from users where uuid=?";
	final String selectall = "select * from users";
	final String selectall_seller = "select * from users where uathu = 1";
	final String selectone = "select * from users where uuid=?";
	final String update = "update users set upw=?,uname=?,uph=?,uem=?,uaddr=?,uathu=? where uuid=?";
	final String delete = "delete from users where uuid=?";
	

	// 회원가입
	public int insert_user(User_vo vo) {
		int flag = -1;
		conn = JDBCUtill.connect();

		try {
			pstmt = conn.prepareStatement(insert);

			pstmt.setString(1, vo.getUuid());
			pstmt.setString(2, vo.getUpw());
			pstmt.setString(3, vo.getUname());
			pstmt.setString(4, vo.getUph());
			pstmt.setString(5, vo.getUem());
			pstmt.setString(6, vo.getUaddr());
			pstmt.setInt(7, vo.getUathu());
			pstmt.executeUpdate();
			flag = 0;// 성공

		} catch (SQLIntegrityConstraintViolationException e) {
			flag = 1;// 아이디중복
			e.printStackTrace();
		} catch (SQLException e) {
			flag = 2;// 예외
			e.printStackTrace();
		} finally {
			JDBCUtill.disconnect(pstmt, conn);
		}
		return flag;
	}

	// 로그인
	public int login_user(User_vo vo) {
		int flag = -1;
		conn = JDBCUtill.connect();

		try {
			pstmt = conn.prepareStatement(login);
			pstmt.setString(1, vo.getUuid());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String pw = rs.getString("upw");
				if (vo.getUpw().equals(pw)) {
					flag = 0;// 성공
				} else {
					flag = 2;// 비밀번호틀림
				}
			} else {
				flag = 1;// 아이디없음
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.disconnect(pstmt, conn);
		}

		return flag;

	}
	
	// 아이디 중복 체크
	public int idCheck_user(User_vo vo) {
		int flag = 1;
		conn = JDBCUtill.connect();
		try {
			pstmt = conn.prepareStatement(idCheck);
			pstmt.setString(1, vo.getUuid());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				flag = 1;
			}else {
				flag = 0;
			}
		}catch (Exception e) {
			flag = 1;
			e.printStackTrace();
		} finally {
			JDBCUtill.disconnect(pstmt, conn);
		}
		return flag;
	}
	
	//모든 유저 정보
	public ArrayList<User_vo> selectAll_user(User_vo vo){
		ArrayList<User_vo> datas = new ArrayList<User_vo>();
		conn = JDBCUtill.connect();
		
		try {
			pstmt = conn.prepareStatement(selectall);
			ResultSet rs =  pstmt.executeQuery();
			while(rs.next()) {
				User_vo rvo = new User_vo();
				rvo.setUuid(rs.getString("uuid"));
				rvo.setUpw(rs.getString("upw"));
				rvo.setUname(rs.getString("uname"));
				rvo.setUph(rs.getString("uph"));
				rvo.setUem(rs.getString("uem"));
				rvo.setUaddr(rs.getString("uaddr"));
				rvo.setUathu(rs.getInt("uathu"));
				datas.add(rvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.disconnect(pstmt, conn);
		}
		return datas;
	}
	
	//모든 유저 정보
	public ArrayList<User_vo> selectAll_user_seller(User_vo vo){
		ArrayList<User_vo> datas = new ArrayList<User_vo>();
		conn = JDBCUtill.connect();
		
		try {
			pstmt = conn.prepareStatement(selectall_seller);
			ResultSet rs =  pstmt.executeQuery();
			while(rs.next()) {
				User_vo rvo = new User_vo();
				rvo.setUuid(rs.getString("uuid"));
				rvo.setUpw(rs.getString("upw"));
				rvo.setUname(rs.getString("uname"));
				rvo.setUph(rs.getString("uph"));
				rvo.setUem(rs.getString("uem"));
				rvo.setUaddr(rs.getString("uaddr"));
				rvo.setUathu(rs.getInt("uathu"));
				datas.add(rvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.disconnect(pstmt, conn);
		}
		return datas;
	}
	
	// 회원정보조회
	public User_vo selectOne_user(User_vo vo) {
		User_vo rvo = null;
		conn = JDBCUtill.connect();

		try {
			pstmt = conn.prepareStatement(selectone);
			pstmt.setString(1, vo.getUuid());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				rvo = new User_vo();
				rvo.setUuid(rs.getString("uuid"));
				rvo.setUpw(rs.getString("upw"));
				rvo.setUname(rs.getString("uname"));
				rvo.setUph(rs.getString("uph"));
				rvo.setUem(rs.getString("uem"));
				rvo.setUaddr(rs.getString("uaddr"));
				rvo.setUathu(rs.getInt("uathu"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.disconnect(pstmt, conn);
		}
		return rvo;
	}
	
	//회원정보변경
	public boolean update_user(User_vo vo) {
		boolean flag = false;
		conn = JDBCUtill.connect();

		try {
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, vo.getUpw());
			pstmt.setString(2, vo.getUname());
			pstmt.setString(3, vo.getUph());
			pstmt.setString(4, vo.getUem());
			pstmt.setString(5, vo.getUaddr());
			pstmt.setInt(6, vo.getUathu());
			pstmt.setString(7, vo.getUuid());
			if(pstmt.executeUpdate() > 0 ) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.disconnect(pstmt, conn);
		}
		
		return flag;
	}
	
	//회원탈퇴
	public boolean delete_user(User_vo vo) {
		boolean flag = false;
		conn = JDBCUtill.connect();
		try {
			pstmt = conn.prepareStatement(delete);
			pstmt.setString(1, vo.getUuid());
			if(pstmt.executeUpdate() > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.disconnect(pstmt, conn);
		}
		return flag;
	}

}

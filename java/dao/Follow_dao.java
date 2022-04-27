package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCUtill;
import vo.Follow_vo;

public class Follow_dao {

	Connection conn;
	PreparedStatement pstmt;
	
	final String insert=
			"insert into follows values(?,?,?)";
	final String selectall = "select * from follows where follower=?";
	final String delete = "delete from follows where follower=? and followed=?";
	
	//팔로우 추가
	public boolean insert_follow(Follow_vo vo) {
		boolean flag = false;
		conn = JDBCUtill.connect();
		
		try {
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, vo.getFollower()+"_"+vo.getFollowed());
			pstmt.setString(2, vo.getFollower());
			pstmt.setString(3, vo.getFollowed());
			if(pstmt.executeUpdate()>0) {
				flag = true;
			}
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("이미 팔로우가 존재합니다.");
		} finally {
			JDBCUtill.disconnect(pstmt, conn);
		}
		return flag;
	}
	
	//나의 모든 팔로우 가져오기 //리턴값이 null일수 없음
	public ArrayList<Follow_vo> selectAll_follow(Follow_vo vo){
		ArrayList<Follow_vo> datas = new ArrayList<Follow_vo>();
		conn = JDBCUtill.connect();
		
		try {
			pstmt = conn.prepareStatement(selectall);
			pstmt.setString(1, vo.getFollower());
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Follow_vo rvo = new Follow_vo();
				rvo.setPnum(rs.getString("fnum"));
				rvo.setFollower(rs.getString("follower"));
				rvo.setFollowed(rs.getString("followed"));
				datas.add(rvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.disconnect(pstmt, conn);
		}
		return datas;
	}
	
	//팔로우 삭제
	public boolean delete_follow(Follow_vo vo) {
		boolean flag = false;
		conn = JDBCUtill.connect();
		
		try {
			pstmt = conn.prepareStatement(delete);
			pstmt.setString(1, vo.getFollower());
			pstmt.setString(2, vo.getFollowed());
			if(pstmt.executeUpdate()>0) {
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

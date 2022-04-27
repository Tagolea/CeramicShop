package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCUtill;
import vo.Review_vo;

public class Review_dao {
	
	Connection conn;
	PreparedStatement pstmt;
	
//	final String insert = "insert into reviews(rnum,rpnum,ruid,rtext) values((select NVL((select max(rnum) from reviews),0)+1 from dual),?,?,?)";
	final String insert = "insert into reviews(rnum,rpnum,ruid,rtext) values((select NVL(max(rnum),0)+1 from reviews),?,?,?)";
	final String selectall = "select * from reviews where rpnum=?";
	final String update = "update reviews set rtext=? where rnum=?";
	final String delete = "delete from reviews where rnum=?";
	
	//리뷰등록
	public boolean insert_review(Review_vo vo) {
		boolean flag = false;
		conn = JDBCUtill.connect();
		
		try {
			pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, vo.getRpnum());
			pstmt.setString(2, vo.getRuid());
			pstmt.setString(3, vo.getRtext());
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
	
	//제품에 대한 모든 리뷰
	public ArrayList<Review_vo> selectAll_review(Review_vo vo){
		ArrayList<Review_vo> datas = new ArrayList<Review_vo>();
		conn = JDBCUtill.connect();
		
		
		try {
			pstmt = conn.prepareStatement(selectall);
			pstmt.setInt(1, vo.getRpnum());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Review_vo rvo = new Review_vo();
				rvo.setRnum(rs.getInt("rnum"));
				rvo.setRpnum(rs.getInt("rpnum"));
				rvo.setRuid(rs.getString("ruid"));
				rvo.setRtext(rs.getString("rtext"));
				rvo.setRdate(rs.getString("rdate"));
				datas.add(rvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.disconnect(pstmt, conn);
		}
		
		return datas;
	}
	
	//리뷰 수정
	public boolean update_review(Review_vo vo) {
		boolean flag = false;
		conn = JDBCUtill.connect();
		
		try {
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, vo.getRtext());
			pstmt.setInt(2, vo.getRnum());
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
	
	//리뷰 삭제
	public boolean delete_review(Review_vo vo) {
		boolean flag = false;
		conn = JDBCUtill.connect();
		
		try {
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, vo.getRnum());
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

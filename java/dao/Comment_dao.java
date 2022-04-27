package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCUtill;
import vo.Comment_vo;

public class Comment_dao {
	Connection conn;
	PreparedStatement pstmt;
	
	//final String insert = "insert into comments(cnum,canum,cuid,ctext) values((select NVL((select max(cnum) from comments),0)+1 from dual),?,?,?)";
	final String insert = "insert into comments(cnum,canum,cuid,ctext) values((select NVL(max(cnum),0)+1 from comments),?,?,?)";
	final String selectall = "select * from comments where canum=?";
	final String update = "update comments set ctext=? where cnum=?";
	final String delete = "delete comments where cnum=?";
	
	//댓글등록
	public boolean insert_comments(Comment_vo vo) {
		boolean flag = false;
		conn = JDBCUtill.connect();
		
		try {
			pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, vo.getCanum());
			pstmt.setString(2, vo.getCuid());
			pstmt.setString(3, vo.getCtext());
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
	
	//게시글의 모든 댓글
	public ArrayList<Comment_vo> selectAll_comment(Comment_vo vo){
		ArrayList<Comment_vo> datas = new ArrayList<Comment_vo>();
		conn = JDBCUtill.connect();
		
			try {
				pstmt = conn.prepareStatement(selectall);
				pstmt.setInt(1, vo.getCanum());
				ResultSet rs =pstmt.executeQuery();
				while(rs.next()) {
					Comment_vo rvo = new Comment_vo();
					rvo.setCnum(rs.getInt("cnum"));
					rvo.setCanum(rs.getInt("canum"));
					rvo.setCuid(rs.getString("cuid"));
					rvo.setCtext(rs.getString("ctext"));
					rvo.setCdate(rs.getString("cdate"));
					datas.add(rvo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCUtill.disconnect(pstmt, conn);
			}
		return datas;
	}
	
	//댓글수정
	public boolean update_comment(Comment_vo vo) {
		boolean flag = false;
		conn = JDBCUtill.connect();
		
		try {
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, vo.getCtext());
			pstmt.setInt(2, vo.getCnum());
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
	
	//댓글삭제
	public boolean delete_comment(Comment_vo vo) {
		boolean flag = false;
		conn = JDBCUtill.connect();
		
		try {
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, vo.getCnum());
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

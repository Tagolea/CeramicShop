package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCUtill;
import vo.Article_vo;

public class Article_dao {
	
	Connection conn;
	PreparedStatement pstmt;
	
	final String insert = "insert into articles(anum,atitle,auid,atext,auname) values((select NVL(max(anum),0)+1 from articles),?,?,?,(select uname from users where uuid=?))";
	final String selectone = "select * from articles where anum=?";
	final String selectall	= "select * from articles order by adate desc";
	final String update = "update articles set atitle=?,auid=?,atext=? where anum=?";
	final String delete = "delete articles where anum=?";
	
	//게시글 등록
	public boolean insert_article(Article_vo vo) {
		boolean flag = false;
		conn = JDBCUtill.connect();
		try {
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, vo.getAtitle());
			pstmt.setString(2, vo.getAuid());
			pstmt.setString(3, vo.getAtext());
			pstmt.setString(4, vo.getAuid());
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
	
	//게시글 상세보기
	public Article_vo selectOne_article(Article_vo vo){
		Article_vo rvo = null;
		conn = JDBCUtill.connect();
		
		try {
			pstmt = conn.prepareStatement(selectone);
			pstmt.setInt(1, vo.getAnum());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				rvo = new Article_vo();
				rvo.setAnum(rs.getInt("anum"));
				rvo.setAtitle(rs.getString("atitle"));
				rvo.setAuid(rs.getString("auid"));
				rvo.setAtext(rs.getString("atext"));
				rvo.setAdate(rs.getString("adate"));
				rvo.setAuname(rs.getString("auname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.disconnect(pstmt, conn);
		}
		return rvo;
	}
	
	//모든 게시글 목록
	public ArrayList<Article_vo> selectAll_article(Article_vo vo){
		ArrayList<Article_vo> datas = new ArrayList<Article_vo>();
		conn = JDBCUtill.connect();
		
		try {
			pstmt = conn.prepareStatement(selectall);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Article_vo rvo = new Article_vo();
				rvo.setAnum(rs.getInt("anum"));
				rvo.setAtitle(rs.getString("atitle"));
				rvo.setAuid(rs.getString("auid"));
				rvo.setAtext(rs.getString("atext"));
				rvo.setAdate(rs.getString("adate"));
				rvo.setAuname(rs.getString("auname"));
				datas.add(rvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.disconnect(pstmt, conn);
		}
		return datas;
	}
	
	//게시글 수정
	public boolean update_article(Article_vo vo) {
		boolean flag = false;
		conn = JDBCUtill.connect();
		
		try {
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, vo.getAtitle());
			pstmt.setString(2, vo.getAuid());
			pstmt.setString(3, vo.getAtext());
			pstmt.setInt(4, vo.getAnum());
			
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
	
	//게시글 삭제
	public boolean delete_article(Article_vo vo) {
		boolean flag = false;
		conn = JDBCUtill.connect();
		
		try {
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, vo.getAnum());
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

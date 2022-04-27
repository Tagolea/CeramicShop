package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCUtill;
import vo.Product_vo;

public class Product_dao {

	Connection conn;
	PreparedStatement pstmt;

	// final String insert = "insert into products values((select NVL((select
	// max(pnum) from products),0)+1 from dual),?,?,?,?,?)";
	final String insert = "insert into products values((select NVL(max(pnum),0)+1 from products),?,?,?,?,?)";
	final String selectone1 = "select * from products where pnum=?";
	final String selectone2 = "select * from products where pname=?";
	final String selectall_seller = "select * from products where puid=?";
	final String selectall_search = "select * from products where pname like '%'|| ? ||'%'";
	final String selectall = "select * from products order by pnum desc";
	final String update = "update products set puid=?,pname=?,ptext=?,pprice=?,pstock=? where pnum=?";
	final String delete = "delete from products where pnum=?";

	// 제품등록
	public boolean insert_product(Product_vo vo) {
		boolean flag = false;
		conn = JDBCUtill.connect();

		try {
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, vo.getPuid());
			pstmt.setString(2, vo.getPname());
			pstmt.setString(3, vo.getPtext());
			pstmt.setInt(4, vo.getPprice());
			pstmt.setInt(5, vo.getPstock());
			if (pstmt.executeUpdate() > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.disconnect(pstmt, conn);
		}
		return flag;
	}

	// 제품 정보
	public Product_vo selectOne_product(Product_vo vo) {
		Product_vo rvo = null;
		conn = JDBCUtill.connect();

		if (vo.getPname() != null && !vo.getPname().equals("")) {
			try {
				pstmt = conn.prepareStatement(selectone2);
				pstmt.setString(1, vo.getPname());
				ResultSet rs =pstmt.executeQuery();
				if(rs.next()) {
					rvo = new Product_vo();
					rvo.setPnum(rs.getInt("pnum"));
					rvo.setPuid(rs.getString("puid"));
					rvo.setPname(rs.getString("pname"));
					rvo.setPtext(rs.getString("ptext"));
					rvo.setPprice(rs.getInt("pprice"));
					rvo.setPstock(rs.getInt("pstock"));
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			try {
				pstmt = conn.prepareStatement(selectone1);
				pstmt.setInt(1, vo.getPnum());
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					rvo = new Product_vo();
					rvo.setPnum(rs.getInt("pnum"));
					rvo.setPuid(rs.getString("puid"));
					rvo.setPname(rs.getString("pname"));
					rvo.setPtext(rs.getString("ptext"));
					rvo.setPprice(rs.getInt("pprice"));
					rvo.setPstock(rs.getInt("pstock"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCUtill.disconnect(pstmt, conn);
			}
		}
		return rvo;
	}

	// 해당 작가 제품 정보
	public ArrayList<Product_vo> selectAll_product_seller(Product_vo vo) {
		ArrayList<Product_vo> datas = new ArrayList<Product_vo>();
		conn = JDBCUtill.connect();

		try {
			pstmt = conn.prepareStatement(selectall_seller);
			pstmt.setString(1, vo.getPuid());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Product_vo rvo = new Product_vo();
				rvo.setPnum(rs.getInt("pnum"));
				rvo.setPuid(rs.getString("puid"));
				rvo.setPname(rs.getString("pname"));
				rvo.setPtext(rs.getString("ptext"));
				rvo.setPprice(rs.getInt("pprice"));
				rvo.setPstock(rs.getInt("pstock"));
				datas.add(rvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.disconnect(pstmt, conn);
		}
		return datas;
	}
	
	//제목으로 검색
	public ArrayList<Product_vo> selectAll_product_search(Product_vo vo){
		ArrayList<Product_vo> datas = new ArrayList<Product_vo>();
		conn = JDBCUtill.connect();
		
			try {
				pstmt = conn.prepareStatement(selectall_search);
				pstmt.setString(1, vo.getPname());
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					Product_vo rvo = new Product_vo();
					rvo.setPnum(rs.getInt("pnum"));
					rvo.setPuid(rs.getString("puid"));
					rvo.setPname(rs.getString("pname"));
					rvo.setPtext(rs.getString("ptext"));
					rvo.setPprice(rs.getInt("pprice"));
					rvo.setPstock(rs.getInt("pstock"));
					datas.add(rvo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return datas;
	}

	// 모든 제품 정보
	public ArrayList<Product_vo> selectAll_product(Product_vo vo) {
		ArrayList<Product_vo> datas = new ArrayList<Product_vo>();
		conn = JDBCUtill.connect();

		try {
			pstmt = conn.prepareStatement(selectall);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Product_vo rvo = new Product_vo();
				rvo.setPnum(rs.getInt("pnum"));
				rvo.setPuid(rs.getString("puid"));
				rvo.setPname(rs.getString("pname"));
				rvo.setPtext(rs.getString("ptext"));
				rvo.setPprice(rs.getInt("pprice"));
				rvo.setPstock(rs.getInt("pstock"));
				datas.add(rvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.disconnect(pstmt, conn);
		}

		return datas;
	}

	// 제품 정보 변경
	public boolean update_product(Product_vo vo) {
		boolean flag = false;
		conn = JDBCUtill.connect();

		try {
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, vo.getPuid());
			pstmt.setString(2, vo.getPname());
			pstmt.setString(3, vo.getPtext());
			pstmt.setInt(4, vo.getPprice());
			pstmt.setInt(5, vo.getPstock());
			pstmt.setInt(6, vo.getPnum());
			if (pstmt.executeUpdate() > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.disconnect(pstmt, conn);
		}

		return flag;
	}

	// 제품 삭제
	public boolean delete_product(Product_vo vo) {
		boolean flag = false;
		conn = JDBCUtill.connect();

		try {
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, vo.getPnum());
			if (pstmt.executeUpdate() > 0) {
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

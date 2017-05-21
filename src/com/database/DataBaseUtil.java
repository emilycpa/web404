package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.database.po.Product;
import com.database.po.ProductOrder;

public class DataBaseUtil {

	public static Connection getConn() throws Exception {
		Context ctx = new InitialContext();
		Context envContext = (Context) ctx.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/mysqlds");
		return ds.getConnection();
	}

	public static void addAccessRecord(String mobileNum, String userAgent, int type) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DataBaseUtil.getConn();
			pstmt = conn.prepareStatement("insert into access_count(mobile_num,user_agent,type) values(?,?,?)");
			pstmt.setString(1, mobileNum);
			pstmt.setString(2, userAgent);
			pstmt.setInt(3, type);
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void addAd(String mobile, int ad) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DataBaseUtil.getConn();
			pstmt = conn.prepareStatement("insert into aopp(mobile,ad) values(?,?)");
			pstmt.setString(1, mobile);
			
			pstmt.setInt(2, ad);
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void addrecord(String mobile, String url) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DataBaseUtil.getConn();
			pstmt = conn.prepareStatement("insert into record(mobile,url) values(?,?)");
			pstmt.setString(1, mobile);
			pstmt.setString(2, url);
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static int getConut(String mobile)
	{
		int con=0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DataBaseUtil.getConn();
			pstmt = conn.prepareStatement("select count(*) from aopp where mobile=? and TO_DAYS(NOW())=TO_DAYS(dtime) ");
			pstmt.setString(1, mobile);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				con=rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
		
	}
	public static int getConutHours(String mobile,int ad)
	{
		int con=0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DataBaseUtil.getConn();
			pstmt = conn.prepareStatement("select count(*) from aopp where timestampdiff(MINUTE,DATE_FORMAT(dtime,'%Y-%m-%d %H:%i:%s'),DATE_FORMAT(NOW(),'%Y-%m-%d %H:%i:%s'))>=5  and TO_DAYS(NOW())=TO_DAYS(dtime) and mobile=? and ad=?");
			//x.out.println("mobile is="+mobile+" ad is"+ad);
			pstmt.setString(1, mobile);
			pstmt.setInt(2, ad);
			rs = pstmt.executeQuery(); 
			while (rs.next()) {
				con=rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
		
	}
	public synchronized static int getConutHours2(String mobile,int ad)
	{
		int con=0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DataBaseUtil.getConn();
			pstmt = conn.prepareStatement("select count(*) from aopp where timestampdiff(MINUTE,DATE_FORMAT(dtime,'%Y-%m-%d %H:%i:%s'),DATE_FORMAT(NOW(),'%Y-%m-%d %H:%i:%s'))>=2  and TO_DAYS(NOW())=TO_DAYS(dtime) and mobile=? and ad=?");
			//x.out.println("mobile is="+mobile+" ad is"+ad);
			pstmt.setString(1, mobile);
			pstmt.setInt(2, ad);
			rs = pstmt.executeQuery(); 
			while (rs.next()) {
				con=rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
		
	}
	public static int getConutHours1(String mobile,int ad)
	{
		int con=0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DataBaseUtil.getConn();
			pstmt = conn.prepareStatement("select count(*) from aopp where timestampdiff(MINUTE,DATE_FORMAT(dtime,'%Y-%m-%d %H:%i:%s'),DATE_FORMAT(NOW(),'%Y-%m-%d %H:%i:%s'))>=1  and TO_DAYS(NOW())=TO_DAYS(dtime) and mobile=? and ad=?");
		
			pstmt.setString(1, mobile);
			pstmt.setInt(2, ad);
			rs = pstmt.executeQuery(); 
			while (rs.next()) {
				con=rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
		
	}
	public static Vector<Integer> getList(String mobile)
	{
		Vector<Integer> v1=new Vector<Integer>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DataBaseUtil.getConn();
			pstmt = conn.prepareStatement("select ad from aopp where mobile=? and TO_DAYS(NOW())=TO_DAYS(dtime) ");
			pstmt.setString(1, mobile);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				v1.addElement(new Integer(rs.getInt(1)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return v1;
		
	}
	public static int getDomainConut(String url)
	{
		int con=0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DataBaseUtil.getConn();
			pstmt = conn.prepareStatement("select type from domain where domain=? ");
			pstmt.setString(1, url);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				con=rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
				pstmt.close();
				rs.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
		
	}
     
	public static void addProduct(String name, String code, String type, String url, String desc, String bss,
			String ecs, String imgUrl) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DataBaseUtil.getConn();
			pstmt = conn.prepareStatement(
					"insert into product(name,code,url,type,description,bss_code,ecs_code,img_url) values(?,?,?,?,?,?,?,?)");
			pstmt.setString(1, name);
			pstmt.setString(2, code);
			pstmt.setString(3, url);
			pstmt.setString(4, type);
			pstmt.setString(5, desc);
			pstmt.setString(6, bss);
			pstmt.setString(7, ecs);
			pstmt.setString(8, imgUrl);
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static List<Map<String, Object>> queryProduct() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		try {
			conn = DataBaseUtil.getConn();
			pstmt = conn.prepareStatement("select * from product");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", rs.getInt("id"));
				row.put("name", rs.getString("name"));
				row.put("code", rs.getString("code"));
				row.put("bss", rs.getString("bss_code"));
				row.put("ecs", rs.getString("ecs_code"));
				row.put("url", rs.getString("url"));
				row.put("type", rs.getString("type"));
				row.put("imgUrl", rs.getString("img_url"));
				row.put("desc", rs.getString("description"));
				data.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}

	public static Product queryProduct(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataBaseUtil.getConn();
			pstmt = conn.prepareStatement("select * from product where id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setCode(rs.getString("code"));
				p.setBssCode(rs.getString("bss_code"));
				p.setEcsCode(rs.getString("ecs_code"));
				p.setUrl(rs.getString("url"));
				p.setType(rs.getString("type"));
				p.setImgUrl(rs.getString("img_url"));
				p.setDescription(rs.getString("description"));
				return p;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static Product queryProduct(String code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataBaseUtil.getConn();
			pstmt = conn.prepareStatement("select * from product where code=?");
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setCode(rs.getString("code"));
				p.setBssCode(rs.getString("bss_code"));
				p.setEcsCode(rs.getString("ecs_code"));
				p.setUrl(rs.getString("url"));
				p.setType(rs.getString("type"));
				p.setImgUrl(rs.getString("img_url"));
				p.setDescription(rs.getString("description"));
				return p;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static void edit(int id, String name, String code, String type, String url, String desc, String bss,
			String ecs, String imgUrl) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DataBaseUtil.getConn();
			pstmt = conn.prepareStatement(
					"update product set name=?,code=?,type=?,url=?,description=?,bss_code=?,ecs_code=?,img_url=? where id=?");
			pstmt.setString(1, name);
			pstmt.setString(2, code);
			pstmt.setString(4, url);
			pstmt.setString(3, type);
			pstmt.setString(5, desc);
			pstmt.setString(6, bss);
			pstmt.setString(7, ecs);
			pstmt.setString(8, imgUrl);
			pstmt.setInt(9, id);
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void delete(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DataBaseUtil.getConn();
			pstmt = conn.prepareStatement("delete from  product where id=?");
			pstmt.setInt(1, id);
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void addProductOrderRecord(ProductOrder order) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DataBaseUtil.getConn();
			pstmt = conn.prepareStatement("insert into product_order(code,mobile_num) values(?,?)");
			pstmt.setString(1, order.getCode());
			pstmt.setString(2, order.getMobileNum());
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
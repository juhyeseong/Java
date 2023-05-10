package productsale;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import oracle.jdbc.driver.OracleDriver;

public class ProductSalesDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private String url = "jdbc:oracle:thin:@192.168.1.100:1521:xe";
	private String user = "c##itbank";
	private String password = "it";
	
	private String className = OracleDriver.class.getName();
	
	public ProductSalesDAO() {
		try {
			Class.forName(className);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("잘못된 클래스 이름 예외");
			
		}
	}
	
	public ArrayList<HashMap<String, Object>> allResult() {
		ArrayList<HashMap<String, Object>> list = new ArrayList<>();
		String sql = "select P.product_name as 상품명, sum(S.sales_total) as 총판매금액 " + 
				"from sales S " + 
				"left outer join product P " + 
				"on P.product_idx = S.product_idx " + 
				"group by P.product_name";
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				HashMap<String, Object> map = new HashMap<>();
				map.put("상품명", rs.getString("상품명"));
				map.put("총판매금액", rs.getInt("총판매금액"));
				
				list.add(map);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try { if(rs != null) 	rs.close();		}	catch(Exception e) {}
			try { if(pstmt != null) 	pstmt.close();		}	catch(Exception e) {}
			try { if(conn != null) 	conn.close();		}	catch(Exception e) {}
		}
		
		return list;
	}
	
	public ArrayList<HashMap<String, Object>> registeredResult() {
		ArrayList<HashMap<String, Object>> list = new ArrayList<>();
		String sql = "select P.product_name as 상품명, sum(S.sales_total) as 총판매금액 " + 
				"from sales S " + 
				"join product P " + 
				"on P.product_idx = S.product_idx " + 
				"group by P.product_name";
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				HashMap<String, Object> map = new HashMap<>();
				map.put("상품명", rs.getString("상품명"));
				map.put("총판매금액", rs.getInt("총판매금액"));
				
				list.add(map);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try { if(rs != null) 	rs.close();		}	catch(Exception e) {}
			try { if(pstmt != null) 	pstmt.close();		}	catch(Exception e) {}
			try { if(conn != null) 	conn.close();		}	catch(Exception e) {}
		}
		
		return list;
	}
	
	public ArrayList<HashMap<String, Object>> unRegisteredResult() {
		ArrayList<HashMap<String, Object>> list = new ArrayList<>();
		String sql = "select P.product_name as 상품명, sum(S.sales_total) as 총판매금액 " + 
				"from sales S " + 
				"left outer join product P " + 
				"on P.product_idx = S.product_idx " + 
				"where P.product_name is null " + 
				"group by P.product_name";

		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				HashMap<String, Object> map = new HashMap<>();
				map.put("상품명", rs.getString("상품명"));
				map.put("총판매금액", rs.getInt("총판매금액"));
				
				list.add(map);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try { if(rs != null) 	rs.close();		}	catch(Exception e) {}
			try { if(pstmt != null) 	pstmt.close();		}	catch(Exception e) {}
			try { if(conn != null) 	conn.close();		}	catch(Exception e) {}
		}
		
		return list;
	}
}

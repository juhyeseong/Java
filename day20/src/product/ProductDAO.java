package product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.driver.OracleDriver;

public class ProductDAO {	// Database Access Object
	
	private Connection conn;
	private PreparedStatement pstmt;	// Statement의 subclass
	private ResultSet rs;
	
	private String url = "jdbc:oracle:thin:@192.168.1.100:1521:xe";
	private String user = "c##itbank";
	private String password = "it";
	
	private String className = OracleDriver.class.getName();
	
	public ProductDAO() {
		try {
			Class.forName(className);	
		} catch(ClassNotFoundException e) {
			System.err.println("DAO 생성자 예외 발생 : " + e);
		}
	}
	
	public ArrayList<ProductDTO> selectAll(String order, boolean desc) {
		ArrayList<ProductDTO> list = new ArrayList<ProductDTO>(); // 반환할 객체 생성
		String sql = "select * from product order by " + order;
		if(desc) {
			sql += " desc";
		}
		System.out.println("SQL > " + sql);
		// 코드 흐름 : conn -> pstmt -> rs -> while -> list.add(ob) -> close -> return
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);	// sql을 미리 넣어둔다
			rs = pstmt.executeQuery();	// 미리 넣었으니 여기서는 sql을 지정하지 않는다
			
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setIdx(rs.getInt("idx"));
				dto.setName(rs.getString("name"));
				dto.setPrice(rs.getInt("price"));
				dto.setExpiryDate(rs.getDate("expiryDate"));
				dto.setMemo(rs.getString("memo"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try { if(rs != null) 	rs.close();		}	catch(Exception e) {}
			try { if(pstmt != null) 	pstmt.close();		}	catch(Exception e) {}
			try { if(conn != null) 	conn.close();		}	catch(Exception e) {}
		}
		
		return list;	//  객체 반환
	}
	
	public ArrayList<ProductDTO> select(String keyword) {
		ArrayList<ProductDTO> list = new ArrayList<ProductDTO>(); // 반환할 객체 생성
//		String sql = "select * from product where name like '%" + keyword + "%'";
		String sql = "select * from product where name like '%%%s%%'";
		sql = String.format(sql, keyword);	// printf에서 %를 출력하고 싶으면 %%를 사용한다
		// 코드 흐름 : conn -> pstmt -> rs -> while -> list.add(ob) -> close -> return
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);	// sql을 미리 넣어둔다
			rs = pstmt.executeQuery();	// 미리 넣었으니 여기서는 sql을 지정하지 않는다
			
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setIdx(rs.getInt("idx"));
				dto.setName(rs.getString("name"));
				dto.setPrice(rs.getInt("price"));
				dto.setExpiryDate(rs.getDate("expiryDate"));
				dto.setMemo(rs.getString("memo"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try { if(rs != null) 	rs.close();		}	catch(Exception e) {}
			try { if(pstmt != null) 	pstmt.close();		}	catch(Exception e) {}
			try { if(conn != null) 	conn.close();		}	catch(Exception e) {}
		}
		
		return list;	//  객체 반환
	}

	public int insert(ProductDTO dto) {	// main함수에서의 tmp
		int row = 0;
		String sql = "insert into product values (?, ?, ?, ?, ?)";
		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  dto.getIdx());		// 1번째 물음표에 idx를 설정한다. 숫자이므로 따옴표가 없다
			pstmt.setString(2, dto.getName());	// 2번째 물음표에 name을 설정한다. 문자열이므로 따옴표를 (자동으로) 작성해준다
			pstmt.setInt(3, dto.getPrice());
			pstmt.setDate(4, dto.getExpiryDate());	// 날짜도 형식에 맞게 알아서 작성해준다
			pstmt.setString(5, dto.getMemo());
											// 중요 !!!!!
			row = pstmt.executeUpdate();	// executeQuery()는 ResultSet을 반환한다 (select)
											// executeQuery()는 int를 반환한다 (insert, update, delete)
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { if(rs != null) 	rs.close();		}	catch(Exception e) {}
			try { if(pstmt != null) 	pstmt.close();		}	catch(Exception e) {}
			try { if(conn != null) 	conn.close();		}	catch(Exception e) {}
		}
		return row;
	}
	
	public int update(ProductDTO dto) {	// main함수에서의 tmp
		int row = 0;
		String sql = "update product set name=?, price=?, expiryDate=?, memo=? where idx=?";
		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			
			// pstmt.set???(1, dto.get???)
			// sql에서 ? 순서에 맞게 넣어줘야한다. idx는 5번째에 있다
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getPrice());
			pstmt.setDate(3, dto.getExpiryDate());
			pstmt.setString(4, dto.getMemo());
			pstmt.setInt(5, dto.getIdx());
			
			row = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { if(rs != null) 	rs.close();		}	catch(Exception e) {}
			try { if(pstmt != null) 	pstmt.close();		}	catch(Exception e) {}
			try { if(conn != null) 	conn.close();		}	catch(Exception e) {}
		}
		
		return row;
	}

	public int delete(int idx) {
		int row = 0;
		String sql = "delete product where idx = ?";
		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
//			conn.setAutoCommit(false); 해당 연결의 자동 커밋을 수행하지 않게 한다
//									   jdbc의 오토 커밋 기본값은 true이다
			
			row = pstmt.executeUpdate();
//			conn.commit();			   conn에서 커밋을 수행하거나 롤백을 수행할 수도 있다
//			conn.rollback();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { if(rs != null) 	rs.close();		}	catch(Exception e) {}
			try { if(pstmt != null) 	pstmt.close();		}	catch(Exception e) {}
			try { if(conn != null) 	conn.close();		}	catch(Exception e) {}
		}
		
		return row;
	}

}

package messenger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class MessengerDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String url = "jdbc:oracle:thin:@192.168.1.100:1521:xe";
	private String user = "c##itbank";
	private String password = "it";
	
	private String className = OracleDriver.class.getName();

	public MessengerDAO() {
		try {
			Class.forName(className);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		}
	}
	
	public MessengerDTO login(String userId, String userPw) {
		MessengerDTO dto = null;
		String sql = "select * from member where userId='%s' and userPw='%s'";
		sql = String.format(sql, userId, userPw);
		System.out.println("sqp> " + sql);
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto = new MessengerDTO();
				
				dto.setIdx(rs.getInt("idx"));
				dto.setNick(rs.getString("nick"));
				dto.setUserId(rs.getString("userId"));
				dto.setUserPw(rs.getString("userPw"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try { if(rs != null) 	rs.close();		}	catch(Exception e) {}
			try { if(pstmt != null) pstmt.close();		}	catch(Exception e) {}
			try { if(conn != null) 	conn.close();		}	catch(Exception e) {}
		}
		
		return dto;
	}
	
	public int isPw(String userPw, String userId) {
		int row = 0;
		String sql = "select * from member where userId='%s' and userPw='%s'";
		sql = String.format(sql, userId, userPw);
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				row = 1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try { if(rs != null) 	rs.close();		}	catch(Exception e) {}
			try { if(pstmt != null) pstmt.close();		}	catch(Exception e) {}
			try { if(conn != null) 	conn.close();		}	catch(Exception e) {}
		}
		
		return row;
	}

	public int changePw(String userPw, String userId) {
		int row = 0;
		String sql = "update member set " + 
				"userPw=? " + 
				"where userId=?";
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userPw);
			pstmt.setString(2, userId);
			
			row = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try { if(rs != null) 	rs.close();		}	catch(Exception e) {}
			try { if(pstmt != null) pstmt.close();		}	catch(Exception e) {}
			try { if(conn != null) 	conn.close();		}	catch(Exception e) {}
		}
		
		return row;
	}

	public int chageNick(String nick, String userId) {
		int row = 0;
		String sql = "update member set " + 
				"nick=? " + 
				"where userId=?";
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nick);
			pstmt.setString(2, userId);
			
			row = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try { if(rs != null) 	rs.close();		}	catch(Exception e) {}
			try { if(pstmt != null) pstmt.close();		}	catch(Exception e) {}
			try { if(conn != null) 	conn.close();		}	catch(Exception e) {}
		}
		
		return row;
	}

	public int insert(MessengerDTO tmp) {
		int row = 0;
		
		String sql = "insert into member (userId, userPw, nick) values(?, ?, ?)";
		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  tmp.getUserId());		
			pstmt.setString(2, tmp.getUserPw());	
			pstmt.setString(3, tmp.getNick());

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


}

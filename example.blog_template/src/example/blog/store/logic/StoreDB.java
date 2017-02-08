package example.blog.store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import example.blog.constants.Constants;
import example.blog.store.util.ConnectionFactory;
import example.blog.store.util.JdbcUtils;

public class StoreDB {
	
	private ConnectionFactory factory;
	
	public StoreDB() {
		factory = ConnectionFactory.getInstance();
		factory.setUrl(Constants.DB_URL);
	}
	
	protected int updateDB(String sql, String...strings) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement(sql);
			for(int i = 0 ; i < strings.length ; i++) {
				pstmt.setString(i + 1, strings[i]);
			}
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt);
		}
		
		return Constants.UPDATE_FAIL;
	}
	
	protected List<List<String>> selectDB(String sql, String...strings) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		
		List<List<String>> fullList = new ArrayList<>();
		List<String> strList = null;
		
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement(sql);
			for(int i = 0 ; i < strings.length ; i++) {
				pstmt.setString(i + 1, strings[i]);
			}
			
			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();
			
			while(rs.next()) {
				strList = new ArrayList<>();
				for(int i = 0 ; i < rsmd.getColumnCount() ; i++) {
					strList.add(rs.getString(i + 1));
				}
				fullList.add(strList);
			}
			
			return fullList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt);
		}
		
		return Constants.SELECT_FAIL;
	}
}

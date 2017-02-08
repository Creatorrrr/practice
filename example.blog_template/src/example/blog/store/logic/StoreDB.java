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
	
	protected int updateDB(String sql, Object...objects) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement(sql);
			
			for(int i = 0 ; i < objects.length ; i++) {
				// check instance (add if you need more type)
				if(objects[i] instanceof Integer) {
					pstmt.setInt(i + 1, (Integer)objects[i]);
				} else if(objects[i] instanceof Long) {
					pstmt.setLong(i + 1, (Long)objects[i]);
				} else if(objects[i] instanceof Float) {
					pstmt.setFloat(i + 1, (Float)objects[i]);
				} else if(objects[i] instanceof Double) {
					pstmt.setDouble(i + 1, (Double)objects[i]);
				} else {
					pstmt.setString(i + 1, (String)objects[i]);
				}
			}
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt);
		}
		
		return Constants.UPDATE_FAIL;
	}
	
	protected List<List<String>> selectDB(String sql, Object...objects) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		
		List<List<String>> fullList = new ArrayList<>();
		List<String> strList = null;
		
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement(sql);
			
			for(int i = 0 ; i < objects.length ; i++) {
				// check instance (add if you need more type)
				if(objects[i] instanceof Integer) {
					pstmt.setInt(i + 1, (Integer)objects[i]);
				} else if(objects[i] instanceof Long) {
					pstmt.setLong(i + 1, (Long)objects[i]);
				} else if(objects[i] instanceof Float) {
					pstmt.setFloat(i + 1, (Float)objects[i]);
				} else if(objects[i] instanceof Double) {
					pstmt.setDouble(i + 1, (Double)objects[i]);
				} else {
					pstmt.setString(i + 1, (String)objects[i]);
				}
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
			JdbcUtils.closeResource(conn, pstmt, rs);
		}
		
		return Constants.SELECT_FAIL;
	}

}

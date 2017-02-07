package store.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Product;
import store.ProductStore;
import store.util.ConnectionFactory;
import store.util.JdbcUtils;

public class ProductStoreLogic implements ProductStore {
	
	private ConnectionFactory factory;
	
	public ProductStoreLogic() {
		factory = ConnectionFactory.getInstance();
	}

	@Override
	public List<Product> selectAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Product> list = new ArrayList<>();
		
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement(
					"SELECT productid, productname, category, information FROM product_tb");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getString("productid"));
				product.setProductName(rs.getString("productname"));
				product.setCategory(rs.getString("category"));
				product.setInformation(rs.getString("information"));
				
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt, rs);
		}
		
		return list;
	}

	@Override
	public List<String> selectCountByCategory() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<String> list = new ArrayList<>();
		
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement(
					"SELECT category, COUNT(*) AS cnt FROM product_tb GROUP BY category");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getString("category") + " : " + rs.getString("cnt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt, rs);
		}
		
		return list;
	}

}

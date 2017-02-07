package store.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Order;
import store.OrderStore;
import store.util.ConnectionFactory;

public class OrderStoreLogic implements OrderStore {
	
	private ConnectionFactory factory;
	
	public OrderStoreLogic() {
		factory = ConnectionFactory.getInstance();
	}

	@Override
	public List<Order> selectAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Order> list = new ArrayList<>();;
		
		try {
			conn = factory.createConnection();
			
			pstmt = conn.prepareStatement("SELECT id, productid, orderdate, quantity FROM order_tb");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Order order = new Order();
				order.setId(rs.getString("id"));
				order.setProductId(rs.getString("productid"));
				order.setOrderDate(rs.getDate("orderdate"));
				order.setQuantity(rs.getInt("quantity"));
				
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	@Override
	public List<Order> selectById(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Order> list = new ArrayList<>();;
		
		try {
			conn = factory.createConnection();
			
			pstmt = conn.prepareStatement("SELECT id, productid, orderdate, quantity FROM order_tb WHERE id = ?");
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Order order = new Order();
				order.setId(rs.getString("id"));
				order.setProductId(rs.getString("productid"));
				order.setOrderDate(rs.getDate("orderdate"));
				order.setQuantity(rs.getInt("quantity"));
				
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Order> selectOrderByDate(String year) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Order> list = new ArrayList<>();;
		
		try {
			conn = factory.createConnection();
			
			pstmt = conn.prepareStatement(
					"SELECT id, productid, orderdate, quantity FROM order_tb WHERE EXTRACT(YEAR FROM orderdate) = ? ");
			pstmt.setString(1, year);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Order order = new Order();
				order.setId(rs.getString("id"));
				order.setProductId(rs.getString("productid"));
				order.setOrderDate(rs.getDate("orderdate"));
				order.setQuantity(rs.getInt("quantity"));
				
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	@Override
	public List<Order> selectOrderByDate(String startYear, String endYear) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Order> list = new ArrayList<>();;
		
		try {
			conn = factory.createConnection();
			
			pstmt = conn.prepareStatement(
					"SELECT id, productid, orderdate, quantity "
					+ "FROM order_tb "
					+ "WHERE EXTRACT(YEAR FROM orderdate) BETWEEN ? AND ?");
			pstmt.setString(1, startYear);
			pstmt.setString(2, endYear);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Order order = new Order();
				order.setId(rs.getString("id"));
				order.setProductId(rs.getString("productid"));
				order.setOrderDate(rs.getDate("orderdate"));
				order.setQuantity(rs.getInt("quantity"));
				
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}

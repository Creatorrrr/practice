package store.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Customer;
import store.CustomerStore;
import store.util.ConnectionFactory;
import store.util.JdbcUtils;

public class CustomerStoreLogic implements CustomerStore {
	
	private ConnectionFactory factory;
	
	public CustomerStoreLogic() {
		factory = ConnectionFactory.getInstance();
	}

	@Override
	public boolean selectId(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		boolean selectFlag = false;
		
		try {
			conn = factory.createConnection();
			
			pstmt = conn.prepareStatement("SELECT id FROM customer_tb WHERE id = ?");
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				selectFlag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt, rs);
		}
		
		return selectFlag;
	}
	
	@Override
	public boolean insert(Customer customer) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		boolean insertFlag = false;
		
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("insert into customer_tb values(?,?,?,?,?)");
			pstmt.setString(1, customer.getId());
			pstmt.setString(2, customer.getPasswd());
			pstmt.setString(3, customer.getName());
			pstmt.setInt(4, customer.getAge());
			pstmt.setString(5, customer.getAddress());
			
			if(pstmt.executeUpdate() > 0) {
				insertFlag = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt);
		}
		
		return insertFlag;
	}

	@Override
	public List<Customer> selectAllByName() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<Customer> list = new ArrayList<>();
		
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement(
					"SELECT id, passwd, name, age, address FROM customer_tb ORDER BY name ASC");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getString("id"));
				customer.setPasswd(rs.getString("passwd"));
				customer.setName(rs.getString("name"));
				customer.setAge(rs.getInt("age"));
				customer.setAddress(rs.getString("address"));
				
				list.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt, rs);
		}
		
		return list;
	}

	@Override
	public List<Customer> selectAllByAge() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<Customer> list = new ArrayList<>();
		
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement(
					"SELECT id, passwd, name, age, address FROM customer_tb ORDER BY age DESC");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getString("id"));
				customer.setPasswd(rs.getString("passwd"));
				customer.setName(rs.getString("name"));
				customer.setAge(rs.getInt("age"));
				customer.setAddress(rs.getString("address"));
				
				list.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt, rs);
		}
		
		return list;
	}

	@Override
	public List<Customer> selectByName(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Customer> list = new ArrayList<>();
		
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement(
					"SELECT id, passwd, name, age, address FROM customer_tb WHERE name = ?");
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getString("id"));
				customer.setPasswd(rs.getString("passwd"));
				customer.setName(rs.getString("name"));
				customer.setAge(rs.getInt("age"));
				customer.setAddress(rs.getString("address"));
				
				list.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt, rs);
		}
		
		return list;
	}

	@Override
	public List<Customer> selectByAddress(String address) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<Customer> list = new ArrayList<>();
		
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement(
					"SELECT id, passwd, name, age, address FROM customer_tb WHERE address = ?");
			pstmt.setString(1, address);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getString("id"));
				customer.setPasswd(rs.getString("passwd"));
				customer.setName(rs.getString("name"));
				customer.setAge(rs.getInt("age"));
				customer.setAddress(rs.getString("address"));
				
				list.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt, rs);
		}
		
		return list;
	}

	@Override
	public Customer selectById(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Customer customer = new Customer();
		
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement(
					"SELECT id, passwd, name, age, address FROM customer_tb WHERE id = ?");
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				customer.setId(rs.getString("id"));
				customer.setPasswd(rs.getString("passwd"));
				customer.setName(rs.getString("name"));
				customer.setAge(rs.getInt("age"));
				customer.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt, rs);
		}
		
		return customer;
	}

	@Override
	public boolean delete(Customer customer) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		boolean deleteFlag = false;
		
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("DELETE FROM customer_tb WHERE id = ?");
			pstmt.setString(1, customer.getId());
			
			if(pstmt.executeUpdate() > 0) {
				deleteFlag = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt);
		}
		
		return deleteFlag;
	}

	@Override
	public boolean update(Customer customer) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		boolean deleteFlag = false;
		
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement(
					"UPDATE customer_tb SET address = ? WHERE id = ?");
			pstmt.setString(1, customer.getAddress());
			pstmt.setString(2, customer.getId());
									
			if(pstmt.executeUpdate() > 0) {
				deleteFlag = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt);
		}
		
		return deleteFlag;
	}
	
	

}

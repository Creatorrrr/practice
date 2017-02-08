package example.blog.store.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static ConnectionFactory instance;
	
	private String url;
	private String port;
	private String id;
	private String pw;

	private ConnectionFactory(){
		url = "localhost";
		port = "1521";
		id = "scott";
		pw = "tiger";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("드라이버 로딩 오류");
		}
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public static ConnectionFactory getInstance(){
		if(instance == null){
			instance = new ConnectionFactory();
		}
		
		return instance;
	}
	
	public Connection createConnection() throws SQLException{
		return DriverManager.getConnection(
				"jdbc:oracle:thin:@" + url + ":" + port + ":XE", id, pw);
	}
}








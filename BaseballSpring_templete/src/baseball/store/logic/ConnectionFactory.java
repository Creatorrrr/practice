package baseball.store.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <PRE>
 * 컨넥션 팩토리
 * 싱글턴
 * </PRE>
 * @author jiwonpark
 */
public class ConnectionFactory {

	private static ConnectionFactory instance = new ConnectionFactory();
	
	private final String driver = "oracle.jdbc.driver.OracleDriver";
	private final String url = "jdbc:oracle:thin:@ec2-52-78-240-104.ap-northeast-2.compute.amazonaws.com:1521:xe";
	private final String user = "scott";
	private final String password = "tiger";
	
	/**
	 * <PRE>
	 * 기본생성자
	 * DB접속을 위한 설정정보를 로딩한다.
	 * 외부에서는 호출안됨
	 * </PRE>
	 */
	private ConnectionFactory() {
		//
		try {
			Class.forName(driver);
		}
		catch(ClassNotFoundException e) {
			throw new RuntimeException("드라이버를 로딩하기 위한 클래스를 찾을 수 없습니다. : " + driver);
		}
	}
	
	/**
	 * 컨넥션 팩토리 인스턴스 반환
	 * @return
	 */
	public static ConnectionFactory getInstance() {
		//
		return instance;
	}
	
	/**
	 * 데이터베이스 컨넥션 생성
	 * @return
	 */
	public Connection createConnection() {
		//
		try {
			return DriverManager.getConnection(url, user, password);
		}
		catch(SQLException e) {
			throw new RuntimeException("데이터베이스 접속중 오류가 발생했습니다.");
		}
	}
}


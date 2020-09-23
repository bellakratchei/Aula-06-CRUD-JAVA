package bellakratchei.com.github.fabrica;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaJDBC {

	public static Connection criaConn() {
		Connection conn = null;
		try {
			String path = System.getProperty("user.dir");
			String url = "jdbc:sqlite:" + path + "/database/banco.db";
			conn = DriverManager.getConnection(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}

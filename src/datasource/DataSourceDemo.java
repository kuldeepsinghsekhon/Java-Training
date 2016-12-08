package datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.MysqlDataSource;

public class DataSourceDemo {

	public static void main(String[] args) {
		MysqlDataSource ds = new MysqlDataSource();

		ds.setUrl("jdbc:mysql://localhost/sec");
		ds.setUser("admin");
		ds.setPassword("admin");
		try (Connection conn = ds.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from users");) {

			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
			}
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
			System.out.println(e.getMessage());
			System.out.println(e.getSQLState());
			
		}
	}

}

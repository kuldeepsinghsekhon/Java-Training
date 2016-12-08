package datasource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DButil {
	Connection connection=null;
	ResourceBundle db_parm;

public Connection getConnection(){
	db_parm=  ResourceBundle.getBundle("datasource");
	MysqlDataSource ds=new MysqlDataSource();
	ds.setUrl(db_parm.getString("db_url"));
	ds.setUser(db_parm.getString("db.user"));
	ds.setPassword(db_parm.getString("password"));
	try {
		connection=ds.getConnection();
	} catch (SQLException e) {
		e.getErrorCode();
		e.getMessage();
		e.getSQLState();
	}
	return connection ;
	
}
}

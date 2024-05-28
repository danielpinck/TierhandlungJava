package tierhandlung2307;
import java.sql.*;

import java.sql.ResultSet;

public class DBconnection {
	//DB variables
	static final String sqlUrl = "jdbc:mysql://localhost:3306/tierhandlung";
	static final String user = "root";
	static final String password = "";
	static ResultSet rs;
	Connection conn = null;
	Statement stmt = null;
//	private StartHandlung sh;

	public DBconnection() {
		super();
//		this.sh = new StartHandlung();


		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Trying to connect to db");
			conn = DriverManager.getConnection(sqlUrl, user, password);
			stmt = conn.createStatement();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
    }



	public void cleanupDB() throws SQLException {
		// clean up
		stmt.close();
		conn.close();
		rs.close();
	}




} //Ende der Klasse
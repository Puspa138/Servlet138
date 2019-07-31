import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJdbc {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3360/test", "root", "root");
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from test.login");
			while (rs.next()) {
				String user = rs.getString("user");
				System.out.print("username" + user);
			}
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
	}
}
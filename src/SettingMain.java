import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SettingMain {
	public static void main(String[] args) throws Exception{
		//DB연결
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost","root","1234");		
		Statement stmt = con.createStatement();
		
		//기존 DB삭제
		ResultSet rs = con.getMetaData().getCatalogs();
		while (rs.next()) {
			String s = rs.getString("table_cat");
			if (!s.equals("sys") && !s.equals("information_schema") && !s.equals("mysql") && !s.equals("performance_schema")) {
				stmt.execute("drop database `" + s + "`");
			}
		}

	}
}

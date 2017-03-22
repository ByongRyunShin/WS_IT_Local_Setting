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
	}
}

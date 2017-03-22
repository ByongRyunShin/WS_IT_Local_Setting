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
		
		//새로운 DB 생성
		stmt.execute("CREATE SCHEMA `sw3_01` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;");
		
		//테이블 생성
		stmt.execute("CREATE TABLE `sw3_01`.`tbl_customer` (  `cID` VARCHAR(6) NOT NULL,  `cPW` VARCHAR(4) NULL,  `cName` VARCHAR(10) NULL,  `cHP` VARCHAR(13) NULL,  PRIMARY KEY (`cID`));");
		stmt.execute("CREATE TABLE `sw3_01`.`tbl_bus` (  `bNumber` VARCHAR(4) NOT NULL,  `bDeparture` VARCHAR(5) NULL,  `bArrival` VARCHAR(5) NULL,  `bTime` TIME NULL,  `bElapse` VARCHAR(10) NULL,  `bCount` VARCHAR(1) NULL,`bPrice` INT(6) NULL,PRIMARY KEY (`bNumber`));");
		stmt.execute("CREATE TABLE `sw3_01`.`tbl_ticket` (  `bDate` DATE NULL,  `bNumber` VARCHAR(4) NULL,  `bNumber2` VARCHAR(5) NULL,  `bSeat` INT(2) NULL,  `cID` VARCHAR(6) NULL,  `bPrice` INT(6) NULL,  `bState` VARCHAR(1) NULL);");

	}
}

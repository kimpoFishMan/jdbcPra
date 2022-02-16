import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Example1 {
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		//접속정보
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String user = "newlec";
		String password = "dkdk123";

		
		//드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//컨넥션 얻기
		Connection con = DriverManager.getConnection(url,user,password);
		//실행문준비
		Statement st = con.createStatement();
		//실행결과테이블 얻기
		ResultSet rs = st.executeQuery("select * from notice where hit >= 10");
		
		System.out.printf("id \t title \t writer_id \t content \t regdate \t hit \t files ");
		System.out.println();
		//출력
		while(rs.next()) {
			//컬럼 얻기
			int id = rs.getInt("id");
			String title = rs.getString("title");
			String writer_id = rs.getString("writer_id");
			String content = rs.getString("content");
			Date regdate = rs.getDate("regdate");
			int hit = rs.getInt("hit");
			String files = rs.getString("files");
			System.out.print(id+"," + title +"," + writer_id +"," +content +"," + regdate +"," + hit +"," +files );
			System.out.println();
		}
		
		
		//자원해제
		rs.close();
		st.close();
		con.close();
	}

}

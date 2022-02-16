import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Example1 {
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		//��������
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String user = "newlec";
		String password = "dkdk123";

		
		//����̹� �ε�
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//���ؼ� ���
		Connection con = DriverManager.getConnection(url,user,password);
		//���๮�غ�
		Statement st = con.createStatement();
		//���������̺� ���
		ResultSet rs = st.executeQuery("select * from notice where hit >= 10");
		
		System.out.printf("id \t title \t writer_id \t content \t regdate \t hit \t files ");
		System.out.println();
		//���
		while(rs.next()) {
			//�÷� ���
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
		
		
		//�ڿ�����
		rs.close();
		st.close();
		con.close();
	}

}

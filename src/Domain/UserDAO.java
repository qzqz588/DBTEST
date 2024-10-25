package Domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private String user = "book_ex";
	private String password = "book_ex";
	
	private String sql; 					//sql 문저장
	private PreparedStatement pstmt =null;	//sql문 명령 전달하는 용도
	private ResultSet rs = null;			//쿼리 결과 저장
	private Connection con = null;			//연결 정보 저장
	
	//싱글톤 패턴
	private static UserDAO instance = new UserDAO();
	 
	public static UserDAO getInstance(){
		if(instance==null)
			instance=new UserDAO();
		return instance;
	}
	private UserDAO(){
		try 
		{
			Class.forName(driver);
			System.out.println("Driver Loading Success");
			con=DriverManager.getConnection(url,user,password);
			System.out.println("DB Connected..");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void Insert(AccDTO dto){
		try {
			
			sql="insert into book_tbl values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getBookCode());
			pstmt.setInt(2, dto.getClassificationId());
			pstmt.setString(3, dto.getBookAuthor());
			pstmt.setString(4, dto.getBookName());
			pstmt.setString(5, dto.getBookName());
			if(dto.isIsreserve())
				pstmt.setString(6, "1");
			else
				pstmt.setString(6, "0");
			
			int result = pstmt.executeUpdate();
			if(result!=0) {
				System.out.println("도서 등록 완료!");
			}else {
				System.out.println("도서 등록 실패!");
			}
			 
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{pstmt.close();}catch(Exception e) {e.printStackTrace();}
		}
	}
	void Update() {
		try {
			
		}catch(Exception e) {
			
		}finally {
			
		}
	}
	void Select(int x) {
		try {
			
		}catch(Exception e) {
			
		}finally {
			
		}
	}
	void Select(int x,int y) {
		try {
			
		}catch(Exception e) {
			
		}finally {
			
		}
	}
}

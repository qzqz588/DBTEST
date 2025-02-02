package Domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private String user = "system";
	private String password = "1234";
	
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
	
	
	public void Insert(UserDTO dto){
		try {
			
			sql="insert into Member_tbl values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getMember_no());
			pstmt.setString(2, dto.getMember_name());
			pstmt.setString(3, dto.getGrade()+"");
			pstmt.setString(4, dto.getPhone());
			pstmt.setString(5, dto.getAddress());
			
			int result = pstmt.executeUpdate();
			if(result!=0) {
				System.out.println("멤버 등록 성공!");
			}else {
				System.out.println("멤버 등록 실패!");
			}
			 
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{pstmt.close();}catch(Exception e) {e.printStackTrace();}
		}
	}
	void Update(UserDTO dto) {
		try {
			
			sql="update Member_tbl set member_name=?, grade=?, phone=?, address=? where member_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMember_name());
			pstmt.setString(2, dto.getGrade()+"");
			pstmt.setString(3, dto.getPhone());
			pstmt.setString(4, dto.getAddress());
			pstmt.setInt(5, dto.getMember_no());
			
			int result = pstmt.executeUpdate();
			if(result!=0) {
				System.out.println("멤버 수정 성공!");
			}else {
				System.out.println("멤버 수정 실패!");
			}
			 
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{pstmt.close();}catch(Exception e) {e.printStackTrace();}
		}
	}
	public UserDTO Select(int member_no) {
		UserDTO dto = null;
		try {
			sql="select * from Member_tbl where member_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, member_no);
			
			rs = pstmt.executeQuery();
			
			
			if(rs!=null) {
				if(rs.next()) {
					dto= new UserDTO();
					dto.setMember_no(member_no);
					dto.setMember_name(rs.getString("member_name"));
					dto.setGrade(rs.getString("grade").charAt(0));
					dto.setPhone(rs.getString("phone"));
					dto.setAddress(rs.getString("address"));
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{rs.close();}catch(Exception e) {e.printStackTrace();}
			try{pstmt.close();}catch(Exception e) {e.printStackTrace();}
		}
		return dto;
	}
	public List<UserDTO> SelectAll() {
		List<UserDTO> list = new ArrayList();
		UserDTO dto = null;
		try {
			sql="select * from Member_tbl";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs!=null) {
				while(rs.next()) {
					dto= new UserDTO();
					dto.setMember_no(rs.getInt("member_no"));
					dto.setMember_name(rs.getString("member_name"));
					dto.setGrade(rs.getString("grade").charAt(0));
					dto.setPhone(rs.getString("phone"));
					dto.setAddress(rs.getString("address"));
					list.add(dto);
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{rs.close();}catch(Exception e) {e.printStackTrace();}
			try{pstmt.close();}catch(Exception e) {e.printStackTrace();}
		}
		return list;
	}
}

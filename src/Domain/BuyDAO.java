package Domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BuyDAO {
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private String user = "system";
	private String password = "1234";
	
	private String sql; 					//sql 문저장
	private PreparedStatement pstmt =null;	//sql문 명령 전달하는 용도
	private ResultSet rs = null;			//쿼리 결과 저장
	private Connection con = null;			//연결 정보 저장
	
	//싱글톤 패턴
	private static BuyDAO instance = new BuyDAO();
	 
	public static BuyDAO getInstance(){
		if(instance==null)
			instance=new BuyDAO();
		return instance;
	}
	private BuyDAO(){
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
	
	
	public void Insert(BuyDTO dto){
		try {
			
			sql="insert into Buy_tbl values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getMember_no());
			pstmt.setInt(2, dto.getAcc_no());
			pstmt.setInt(3, dto.getBuy_no());
			pstmt.setString(4, dto.getGrade()+"");
			pstmt.setString(5, dto.getBrand());
			pstmt.setInt(6, dto.getPrice());
			
			int result = pstmt.executeUpdate();
			if(result!=0) {
				System.out.println("구매 성공!");
			}else {
				System.out.println("구매 실패!");
			}
			 
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{pstmt.close();}catch(Exception e) {e.printStackTrace();}
		}
	}
	void Update(BuyDTO dto) {
		try {
			
			sql="update Buy_tbl set member_no=?, acc_no=?, grade=?,brand=?,price=? where buy_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getMember_no());
			pstmt.setInt(2, dto.getAcc_no());
			pstmt.setString(3, dto.getGrade()+"");
			pstmt.setString(4, dto.getBrand());
			pstmt.setInt(5, dto.getPrice());
			pstmt.setInt(5, dto.getBuy_no());
			
			int result = pstmt.executeUpdate();
			if(result!=0) {
				System.out.println("구매 수정 성공!");
			}else {
				System.out.println("구매 수정 실패!");
			}
			 
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{pstmt.close();}catch(Exception e) {e.printStackTrace();}
		}
	}
	public BuyDTO Select(int buy_no) {
		BuyDTO dto = null;
		try {
			sql="select * from Buy_tbl where buy_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, buy_no);
			
			rs = pstmt.executeQuery();
			
			
			if(rs!=null) {
				if(rs.next()) {
					dto= new BuyDTO();
					dto.setBuy_no(buy_no);
					dto.setMember_no(rs.getInt("member_no"));
					dto.setAcc_no(rs.getInt("acc_no"));
					dto.setGrade(rs.getString("grade").charAt(0));
					dto.setBrand(rs.getString("brand"));
					dto.setPrice(rs.getInt("price"));
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
	public List<BuyDTO> SelectAll() {
		List<BuyDTO> list = new ArrayList();
		BuyDTO dto = null;
		try {
			sql="select * from Buy_tbl";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs!=null) {
				while(rs.next()) {
					dto= new BuyDTO();
					dto.setBuy_no(rs.getInt("buy_no"));
					dto.setMember_no(rs.getInt("member_no"));
					dto.setAcc_no(rs.getInt("acc_no"));
					dto.setGrade(rs.getString("grade").charAt(0));
					dto.setBrand(rs.getString("brand"));
					dto.setPrice(rs.getInt("price"));
					
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

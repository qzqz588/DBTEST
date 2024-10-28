package Domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccDAO {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private String user = "system";
	private String password = "1234";

	private String sql; // sql 문저장
	private PreparedStatement pstmt = null; // sql문 명령 전달하는 용도
	private ResultSet rs = null; // 쿼리 결과 저장
	private Connection con = null; // 연결 정보 저장

	// 싱글톤 패턴
	private static AccDAO instance = new AccDAO();

	public static AccDAO getInstance() {
		if (instance == null)
			instance = new AccDAO();
		return instance;
	}

	public AccDAO() {
		try {
			Class.forName(driver);
			System.out.println("Driver Loading Success");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB Connected..");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Insert(AccDTO dto) {
		try {

			sql = "insert into Accessory_tbl values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getAcc_no());
			pstmt.setString(2, dto.getAcc_type());
			pstmt.setInt(3, dto.getPrice());
			pstmt.setInt(4, dto.getBrand_no());
			pstmt.setInt(5, dto.getMaterial_no());

			int result = pstmt.executeUpdate();
			if (result != 0) {
				System.out.println("ACC 등록 완료!");
			} else {
				System.out.println("ACC 등록 실패 ㅠㅠ!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void Update(AccDTO dto, Integer acc_no) {
		try {

			sql = "update Accessory_tbl set acc_type=?,price=?,brand_no=?,material_no=? where acc_no=?";
			pstmt.setString(1, dto.getAcc_type());
			pstmt.setInt(2, dto.getPrice());
			pstmt.setInt(3, dto.getBrand_no());
			pstmt.setInt(4, dto.getMaterial_no());
			pstmt.setInt(5, dto.getAcc_no());

			int result = pstmt.executeUpdate();
			if (result != 0) {
				System.out.println("ACC 수정 완료!");
			} else {
				System.out.println("ACC 수정 실패 ㅠㅠ!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public AccDTO Select(int acc_no) {
		AccDTO dto = null;
		try {
			sql = "select * from Accessory_tbl where acc_no=?";
			pstmt.setInt(1, acc_no);
			rs= pstmt.executeQuery();
		
			if (rs!=null) {
				if(rs.next()) {
					dto = new AccDTO();
					dto.setAcc_type(rs.getString("acc_type"));
					dto.setPrice(rs.getInt("price"));
					dto.setBrand_no(rs.getInt("brand_no"));
					dto.setMaterial_no(rs.getInt("material_no"));
				}
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {rs.close();}catch(Exception e) {e.printStackTrace();}
			try {pstmt.close();}catch(Exception e) {e.printStackTrace();}
		}return dto;
	}

	public List<AccDTO> selectAll() throws SQLException {
		List<AccDTO> list = new ArrayList();
		try {
			pstmt = con.prepareStatement("select * from Accessory_tbl");
			
			rs = pstmt.executeQuery();
			AccDTO dto=null;
			if(rs!=null) {
				while(rs.next()) {
					dto = new AccDTO();
					dto.setAcc_no(rs.getInt("acc_no"));
					dto.setAcc_type(rs.getString("acc_type"));
					dto.setPrice(rs.getInt("price"));
					dto.setBrand_no(rs.getInt("brand_no"));
					dto.setMaterial_no(rs.getInt("material_no"));
					
					list.add(dto);
				}
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {rs.close();

		}
		return list;
	}
	
	public void delete(int acc_no) throws SQLException {
		try {
		pstmt = con.prepareStatement("delete from Accessory_tbl where acc_no=?");
		pstmt.setInt(1,acc_no);
		
		int result =  pstmt.executeUpdate();
		
		
	}catch(Exception e){
		e.printStackTrace();
		}finally {rs.close();
		}
		
	}
}


package Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Domain.AccDAO;
import Domain.AccDTO;

public class AccService {
	AccDAO accdao;

	// 싱글톤 패턴
	private static AccService instance = new AccService();

	private AccService() {
		accdao = AccDAO.getInstance();
	}

	public static AccService getInstance() {
		if (instance == null)
			instance = new AccService();
		return instance;
	}
//액세서리 추가
	public Map<String, Object> AccAdd(AccDTO dto, Integer acc_no) {
		Map<String, Object> returnValue = new HashMap();
		if (acc_no == null) {
			try {
				accdao.Insert(dto);
				returnValue.put("success", true);
				returnValue.put("message", "액세서리 추가 완료");
			} catch (Exception e) {
				returnValue.put("success", false);
				returnValue.put("message", "액세서리 추가 중 오류 발생");
			}
		} else {
			returnValue.put("fail", false);
			returnValue.put("message", "이미 존재하는 No 입니다.");
		}
		return returnValue;
	}
//액세서리 수정
	public Map<String, Object> AccUpdate(AccDTO dto) {
		Map<String, Object> returnValue = new HashMap();
		AccDTO dto2 = accdao.Select(dto.getAcc_no());
		if (dto == null) {
			returnValue.put("success", false);
			returnValue.put("message", "유효한 넘버가 필요합니다.");
		} else {
			try {
				if(dto2.getAcc_type().equals(dto.getAcc_type()) && dto2.getBrand_no() == dto.getBrand_no() 
						&& dto2.getPrice() == dto.getPrice() && dto2.getMaterial_no() == dto.getMaterial_no() ) {
					returnValue.put("success", false);
					returnValue.put("message", "수정할 내용이 없습니다.");
				} else {
					returnValue.put("success", true);
					returnValue.put("message", "액세서리 업데이트 완료");
				}
			} catch (Exception e) {
				returnValue.put("success", false);
				returnValue.put("message", "액세서리 수정 중 오류가 발생했습니다.");
			}
		}
		return returnValue;
	}
//Select All
	public Map<String, Object> SelectAll() {
		Map<String,Object> returnValue = new HashMap();
		 try {
		        // DAO에서 전체 액세서리 데이터 조회
		        List<AccDTO> accessories = accdao.selectAll();

		        if (!accessories.isEmpty()) {
		            // 데이터가 존재할 경우
		        	returnValue.put("success", true);
		        	returnValue.put("data", accessories);
		        	returnValue.put("message", "전체 액세서리 조회 성공.");
		        } else {
		            // 데이터가 없을 경우
		        	returnValue.put("success", false);
		            returnValue.put("message", "액세서리 데이터가 존재하지 않습니다.");
		        }

		    } catch (Exception e) {
		        e.printStackTrace();
		        returnValue.put("success", false);
		        returnValue.put("message", "전체 액세서리 조회 중 오류가 발생했습니다.");
		    }

		    return returnValue;  // 결과 반환
		}
		
//Select
	public Map<String, Object> Select(int acc_no) {
		Map<String, Object> returnValue = new HashMap();
		AccDTO existingAccessory = accdao.Select(acc_no);
		 if (existingAccessory != null) {
		        // 존재할 경우
			 returnValue.put("exists", true);
			 returnValue.put("message", "해당 acc_no가 존재합니다.");
		    } else {
		        // 존재하지 않을 경우
		    	returnValue.put("exists", false);
		    	returnValue.put("message", "해당 acc_no가 존재하지 않습니다.");
		    }

		    return returnValue;  // 결과 반환
		}
	
//액세서리 삭제
	public Map<String, Object> deleteAccessory(int acc_no) {
	    Map<String, Object> result = new HashMap<>();
	    AccDTO dto2 = accdao.Select(acc_no);
	    try {
	        // DAO의 delete 메서드 호출
	    	accdao.delete(acc_no);
	    	
	        // 삭제가 성공적으로 수행되었는지 확인
	        result.put("success", true);
	        result.put("message", "액세서리가 성공적으로 삭제되었습니다.");
	        
	        if(accdao.Select(acc_no) == null) {
	        	result.put("success", false);
	        	result.put("message","액세서리가 삭제되지않았습니다");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        result.put("success", false);
	        result.put("message", "액세서리 삭제 중 오류가 발생했습니다.");
	    }

	    return result;  // 결과 반환
	}
	
}
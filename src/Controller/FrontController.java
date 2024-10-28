package Controller;

import java.util.HashMap;
import java.util.Map;



public class FrontController {
	
	Map<String,Controller> map = new HashMap();
	
	//싱글톤
	private static FrontController instance=new FrontController();
	private FrontController(){
		Init();	 
	}
	public static FrontController getInstance() {
		if(instance==null)
			instance=new FrontController();
		return instance;
	}
	
	
	//서브컨트롤러 식별 등록
	void Init() {
		map.put("MEMBER",new MemberController());
		map.put("ACC",new AccController() );
//		map.put("BUY",new BuyController() );
	
	}
	
	//서브컨트롤러 실행하기 
	public void SubControllerEX(Map<String,Object>params, int num, Object dto) {
		String endPoint = (String)params.get("endPoint");
		Controller sub= map.get(endPoint);
		sub.execute(num, dto);
		
	}
	//파라미터 받기
	//입력값 검증
	//서비스 실행 ->DB 연결 -> 결과 가져오기
	//Viwer 로 이동
	//프레젠테이션계층(VIEWER) - 비지니스 계층(CONTROLLER-Service) - 영속계층(DB연결)
	
}

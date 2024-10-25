package Controller;

import java.util.HashMap;
import java.util.Map;

import Domain.AccDTO;

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
		map.put("BOOK",new BookController());
		//map.put("MEMBER",new MemberController() );
		//map.put("RENTAL",new RentalController() );
	
	}
	
	//서브컨트롤러 실행하기 
	public void SubControllerEX(String menu,int num,AccDTO dto) {	
		Controller sub= map.get(menu);
		sub.execute(num, dto);
		
	}
	//파라미터 받기
	//입력값 검증
	//서비스 실행 ->DB 연결 -> 결과 가져오기
	//Viwer 로 이동
	//프레젠테이션계층(VIEWER) - 비지니스 계층(CONTROLLER-Service) - 영속계층(DB연결)
	
}

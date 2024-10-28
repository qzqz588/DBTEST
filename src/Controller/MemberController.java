package Controller;

import Domain.BookDTO;
import Service.BookService;

public class MemberController implements Controller{

	//멤버 
	MemberService service =MemberService.getInstance();
	

	@Override
	public void execute(int num, UserDTO dto) {
		 
		switch(num)
		{
		case 1:	//등록
			//서비스 실행
			service.Insert(dto);
			
			break;
		case 2:	//수정
			
			break;
		case 3:	//조회
			
			break;
		default :
			return ;
		}
		
	}
	


}

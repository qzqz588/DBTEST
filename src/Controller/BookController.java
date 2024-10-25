package Controller;

import Domain.AccDTO;
import Service.BookService;

public class BookController implements Controller{

	//멤버 
	BookService service=service =BookService.getInstance();
	

	@Override
	public void execute(int num, AccDTO dto) {
		 
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

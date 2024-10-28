package Controller;

public abstract class BuyController implements Controller{

	//멤버 
	BuyService service = BuyService.getInstance();
	

	@Override
	public void execute(int num, BuyDTO dto) {
		 
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

package Controller;

import Domain.AccDTO;
import Service.AccService;

public class AccController implements Controller {

	// 멤버
	AccService service = AccService.getInstance();

	@Override
	public void execute(int num, Object dto) {
		// TODO Auto-generated method stub

		switch (num) {
		case 1: // 등록
			// 서비스 실행

			service.AccAdd((AccDTO) dto, num);
			break;
		case 2: // 수정
			service.AccUpdate((AccDTO) dto);
			break;
		case 3: // 조회
			service.Select(num);
			break;
		default:
			System.out.println("올바른 숫자를 입력해주세요");
		}

	}

}

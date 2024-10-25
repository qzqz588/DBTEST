package Service;

import Domain.AccDAO;
import Domain.AccDTO;

public class AccService {
	AccDAO accdao;
	
	//싱글톤 패턴
	private static AccService instance = new AccService();
	private AccService(){
		accdao=AccDAO.getInstance();
	}
	public static AccService getInstance(){
		if(instance==null)
			instance=new AccService();
		return instance;
	}

	
	public void Insert(AccDTO dto) {
		
		accdao.Insert(dto);
	}
	
	void Update(AccDTO dto) {
		accdao.Update(dto);
	}
	void Select() {
		
	}
	void Select(int num) {
		
	}
	
}

package Viewer;

import java.sql.ResultSet;
import java.util.Scanner;

import Controller.FrontController;
import Domain.AccDTO;

public class Viewer {
	
	FrontController controller=FrontController.getInstance();
	Scanner sc = new Scanner(System.in);
	int num=0;
	
	//싱글톤 패턴
	private static Viewer instance = new Viewer();
	private Viewer(){
			
	}
	public static Viewer getInstance(){
		if(instance==null)
			instance=new Viewer();
		return instance;
	}
	
	//메인 메뉴
	public void MainMenu() {
		while(true)
		{
		System.out.println("------------- M E N U -------------");
		System.out.println("1 Book_Tbl");
		System.out.println("2 Member_Tbl");
		System.out.println("3 Rental_Tbl");
		System.out.println("4 Exit");
		System.out.println("------------- M E N U -------------");
		System.out.print("번호 : " );
		num=sc.nextInt();
			switch(num)
			{
			case 1:
				BookMenu();
				break;
			case 2:
				MemberMenu();
				break;
			case 3:
				RentalMenu();
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				System.exit(-1);
				break;
			default:
				System.out.println("다시 입력..");
			}	
		}
	}
	
	void BookMenu() {
		 
		while(true)
		{
		System.out.println("------------- B O O K -------------");
		System.out.println("1 Insert");
		System.out.println("2 Update");
		System.out.println("3 Select");
		System.out.println("4 Prev");
		System.out.println("------------- B O O K -------------");	
		System.out.print("번호 : " );
		num=sc.nextInt();
		switch(num)
		{
		case 1:
			System.out.print("코드|분류번호|저자|책제목|출판사 > ");
			int code=sc.nextInt();
			int classid=sc.nextInt();
			String author = sc.next();
			String title = sc.next();
			String publisher = sc.next();
			AccDTO dto = new AccDTO(code,classid,author,title,publisher,false);
			//controller로 전달
			controller.SubControllerEX("BOOK",1,dto);
			
			break;
		case 2:
			 
			break;
		case 3:
			 
			break;
		case 4:
			return ;
		default:
			System.out.println("다시 입력..");
		
		}
		}
	}	
	void MemberMenu() {	
		while(true)
		{
		System.out.println("------------- M E M B E R -------------");
		System.out.println("1 Insert");
		System.out.println("2 Update");
		System.out.println("3 Select");
		System.out.println("4 Prev");
		System.out.println("------------- M E M B E R -------------");
		System.out.print("번호 : " );
		num=sc.nextInt();
		switch(num)
		{
		case 1:
		 
			break;
		case 2:
			 
			break;
		case 3:
			 
			break;
		case 4:
			return ;
		default:
			System.out.println("다시 입력..");
		
		}
		}
	}
	void RentalMenu() {	
		while(true)
		{
		System.out.println("------------- R E N T A L -------------");
		System.out.println("1 Insert");
		System.out.println("2 Update");
		System.out.println("3 Select");
		System.out.println("4 Prev");
		System.out.println("------------- R E N T A L -------------");
		System.out.print("번호 : " );
		num=sc.nextInt();
		switch(num)
		{
		case 1:
		 
			break;
		case 2:
			 
			break;
		case 3:
			 
			break;
		case 4:
			return ;
		default:
			System.out.println("다시 입력..");
		
		}
		}
	}
	void SelectMenu(String select , int num) {
		
	}
	void ResultPrint(ResultSet rs) {
		
	}
	
}

package Viewer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Controller.FrontController;
import Domain.AccDAO;
import Domain.AccDTO;

public class Viewer {

    private FrontController controller = FrontController.getInstance();
    private Scanner sc = new Scanner(System.in);
    private int num = 0;

    // 싱글톤 패턴
    private static Viewer instance = new Viewer();

    private Viewer() {}

    public static Viewer getInstance() {
        return instance;
    }

    Map<String, Object> map = new HashMap<>();

    // 메인 메뉴
    public void MainMenu() {
        while (true) {
            System.out.println("------------- M E N U -------------");
            System.out.println("1 Acc_tbl");
            System.out.println("2 Member_Tbl");
            System.out.println("3 Buy_tbl");
            System.out.println("4 Exit");
            System.out.println("------------- M E N U -------------");
            System.out.print("번호 : ");
            num = sc.nextInt();
            switch (num) {
                case 1:
                    AccMenu();
                    break;
                case 2:
                    MemberMenu();
                    break;
                case 3:
                    BuyMenu();
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

    void AccMenu() {
        AccDAO accdao = new AccDAO();
        AccDTO dto;

        while (true) {
            System.out.println("------------- A C C E S S O R Y -------------");
            System.out.println("1 Insert");
            System.out.println("2 Update");
            System.out.println("3 Select");
            System.out.println("4 Delete");
            System.out.println("5 Prev");
            System.out.println("------------- A C C E S S O R Y -------------");
            System.out.print("번호 : ");
            num = sc.nextInt();
            switch (num) {
                case 1: // Insert
                    dto = new AccDTO();
                    System.out.print("액세서리 번호: ");
                    dto.setAcc_no(sc.nextInt());
                    System.out.print("액세서리 분류 번호: ");
                    dto.setAcc_type(sc.next());
                    System.out.print("가격: ");
                    dto.setPrice(sc.nextInt());
                    System.out.print("브랜드 번호: ");
                    dto.setBrand_no(sc.nextInt());
                    System.out.print("소재 번호: ");
                    dto.setMaterial_no(sc.nextInt());

                    map.put("endPoint", "ACC");
                    controller.SubControllerEX(map, 1, dto);
                    break;

                case 2: // Update
                    System.out.print("수정할 액세서리 번호: ");
                    int accNoToUpdate = sc.nextInt();
                    dto = accdao.Select(accNoToUpdate);

                    if (dto != null) {
                        System.out.print("새로운 액세서리 분류 번호: ");
                        dto.setAcc_type(sc.next());
                        System.out.print("새로운 가격: ");
                        dto.setPrice(sc.nextInt());
                        System.out.print("새로운 브랜드 번호: ");
                        dto.setBrand_no(sc.nextInt());
                        System.out.print("새로운 소재 번호: ");
                        dto.setMaterial_no(sc.nextInt());

                        map.put("endPoint", "ACC");
                        controller.SubControllerEX(map, 2, dto);
                    } else {
                        System.out.println("해당 번호의 액세서리가 존재하지 않습니다.");
                    }
                    break;

                case 3: // Select
                    System.out.print("조회할 액세서리 번호: ");
                    int accNoToSelect = sc.nextInt();
                    dto = accdao.Select(accNoToSelect);

                    if (dto != null) {
                        map.put("endPoint", "ACC");
                        controller.SubControllerEX(map, 3, dto);
                    } else {
                        System.out.println("해당 번호의 액세서리가 존재하지 않습니다.");
                    }
                    break;

                case 4: // Delete
                    System.out.print("삭제할 액세서리 번호: ");
                    int accNoToDelete = sc.nextInt();
                    dto = accdao.Select(accNoToDelete);

                    if (dto != null) {
                        map.put("endPoint", "ACC");
                        controller.SubControllerEX(map, 4, dto);
                    } else {
                        System.out.println("해당 번호의 액세서리가 존재하지 않습니다.");
                    }
                    break;

                case 5: // 이전 메뉴로
                    return;

                default:
                    System.out.println("다시 입력..");
            }
        }
    }

    void MemberMenu() {
        // Member 메뉴 구현 (추가 필요)
    }

    void BuyMenu() {
        // Buy 메뉴 구현 (추가 필요)
    }
}
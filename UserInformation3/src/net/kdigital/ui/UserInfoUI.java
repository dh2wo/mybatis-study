package net.kdigital.ui;

import java.util.List;
import java.util.Scanner;

import net.kdigital.service.UserInfoService;
import net.kdigital.vo.UsrInfo;

public class UserInfoUI {
	Scanner sc = new Scanner(System.in);
	UserInfoService service = new UserInfoService();

	public UserInfoUI() {
		while(true) {
			menu();
			String choice = sc.nextLine();
			switch (choice) {
			case "1":
				insertUsr();
				break;
			case "2":
				selectAll();
				break;
			case "3":
				selectByID();
				break;
			case "4":
				updateUsr();
				break;
			case "5":
				deleteUsr();
				break;
			case "0":
				System.out.println(">>프로그램 종료");
				return;
			default:
				System.out.println(">>다시 입력하세요.");
			}
		}
	}	

	private void deleteUsr() {
		System.out.println("<회원 탈퇴>");
		System.out.print("탈퇴할 회원의 ID : ");
		String id = sc.nextLine();

		UsrInfo ui =  service.selectByIDS(id);
		if(ui == null) {
			System.out.println("해당 ID가 존재하지 않습니다.");
			return;
		}
		System.out.println(ui);
		System.out.print("진짜 탈퇴하시겠습니까?(Y/N) : ");
		String choice = sc.nextLine();
		if(choice.equals("Y") || choice.equals("y")) {
			int result = service.deleteUiS(id); 
			if(result == 1) {
				System.out.println("탈퇴 되었습니다.");
			}
		}
		else {
			System.out.println("탈퇴 취소");
		}
	}

	private void updateUsr() {
		System.out.println("<회원 정보 수정>");
		System.out.print("수정할 회원의 ID : ");
		String id = sc.nextLine();

		UsrInfo ui =  service.selectByIDS(id);
		if(ui == null) {
			System.out.println("해당 ID가 존재하지 않습니다.");
			return;
		}
		System.out.println(ui);
		System.out.print("수정할 이름 : ");
		String name = sc.nextLine();
		System.out.print("수정할 나이 : ");
		int age = sc.nextInt();
		sc.nextLine();

		ui = new UsrInfo(id, name, age);
		int result = service.updateUiS(ui);

		if(result == 1) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
	}

	private void selectByID() {
		System.out.println("<회원 정보>");
		System.out.print("검색할 ID : ");
		String id = sc.nextLine();

		UsrInfo ui =  service.selectByIDS(id);
		if(ui == null) {
			System.out.println("해당 ID가 존재하지 않습니다.");
			return;
		}
		System.out.println(ui);
	}

	private void insertUsr() {
		System.out.println("<회원 등록>");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		
		UsrInfo ui =  service.selectByIDS(id);
		if(ui != null) {
			System.out.println("이미 등록된 ID 입니다.");
			return;
		}
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		sc.nextLine();

		ui = new UsrInfo(id, name, age);

		//DB에서 등록한 행의 갯수라 int
		int result = service.insertUiS(ui);
		if(result == 1) {
			System.out.println("등록 완료");
		}
		else {
			System.out.println("등록 실패");
		}
	}

	private void selectAll() {
		System.out.println("<회원 전체 명단>");
		List<UsrInfo> list = service.selectAllS();

		for(UsrInfo u : list) {
			System.out.println(u);
		}
	}

	private void menu() {
		System.out.println("<< 회원 관리 >>");
		System.out.println("1. 회원 등록");
		System.out.println("2. 회원 전체 조회");
		System.out.println("3. 회원 한명 조회");
		System.out.println("4. 회원 정보 수정");
		System.out.println("5. 회원 탈퇴");
		System.out.println("0. 종 료");
		System.out.print("선택 >> ");
	}
}

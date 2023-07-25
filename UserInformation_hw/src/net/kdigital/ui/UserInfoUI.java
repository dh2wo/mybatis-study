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
				selectAll();
				break;
			case "2":
				selectByID();
				break;
			case "0":
				System.out.println("** 프로그램 종료 **");
				return;
			default:
				System.out.println("** 다시 입력하세요. **");
			}
		}
	}	

	private void selectByID() {
		System.out.println("<< 직원 한명 조회 >>");
		System.out.print("조회할 직원의 사원번호 >> ");
		String id = sc.nextLine();
		
		UsrInfo ui = service.selectByIDS(id);
		
		if(ui == null) {
			System.out.println("존재하지 않는 직원입니다.");
			return;
		}
		
		System.out.println(ui);
	}

	private void selectAll() {
		System.out.println("<< 직원 전체 명단 >>");
		List<UsrInfo> list = service.selectAllS();

		for(UsrInfo u : list) {
			System.out.println(u);
		}
	}

	private void menu() {
		System.out.println("<< 회원 관리 >>");
		System.out.println("1. 직원 전체 조회");
		System.out.println("2. 직원 한명 조회");
		System.out.println("0. 종 료");
		System.out.print("선택 >> ");
	}
}

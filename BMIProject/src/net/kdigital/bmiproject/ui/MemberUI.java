package net.kdigital.bmiproject.ui;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import net.kdigital.bmiproject.service.MemberService;
import net.kdigital.bmiproject.vo.MemberVO;

public class MemberUI {
	Scanner sc = new Scanner(System.in);
	MemberService service = new MemberService();

	public MemberUI(){
		while(true){
			menu();
			String choice;
			choice = sc.next();

			switch(choice) {
			case "1": //회원 등록
				memberAdd();
				break;
			case "2": //회원정보 조회
				selectByWhat();
				break;
			case "3": //회원정보 수정
				updateMember();
				break;
			case "4": //회원전체조회
				selectAll();
				break;
			case "5": //회원휴면
				sleepMember();
				break;
			case "6": //회원탈퇴
				removeMember();
				break;
			case "0": //프로그램 종료
				System.out.println("** 프로그램 종료");
				return;
			default:
				System.out.println("** 다시 선택하세요.");
				break;
			}
		}
	}

	//1. 회원 등록
	private void memberAdd() {
		System.out.print("ID: ");
		String id = sc.next();
		MemberVO member = service.selectByID(id);
		//ID존재 유무 - 메뉴
		if(member != null) {
			System.out.println("** 이미 존재하는 ID입니다.");
			return;
		}
		System.out.print("이름: ");
		String name = sc.next();

		//키나 몸무게에 문자열 입력했을때 - 예외처리 - 메뉴
		double height = 0.0;
		double weight = 0.0;
		try {
			//예외가 발생할 수 있는 코드 부분
			System.out.print("키: ");
			height = sc.nextDouble();
			System.out.print("몸무게: ");
			weight = sc.nextDouble();
		} catch (InputMismatchException e) {
			//예외가 발생했을 때
			System.out.println("** 잘못 입력하였습니다.");
			return;
		} finally {
			sc.nextLine();
		}
		member = new MemberVO(id, name, height, weight);
		int result = service.memberAdd(member);
		if(result == 1) {
			System.out.println("** 등록완료!");
			return;
		}
		System.out.println("** 등록실패!");
	}

	//2. 회원정보 조회
	private void selectByWhat() {
		System.out.println("1. ID로 조회");
		System.out.println("2. 이름으로 조회");
		System.out.println("3. BMI결과로 조회");
		System.out.print("선택 > ");
		String choice = sc.next();

		switch(choice) {
		case "1":
			selectByID();
			break;
		case "2":
			selectByName();
			break;
		case "3":
			selectByresult();
			break;
		default:
			System.out.println("** 잘못입력하였습니다.");
			break;
		}
	}

	//2-1. ID로 조회 selectByID()
	private void selectByID() {
		System.out.print(">> 검색할 회원의 ID: ");
		String id = sc.next();
		MemberVO member = service.selectByID(id);
		if(member != null) {
			System.out.println(member);
			return;
		}
		System.out.println("** 해당 ID의 회원은 존재하지 않습니다.");
	}

	//2-2. 이름으로 조회 selectByName();
	private void selectByName() {
		System.out.print(">> 검색할 회원의 이름: ");
		String name = sc.next();
		List<MemberVO> list = service.selectByNR(name, 0);
		if(list.isEmpty()) {
			System.out.println("** 회원이 존재하지 않습니다.");
			return;
		}
		Iterator<MemberVO> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	
	//2-3. BMI결과로 조회 selectByresult();
	private void selectByresult() {
		System.out.print(">> 검색할 회원의 BMI결과: ");
		String result = sc.next();
		List<MemberVO> list = service.selectByNR(result, 1);
		if(list.isEmpty()) {
			System.out.println("** 회원이 존재하지 않습니다.");
			return;
		}
		Iterator<MemberVO> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

	//3. 회원정보 수정
	private void updateMember() {
		System.out.print(">> 수정할 회원의 ID: ");
		String id = sc.next();
		//해당 id가 존재하는지
		MemberVO member = service.selectByID(id);
		if(member == null) {
			System.out.println("** 해당 ID의 회원은 존재하지 않습니다.");
			return;
		}
		//존재한다면 그 회원정보를 출력
		System.out.println(member);

		System.out.print("키 : " );
		double height = sc.nextDouble();
		System.out.print("몸무게 : " );
		double weight = sc.nextDouble();
		member = new MemberVO(id, null, height, weight);
		int result = service.updateMember(member);
		if (result == 0){
			System.out.println("** 해당 멤버 수정에 실패하였습니다.");
			return;
		}
		System.out.println("** 해당 멤버 수정에 성공하였습니다.ㅉ");
	}

	//4. 회원전체조회
	private void selectAll() {
		List<MemberVO> list = service.selectAll();
		if(list.isEmpty()) {
			System.out.println("** 회원이 존재하지 않습니다.");
			return;
		}
		Iterator<MemberVO> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

	//5. 회원휴면
	private void sleepMember() {
		System.out.print(">> 휴면 전환/해제할 회원의 ID: ");
		String id = sc.next();
		String yn  = null;
		MemberVO member = service.selectByID(id);
		if(member == null) {
			System.out.println("** 해당 ID의 회원은 존재하지 않습니다.");
			return;
		}
		//존재한다면 회원정보 출력
		System.out.println(member);
		//휴면상태가 아닌 정상 아이디
		if(member.getDeleteFlag() == 0) {
			System.out.print("휴면으로 전환하시겠습니까?(Y/N): ");
			yn = sc.next();
			if(yn.equals("Y") || yn.equals("y")) {
				int result = service.deleteFlagOnOff(id, 1);
				//업데이트가 된 행의 갯수
				if(result == 1) {
					System.out.println("휴면 상태로 전환되었습니다.");
				}
			} else {
				System.out.println("** 작업이 취소되었습니다.");
				return;
			}
		}
		//member.getDeleteFlag() == 1
		else {
			System.out.print("휴면해제 하시겠습니까?(Y/N): ");
			yn = sc.next();
			if(yn.equals("Y") || yn.equals("y")) {
				int result = service.deleteFlagOnOff(id, 0);
				//업데이트가 된 행의 갯수
				if(result == 1) {
					System.out.println("휴면 해제되었습니다.");
				}
			} else {
				System.out.println("** 작업이 취소되었습니다.");
				return;
			}
		}
	}

	//6. 회원탈퇴
	private void removeMember() {
		System.out.print(">> 탈퇴할 회원의 ID: ");
		String id = sc.next();
		//해당 id가 존재하는지
		MemberVO member = service.selectByID(id);
		if(member == null) {
			System.out.println("** 해당 ID의 회원은 존재하지 않습니다.");
			return;
		}
		//존재한다면 그 회원정보를 화면에 출력
		System.out.println(member);
		System.out.print("탈퇴하시겠습니까? (Y/N) ");
		String yorn = sc.next();

		//Y를 입력하면 탈퇴진행
		if(yorn.equals("Y") || yorn.equals("y")) {
			//탈퇴작업
			service.removeMember(id);
			System.out.println("** 탈퇴 되었습니다.");
			return;
		}
		System.out.println("** 탈퇴 취소 되었습니다.");
	}

	public void menu() {
		System.out.println("   << BMI 회원관리 >>");
		System.out.println("    1. 회원 등록");
		System.out.println("    2. 회원정보 조회");
		System.out.println("    3. 회원정보 수정");
		System.out.println("    4. 회원전체조회");
		System.out.println("    5. 회원휴면");
		System.out.println("    6. 회원탈퇴");
		System.out.println("    0. 프로그램 종료");
		System.out.println("=====================");
		System.out.print("     선택 > ");
	}
}

package net.kdigital.score.ui;

import java.util.List;
import java.util.Scanner;

import net.kdigital.score.service.ScoreService;
import net.kdigital.score.vo.Student;

public class ScoreUI {
	Scanner sc = new Scanner(System.in);
	ScoreService service = new ScoreService();

	public ScoreUI() {
		String choice = null;

		while(true) {
			mainMenu();
			choice = sc.next();

			switch(choice) {
			case "1" : 		// 등록
				input();	
				break;
			case "2" :  	// 조회
				retrieve();
				break;
			case "3" :		// 전체 조회 
				retrieveAll();
				break;    
			case "4" :		// 삭제
				remove();
				break;     
			case "5" :		// 수정 
				modify();
				break;     
			case "0" :		// 종료 
				System.out.println("** 프로그램을 종료합니다.");
				return;   
			default : 
				System.out.println("** 다시 선택해 주세요");
				sc.nextLine();
			} // end switch

		} // end while
	}

	// 1. 성적 등록
	private void input() {
		System.out.println("\n>>>>>> [성적 등록] <<<<<<");
		int stdid; 
		String stdname;
		double it, language, basic;
		
		try {	
			System.out.print("- 학번: ");
			stdid = sc.nextInt();
			
			Student student = service.findByStdid(stdid);
			if(student != null) {
				throw new Exception("** 성적이 이미 등록되어 있습니다.");
			}
			
			System.out.print("- 이름: ");
			stdname = sc.next();
			System.out.print("- IT: ");
			it = sc.nextDouble();
			System.out.print("- 외국어: ");
			language = sc.nextDouble();
			System.out.print("- 베이직: ");
			basic = sc.nextDouble();
			
		} catch(Exception e) {
			String msg = e.getMessage();
			if(msg != null) System.out.println(msg);
			else System.out.println("** 데이터가 잘못 입력되었습니다.");
			sc.nextLine();
			return ;
		}
		
		Student s = new Student(stdid, stdname, it, language, basic);
		
		int result = service.insertScore(s);
		if(result == 1) {
			System.out.println("** 성적이 등록되었습니다.");
			return;
		}
		System.out.println("** 성적이 등록되지 않았습니다.");
		
	}
	
	// 2. 성적 조회
	private void retrieve() {
		System.out.println("\n>>>>>> [성적 조회] <<<<<<");
		int stdid2; 
		Student student = null;
		try {
			System.out.print("- 학번: ");
			stdid2 = sc.nextInt();
			
			student = service.findByStdid(stdid2);
			if(student == null) {
				throw new Exception("** 등록된 성적이 없습니다.");
			}

		} catch(Exception e) {
			String msg = e.getMessage();
			if (msg != null) System.out.println(msg);
			else System.out.println("** 데이터가 잘못 입력되었습니다.");
			sc.nextLine();
			return;
		}
		
		System.out.println(student);		
	}

	// 3. 전체 조회
	private void retrieveAll() {
		System.out.println("\n>>>>>> [전체 조회] <<<<<<");
		List<Student> list = service.selectAll();

		if(list.size() == 0) {
			System.out.println("** 등록된 성적이 없습니다.");
			return;
		}
		
		for(Student s : list) 
			System.out.println(s);
	}


	// 4. 성적 삭제
	private void remove() {
		System.out.println("\n>>>>>> [성적 삭제] <<<<<<");
		int stdid; 
		String answer = null;
		Student student = null;
		try {
			System.out.print("- 학번: ");
			stdid = sc.nextInt();
			
			student = service.findByStdid(stdid);
			if(student == null) {
				throw new Exception("** 등록된 성적이 없습니다.");
			}

		} catch(Exception e) {
			String msg = e.getMessage();
			if(msg != null) System.out.println(msg);
			else System.out.println("** 데이터가 잘못 입력되었습니다.");
			sc.nextLine();
			return ;
		}
		
		System.out.println(student);
		
		System.out.print(">> 위 학생의 성적을 삭제하시겠습니까? (y/n)");
		answer = sc.next();
		if(!answer.equals("y")) {
			System.out.println("** 삭제작업이 취소되었습니다.");
			return;
		}
		
		int result = service.deleteScore(stdid);
		if(result == 1) {
			System.out.println("** 성적이 삭제되었습니다.");
			return;
		}
		System.out.println("** 성적이 삭제되지 않았습니다.");
	}

	// 5. 성적 수정
	private void modify() {
		System.out.println("\n>>>>>> [성적 수정] <<<<<<");
		int stdid; 
		double it, language, basic;
		
		try {
			System.out.print("- 학번: ");
			stdid = sc.nextInt();
			
			Student student = service.findByStdid(stdid);
			if(student == null) {
				throw new Exception("** 등록된 성적이 없습니다.");
			}

			System.out.println("** 현재 성적 **");
			System.out.println(student);
			System.out.println();
			
			System.out.print("- IT: ");
			it = sc.nextDouble();
			System.out.print("- 외국어: ");
			language = sc.nextDouble();
			System.out.print("- 베이직: ");
			basic = sc.nextDouble();
			
		} catch(Exception e) {
			String msg = e.getMessage();
			if(msg != null) System.out.println(msg);
			else System.out.println("** 데이터가 잘못 입력되었습니다.");
			sc.nextLine();
			return ;
		}
		
		Student s = new Student(stdid, null, it, language, basic);
		
		int result = service.updateScore(s);
		if(result == 1) {
			System.out.println("** 성적이 수정되었습니다.");
			return;
		}
		System.out.println("** 성적이 수정되지 않았습니다.");		
	}


	//==================== [ 메뉴 ] ======================
	// 1) 메인 메뉴 
	private void mainMenu() {
		System.out.println("\n=== [ Master 성적관리 ] ===");
		System.out.println("       1. 성적 등록");
		System.out.println("       2. 학번 조회");
		System.out.println("       3. 전체 조회");
		System.out.println("       4. 삭 제");
		System.out.println("       5. 수 정");
		System.out.println("       0. 종 료");
		System.out.println("=============================");
		System.out.print  ("       > 선택 : ");
	}
}

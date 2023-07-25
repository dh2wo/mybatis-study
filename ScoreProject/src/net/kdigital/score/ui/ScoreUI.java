package net.kdigital.score.ui;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import net.kdigital.score.service.ScoreService;
import net.kdigital.score.vo.Student;

public class ScoreUI {
	Scanner sc = new Scanner(System.in);
	ScoreService service = new ScoreService();

	public ScoreUI(){
		while(true){
			menu();
			String choice;
			choice = sc.next();

			switch(choice) {
			case "1": //성적 등록
				addScore();
				break;
			case "2": //성적 조회 (학번)
				selectByID();
				break;
			case "3": //전체 성적 조회 
				selectAll();
				break;
			case "4": //삭제
				deleteByID();
				break;
			case "5": //수정
				updateScore();
				break;
			case "0": //종료
				System.out.println("** 프로그램 종료");
				return;
			default:
				System.out.println("** 다시 선택하세요.");
				break;
			}
		}
	}

	private void updateScore() {
		System.out.println(">>>>>> [성적 수정] <<<<<<");
		int id;
		double it, language, basic;

		try {
			System.out.print("- 학번: ");
			id = sc.nextInt();
			
			Student student = service.selectByID(id);
			if(student == null) {
				System.out.println("** 해당 학번의 학생은 존재하지 않습니다.");
				return;
			}
			
			System.out.println("** 현재 성적 **");
			System.out.println(student);
			System.out.println();
			
			System.out.print("IT: ");
			it = sc.nextDouble();
			System.out.print("Language: ");
			language = sc.nextDouble();
			System.out.print("Basic: ");
			basic = sc.nextDouble();
			
		} catch (InputMismatchException e) {
			System.out.println("** 데이터가 잘못 입력되었습니다.");
			return;
		} finally {
			sc.nextLine();
		}
		
		Student student = new Student(id, null, it, language, basic);
		int result = service.updateScore(student);
		if (result == 0){
			System.out.println("** 성적 수정에 실패하였습니다.");
			return;
		}
		System.out.println("** 성적이 수정되었습니다.");
	}

	private void deleteByID() {
		System.out.println(">>>>>> [성적 삭제] <<<<<<");
		int id;
		Student student = null;
		try {
			System.out.print("- 학번: ");
			id = sc.nextInt();
			student = service.selectByID(id);
			if(student == null) {
				System.out.println("** 해당 학번의 학생은 존재하지 않습니다.");
				return;
			}
		}catch(InputMismatchException e) {
			System.out.println("** 데이터가 잘못 입력되었습니다.");
			return;
		}

		System.out.println(student);

		System.out.print(">> 위 학생의 성적을 삭제하시겠습니까? (Y/N) ");
		String answer = sc.next().toLowerCase();
		if(answer.equals("y")) {
			int result = service.deleteByID(id);
			if(result == 1) {
				System.out.println("** 성적이 삭제되었습니다.");
				return;
			}
		}
		System.out.println("** 삭제작업이 취소되었습니다.");
	}

	private void selectAll() {
		System.out.println(">>>>>> [전체 조회] <<<<<<");
		List<Student> list = service.selectAll();
		if(list.isEmpty()) {
			System.out.println("** 등록된 성적이 없습니다.");
			return;
		}
		for(Student s : list) {
			System.out.println(s);
		}
	}

	private void selectByID() {
		System.out.println(">>>>>> [성적 조회] <<<<<<");
		int id = 0;
		try {
			System.out.print("- 학번: ");
			id = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("** 데이터가 잘못 입력되었습니다.");
			return;
		}
		Student student =  service.selectByID(id);
		if(student == null) {
			System.out.println("** 등록된 성적이 없습니다.");
			return;
		}
		System.out.println(student);

	}

	private void addScore() {
		int id;
		String name;
		double it, language, basic;

		System.out.println(">>>>>> [성적 등록] <<<<<<");
		try {
			System.out.print("- 학번: ");
			id = sc.nextInt();
			Student student = service.selectByID(id);
			if(student != null) {
				System.out.println("** 성적이 이미 등록되어 있습니다.");
				return;
			}
			System.out.print("이름: ");
			name = sc.next();
			System.out.print("IT: ");
			it = sc.nextDouble();
			System.out.print("Language: ");
			language = sc.nextDouble();
			System.out.print("Basic: ");
			basic = sc.nextDouble();
		} catch (InputMismatchException e) {
			System.out.println("** 잘못 입력하였습니다.");
			return;
		} finally {
			sc.nextLine();
		}

		Student student = new Student(id, name, it, language, basic);

		int result = service.addScore(student);
		if(result == 1) {
			System.out.println("** 성적이 등록되었습니다.");
			return;
		}
		System.out.println("** 등록실패!");
	}

	private void menu() {
		System.out.println("=== [ Master 성적관리 ] ===");
		System.out.println("      1. 성적 등록");
		System.out.println("      2. 성적 조회(학번)");
		System.out.println("      3. 전체 성적 조회");
		System.out.println("      4. 삭 제");
		System.out.println("      5. 수 정");
		System.out.println("      0. 종 료");
		System.out.println("=========================");
		System.out.print("      > 선택 :");
	}

}

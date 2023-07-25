package net.kdigital.score.service;

import java.util.List;

import net.kdigital.score.dao.ScoreDAO;
import net.kdigital.score.vo.Student;

public class ScoreService {
	ScoreDAO dao = new ScoreDAO();
	
	// 성적 등록
	public int insertScore(Student s) {
		int result = dao.insertScore(s);
		return result;
	}
	
	// 성적 조회
	public Student findByStdid(int stdid) {
		Student p = dao.findByStdid(stdid);
		return p;
	}

	// 전체 성적 조회
	public List<Student> selectAll() {
		List<Student> list = dao.selectAll();
		return list;
	}

	// 성적 삭제
	public int updateScore(Student s) {
		int result = dao.updateScore(s);
		return result;
	}

	// 성적 수정
	public int deleteScore(int stdid) {
		int result = dao.deleteScore(stdid);
		return result;
	}
}

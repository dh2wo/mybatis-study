package net.kdigital.score.service;

import java.util.List;

import net.kdigital.score.dao.ScoreDAO;
import net.kdigital.score.vo.Student;

public class ScoreService {
	
	ScoreDAO dao = new ScoreDAO();
	
	public int addScore(Student student) {
		int result = dao.addScore(student);
		return result;
	}
	
	public Student selectByID(int stdid) {
		Student student = dao.selectByID(stdid);
		return student;
	}
	
	public List<Student> selectAll(){
		List<Student> list = dao.selectAll();
		return list;
	}
	
	public int deleteByID(int stdid) {
		int result = dao.deleteByID(stdid);
		return result;
	}
	
	public int updateScore(Student student) {
		int result = dao.updateScore(student);
		return result;
	}
}

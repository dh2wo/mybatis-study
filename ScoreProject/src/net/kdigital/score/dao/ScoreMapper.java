package net.kdigital.score.dao;

import java.util.List;

import net.kdigital.score.vo.Student;

public interface ScoreMapper {
	public int addScore(Student student);
	
	public Student selectByID(int stdid);
	
	public List<Student> selectAll();
	
	public int deleteByID(int stdid);
	
	public int updateScore(Student student);
}

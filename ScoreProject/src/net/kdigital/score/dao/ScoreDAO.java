package net.kdigital.score.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import net.kdigital.score.vo.Student;

public class ScoreDAO {

	SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	public int addScore(Student student) {
		SqlSession session = null;
		session = factory.openSession();
		ScoreMapper mapper = session.getMapper(ScoreMapper.class);

		int result = mapper.addScore(student);

		session.commit();
		session.close();
		return result;
	}

	public Student selectByID(int stdid) {
		SqlSession session = null;
		session = factory.openSession();
		ScoreMapper mapper = session.getMapper(ScoreMapper.class);

		Student student = mapper.selectByID(stdid);
		
		session.commit();
		session.close();
		return student;
	}

	public List<Student> selectAll(){
		SqlSession session = null;
		session = factory.openSession();
		ScoreMapper mapper = session.getMapper(ScoreMapper.class);
		
		List<Student> list = mapper.selectAll();
		
		session.commit();
		session.close();
		return list;
	}

	public int deleteByID(int stdid) {
		SqlSession session = null;
		session = factory.openSession();
		ScoreMapper mapper = session.getMapper(ScoreMapper.class);

		int result = mapper.deleteByID(stdid);

		session.commit();
		session.close();
		return result;
	}
	
	public int updateScore(Student student) {
		SqlSession session = null;
		session = factory.openSession();
		ScoreMapper mapper = session.getMapper(ScoreMapper.class);
		
		int result = mapper.updateScore(student);
		
		session.commit();
		session.close();
		return result;
	}
}


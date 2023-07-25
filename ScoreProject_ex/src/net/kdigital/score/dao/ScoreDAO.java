package net.kdigital.score.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import net.kdigital.score.vo.Student;

public class ScoreDAO {
	// DB 접속을 위한 SessionFactory 객체 얻어옴
	SqlSessionFactory factory = MybatisConfig.getSessionFactory();

	public int insertScore(Student s) {
		SqlSession session = null;
		session = factory.openSession();
		ScoreMapper mapper = session.getMapper(ScoreMapper.class);
		
		int result = mapper.insertScore(s);
		
		session.commit();
		session.close();
		
		return result;
	}

	public Student findByStdid(int stdid) {
		SqlSession session = null;
		session = factory.openSession();
		ScoreMapper mapper = session.getMapper(ScoreMapper.class);
		
		Student p = mapper.findByStdid(stdid);
		
		session.close();
		return p;
	}

	public List<Student> selectAll() {
		SqlSession session = null;
		session = factory.openSession();
		ScoreMapper mapper = session.getMapper(ScoreMapper.class);
		
		List<Student> list = mapper.selectAll();
		
		session.close();
		
		return list;
	}

	public int updateScore(Student s) {
		SqlSession session = null;
		session = factory.openSession();
		ScoreMapper mapper = session.getMapper(ScoreMapper.class);
		
		int result = mapper.updateScore(s);
		
		session.commit();
		session.close();
		
		return result;
	}

	public int deleteScore(int stdid) {
		SqlSession session = null;
		session = factory.openSession();
		ScoreMapper mapper = session.getMapper(ScoreMapper.class);
		
		int result = mapper.deleteScore(stdid);
		
		session.commit();
		session.close();
		
		return result;
	}
}

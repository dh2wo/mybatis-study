package net.kdigital.bmiproject.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import net.kdigital.bmiproject.vo.MemberVO;

public class BMIDAO {
	
	SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	public int memberAdd(MemberVO member) {
		SqlSession session = null;
		session = factory.openSession();
		BMIMapper mapper = session.getMapper(BMIMapper.class);
		
		int result = mapper.memberAdd(member);
		
		session.commit();
		session.close();
		return result;
	}

	public MemberVO selectByID(String id) {
		SqlSession session = null;
		session = factory.openSession();
		BMIMapper mapper = session.getMapper(BMIMapper.class);
		
		MemberVO member = mapper.selectByID(id);
		
		session.close();
		return member;
	}
	
	public List<MemberVO> selectByNR(Map<String, Object> map) {
		SqlSession session = null;
		session = factory.openSession();
		BMIMapper mapper = session.getMapper(BMIMapper.class);
		
		List<MemberVO> list = mapper.selectByNR(map);
				
		session.close();
		return list;
	}
	
	public int updateMember(MemberVO member) {
		SqlSession session = null;
		session = factory.openSession();
		BMIMapper mapper = session.getMapper(BMIMapper.class);
		
		int result = mapper.updateMember(member);
		
		session.commit();
		session.close();
		return result;
	}
	
	public List<MemberVO> selectAll() {
		SqlSession session = null;
		session = factory.openSession();
		BMIMapper mapper = session.getMapper(BMIMapper.class);
		
		List<MemberVO> list = mapper.selectAll();
		
		session.close();
		return list;
	}
	
	public int deleteFlagOnOff(Map<String, Object> map) {
		SqlSession session = null;
		session = factory.openSession();
		BMIMapper mapper = session.getMapper(BMIMapper.class);
		
		int result = mapper.deleteFlagOnOff(map);
		
		session.commit();
		session.close();
		return result;
	}

	public int removeMember(String id) {
		SqlSession session = null;
		session = factory.openSession();
		BMIMapper mapper = session.getMapper(BMIMapper.class);
		
		int result = mapper.removeMember(id);
		
		session.commit();
		session.close();
		return result;
	}
	
//	public List<MemberVO> selectByName(String name) {
//	SqlSession session = null;
//	session = factory.openSession();
//	BMIMapper mapper = session.getMapper(BMIMapper.class);
//	
//	List<MemberVO> list = mapper.selectByName(name);
//	
//	session.close();
//	return list;
//}
}

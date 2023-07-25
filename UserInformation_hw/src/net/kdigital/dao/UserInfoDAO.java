package net.kdigital.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import net.kdigital.vo.UsrInfo;

public class UserInfoDAO {
	
	SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	public List<UsrInfo> selectAllD() {
		SqlSession session = null;
		session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);

		List<UsrInfo> list = mapper.selectAll();
		
		return list;
	}
	
	public UsrInfo selectByIDD(String id) {
		SqlSession session = null;
		session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		UsrInfo ui = mapper.selectByID(id);
		
		return ui;
	}
}

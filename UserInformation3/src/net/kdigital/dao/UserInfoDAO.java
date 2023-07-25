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

		List<UsrInfo> list = mapper.selectUsrInfo();
		
		session.close();
		return list;
	}

	public UsrInfo selectByIDD(String id) {
		SqlSession session = null;
		session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		UsrInfo ui =  mapper.selectByID(id);
		
		session.close();
		return ui;
	}

	public int deleteUiD(String id) {
		SqlSession session = null;
		session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		int result = mapper.deleteUi(id);
		
		if(result == 1) {
			session.commit();
		}
		
		session.close();
		return result;
	}

	public int insertUiD(UsrInfo ui) {
		SqlSession session = null;
		session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		int result = mapper.insertUi(ui);
		
		if(result == 1) {
			session.commit();
		}
		
		session.close();
		return result;
	}

	public int updateUiD(UsrInfo ui) {
		SqlSession session = null;
		session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		int result = mapper.updateUi(ui);
		
		if(result == 1) {
			session.commit();
		}
		
		session.close();
		return result;
	}
	
	
}

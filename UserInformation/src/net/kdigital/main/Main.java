package net.kdigital.main;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import net.kdigital.dao.MybatisConfig;
import net.kdigital.dao.UserMapper;
import net.kdigital.vo.UsrInfo;

public class Main {

	public static void main(String[] args) {
		
		SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);

		List<UsrInfo> list = mapper.selectUsrInfo();
		//반복문
		for(UsrInfo u : list) {
			System.out.println(u);
		}
	}
}

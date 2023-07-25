package net.kdigital.dao;

import java.util.List;

import net.kdigital.vo.UsrInfo;

public interface UserMapper {
	//여러개 List로 받기 //UserMapper.xml -> selectUsrInfo()
	public List<UsrInfo> selectUsrInfo(); 
	
	public int insertUi(UsrInfo ui);
	
	public UsrInfo selectByID(String id);
	
	public int updateUi(UsrInfo ui);

	public int deleteUi(String id);
	
}

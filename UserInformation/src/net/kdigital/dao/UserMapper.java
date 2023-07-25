package net.kdigital.dao;

import java.util.List;

import net.kdigital.vo.UsrInfo;

public interface UserMapper {
	public List<UsrInfo> selectUsrInfo(); 
	//여러개 List로 받기 //UserMapper.xml -> selectUsrInfo()
}

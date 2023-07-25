package net.kdigital.dao;

import java.util.List;

import net.kdigital.vo.UsrInfo;

public interface UserMapper {

	public List<UsrInfo> selectAll();
	
	public UsrInfo selectByID(String id);
}

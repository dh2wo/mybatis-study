package net.kdigital.service;

import java.util.List;

import net.kdigital.dao.UserInfoDAO;
import net.kdigital.vo.UsrInfo;

public class UserInfoService {

	UserInfoDAO dao = new UserInfoDAO();
	
	public List<UsrInfo> selectAllS(){
		List<UsrInfo> list = dao.selectAllD();
		return list;
	}
	
	public UsrInfo selectByIDS(String id) {
		UsrInfo ui = dao.selectByIDD(id);
		return ui;
	}
}

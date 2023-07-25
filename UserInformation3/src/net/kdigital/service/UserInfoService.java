package net.kdigital.service;

import java.util.List;

import net.kdigital.dao.UserInfoDAO;
import net.kdigital.vo.UsrInfo;

public class UserInfoService {

	UserInfoDAO dao = new UserInfoDAO();
	
	public List<UsrInfo> selectAllS() {
		List<UsrInfo> list = dao.selectAllD();
		return list;
	}

	public UsrInfo selectByIDS(String id) {
		return dao.selectByIDD(id);
	}

	public int deleteUiS(String id) {
		int result = dao.deleteUiD(id);
		return result;
	}

	public int insertUiS(UsrInfo ui) {
		int result = dao.insertUiD(ui);
		return result;
	}

	public int updateUiS(UsrInfo ui) {
		int result = dao.updateUiD(ui);
		return result;
	}
	
}

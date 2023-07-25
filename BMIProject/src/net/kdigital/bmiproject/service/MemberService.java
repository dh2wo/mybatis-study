package net.kdigital.bmiproject.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.kdigital.bmiproject.dao.BMIDAO;
import net.kdigital.bmiproject.vo.MemberVO;

public class MemberService {

	BMIDAO dao = new BMIDAO();

	public int memberAdd(MemberVO member) {
		int result = dao.memberAdd(member);
		return result;
	}

	public MemberVO selectByID(String id) {
		MemberVO member = dao.selectByID(id);
		return member;
	}

	public List<MemberVO> selectByNR(String str, int num) {
		// 0이면 이름, 1이면 BMI결과
		// hashmap<K, V>
		Map<String, Object> map = new HashMap<>();
		if(num == 0) {
			map.put("name", str);
			map.put("result", null);
		}
		else{
			map.put("name", null);
			map.put("result", str);
		}
		List<MemberVO> list = dao.selectByNR(map);
		return list;
	}
	
	public List<MemberVO> selectAll() {
		List<MemberVO> list = dao.selectAll();
		return list;
	}

	public int updateMember(MemberVO member) {
		int result = dao.updateMember(member);
		return result;
	}
	
	public int deleteFlagOnOff(String id, int deleteFlag) {
		//map 생성
		Map<String, Object> map = new HashMap<>();
		//id와 바꿀 deleteFlag값을 map에 저장.
		map.put("id", id);
		map.put("deleteFlag", deleteFlag);
		
		int result = dao.deleteFlagOnOff(map);
		return result;
	}

	public int removeMember(String id) {
		int result = dao.removeMember(id);
		return result;
	}

//	public List<MemberVO> selectByName(String name) {
//		List<MemberVO> list = dao.selectByName(name);
//		return list;
//	}
}

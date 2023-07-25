package net.kdigital.bmiproject.dao;

import java.util.List;
import java.util.Map;

import net.kdigital.bmiproject.vo.MemberVO;

public interface BMIMapper {
	public int memberAdd(MemberVO member);

	public MemberVO selectByID(String id);

	public List<MemberVO> selectByNR(Map<String, Object> map);	

	public int updateMember(MemberVO member);

	public List<MemberVO> selectAll();

	public int deleteFlagOnOff(Map<String, Object> map);

	public int removeMember(String id);

//	public List<MemberVO> selectByName(String name);

}

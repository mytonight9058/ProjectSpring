package com.khrd.service;

import java.util.List;

import com.khrd.domain.MemberVo;

public interface MemberService {

	public void insert(MemberVo vo);
	public List<MemberVo> list();
	public void selectById(String userid);
	public void update(MemberVo vo);
	public void delete(MemberVo vo);
	
}

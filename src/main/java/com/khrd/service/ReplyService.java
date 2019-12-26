package com.khrd.service;

import java.util.List;

import com.khrd.domain.Criteria;
import com.khrd.domain.ReplyVo;


public interface ReplyService {

	public void regist(ReplyVo vo);
	public void modify(ReplyVo vo);
	public void remove(int rno);
	public List<ReplyVo> listAll(int bno);
	public List<ReplyVo> listCri(int bno, Criteria cri);
	public int listCriTotalCount(int bno);
	
	
}

package com.khrd.persistence;

import java.util.List;

import com.khrd.domain.Criteria;
import com.khrd.domain.ReplyVo;

public interface ReplyDAO {
	
	public void create(ReplyVo vo);
	public List<ReplyVo> list( int bno);
	public void delete(int bno);
	public void update(ReplyVo vo);
	
	public List<ReplyVo> listCri(int bno, Criteria cri);
	public int listCriTotalCount(int bno);
	public int getBno(int rno);
}

package com.khrd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.khrd.domain.Criteria;
import com.khrd.domain.ReplyVo;
import com.khrd.persistence.BoardDAO;
import com.khrd.persistence.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDAO dao;
	
	@Autowired
	private BoardDAO boardDao;
	
	
	@Override
	@Transactional // 써줘야 안닫김
	public void regist(ReplyVo vo) {
	
		dao.create(vo);
		boardDao.updateReplyCount(1, vo.getBno());
	}

	@Override
	public void modify(ReplyVo vo) {
		dao.update(vo);
	}

	@Override
	@Transactional
	public void remove(int rno) {
		
		boardDao.updateReplyCount(-1, dao.getBno(rno));	
		
		dao.delete(rno);


	}

	@Override
	public List<ReplyVo> listAll(int bno) {
		
		System.out.println( "-------------service-----------------" +  bno );
		
		return dao.list(bno);
				
	}

	@Override
	public List<ReplyVo> listCri(int bno, Criteria cri) {
		
		return dao.listCri(bno, cri);
	}

	@Override
	public int listCriTotalCount(int bno) {
		
		return dao.listCriTotalCount(bno);
	}



}

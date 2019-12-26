package com.khrd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.khrd.domain.BoardVo;
import com.khrd.domain.Criteria;
import com.khrd.domain.SearchCriteria;
import com.khrd.persistence.BoardDAO;


@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO dao;
	
	@Override
	@Transactional  // 커넥션 열고 닫기   .  aop 구현
	public void regist(BoardVo vo) {
		
		dao.insert(vo);
		
		for(String file: vo.getFiles()) {
			dao.addAttach(file);
		}

	}

	@Override
	public List<BoardVo> listAll() {
	
		return dao.listAll();
	}

	@Override
	public void modify(BoardVo vo) {
		dao.modify(vo);
	}

	@Override
	public void remove(int bno) {
		dao.delete(bno);

	}

	@Override
	public BoardVo read(int bno) {
		
		return dao.selectByNo(bno);
	}
	
	@Override
	public List<BoardVo> listCriteria(Criteria cri) {
		
		return dao.listCriteria(cri);
	}

	@Override
	public int listCount() {
		
		return dao.listCount();
	}

	@Override
	public List<BoardVo> listSearch(SearchCriteria cri) {
	
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) {
	
		return dao.listSearchCount(cri);
	}

	@Override
	public BoardVo selectByNo(int bno) {
		
		return dao.selectByNo(bno);
	}
	

}

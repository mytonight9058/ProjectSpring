package com.khrd.service;

import java.util.List;

import com.khrd.domain.BoardVo;
import com.khrd.domain.Criteria;
import com.khrd.domain.SearchCriteria;

public interface BoardService {

	public void regist(BoardVo vo);
	public List<BoardVo> listAll();
	public void modify(BoardVo vo);
	public void remove(int bno);
	public BoardVo read(int bno);
	public List<BoardVo> listCriteria(Criteria cri);
	public int listCount();
	
	public List<BoardVo> listSearch(SearchCriteria cri);
	public int listSearchCount(SearchCriteria cri);
	public BoardVo selectByNo(int bno);
	
}

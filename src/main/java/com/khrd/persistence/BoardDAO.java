package com.khrd.persistence;

import java.util.List;



import com.khrd.domain.BoardVo;
import com.khrd.domain.Criteria;
import com.khrd.domain.SearchCriteria;


public interface BoardDAO {

	public void insert(BoardVo vo);
	public List<BoardVo> listAll();
	public BoardVo selectById(int bno);
	public void modify(BoardVo vo);
	public void delete(int bno);
	public List<BoardVo> listPage(int page, int perPage);
	public List<BoardVo> listCriteria(Criteria cri);
	public int listCount();
	public List<BoardVo> listSearch(SearchCriteria cri);
	public int listSearchCount(SearchCriteria cri);
	public void updateReplyCount (int amount, int bno);
	public void addAttach(String fullname);
	public BoardVo selectByNo(int bno);
	
}

package com.khrd.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.khrd.domain.BoardVo;
import com.khrd.domain.Criteria;
import com.khrd.domain.SearchCriteria;



@Repository
public class BoardDAOImpl implements BoardDAO{

	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "mappers.BoardMapper";


	@Override
	public void insert(BoardVo vo) {
		sqlSession.insert(namespace + ".insert",vo);
		
	}

	@Override
	public List<BoardVo> listAll() {
		
		return sqlSession.selectList(namespace +".listAll");
	}

	@Override
	public BoardVo selectById(int bno) {

		return sqlSession.selectOne(namespace + ".selectById", bno);
	}

	@Override
	public void modify(BoardVo vo) {
		sqlSession.update(namespace + ".modify", vo);
		
	}

	@Override
	public void delete(int bno) {
		
		sqlSession.delete(namespace + ".delete", bno);
	}

	@Override
	public List<BoardVo> listPage(int page, int perPage) {
		page = (page -1) * perPage;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", page);
		map.put("perPage", perPage);
		
		return sqlSession.selectList(namespace + ".listPage", map);
	}

	@Override
	public List<BoardVo> listCriteria(Criteria cri) {
		
		return sqlSession.selectList(namespace + ".listCri", cri);
	}

	@Override
	public int listCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".listCount");
	}

	@Override
	public List<BoardVo> listSearch(SearchCriteria cri) {
		
		return sqlSession.selectList(namespace + ".listSearch",cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) {

		return sqlSession.selectOne(namespace+ ".listSearchCount",cri);
	}

	@Override
	public void updateReplyCount(int amount, int bno) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("amount", amount);
		map.put("bno", bno);
		sqlSession.update(namespace+ ".updateReplyCount",map);
		
	}

	@Override
	public void addAttach(String fullname) {
	
		sqlSession.insert(namespace+ ".addAttach",fullname);
	}

	@Override
	public BoardVo selectByNo(int bno) {
		return sqlSession.selectOne(namespace+ ".selectByNo",bno);
		
	}
	
}
	
	
	



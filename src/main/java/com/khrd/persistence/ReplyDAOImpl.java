package com.khrd.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.khrd.domain.Criteria;
import com.khrd.domain.ReplyVo;


@Repository
public class ReplyDAOImpl implements ReplyDAO{

	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "mappers.ReplyMapper";



	@Override
	public List<ReplyVo> list(int bno) {
	
		System.out.println( "-------------dao-----------------" +  bno );
		
		return sqlSession.selectList(namespace +".list",bno);
	}

	@Override
	public void create(ReplyVo vo) {
		sqlSession.insert(namespace + ".create",vo);
		
	}

	@Override
	public void delete(int bno) {
		sqlSession.delete(namespace + ".delete",bno);
		
	}

	@Override
	public void update(ReplyVo vo) {
		sqlSession.update(namespace + ".update",vo);
		
	}

	@Override
	public List<ReplyVo> listCri(int bno, Criteria cri) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bno",bno);
		map.put("cri", cri);
		
		return sqlSession.selectList(namespace + ".listCri",map);
		
	}

	@Override
	public int listCriTotalCount(int bno) {
		
		return sqlSession.selectOne(namespace + ".listCriTotalCount",bno);
	}

	@Override
	public int getBno(int rno) {
	
		return sqlSession.selectOne(namespace+ ".getBno",rno);
	}

	
	}
	
	
	



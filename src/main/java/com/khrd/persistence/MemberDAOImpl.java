package com.khrd.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.khrd.domain.MemberVo;


@Repository
public class MemberDAOImpl implements MemberDao{

	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "mappers.MemberMapper";
	
	public void insert(MemberVo vo) {
		
		sqlSession.insert(namespace + ".insert",vo);
			
	}

	@Override
	public List<MemberVo> list() {
		return sqlSession.selectList(namespace +".list");
	}


	@Override
	public void selectById(String userid) {
		sqlSession.delete(namespace +".selectById", userid);

	}

	@Override
	public void update(MemberVo vo) {
		sqlSession.delete(namespace +".update", vo);
		
	}

	@Override
	public void delete(MemberVo vo) {
		sqlSession.delete(namespace +".delete", vo);
		
	}
	
}

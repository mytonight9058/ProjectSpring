package com.khrd.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.khrd.domain.Project;

@Repository
public class ProjectDaoImpl implements ProjectDao{

	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "mappers.ProjectMapper";

	@Override
	public List<Project> list() {
		
		return sqlSession.selectList(namespace +".list");
	}

	@Override
	public void insert(Project project) {
		sqlSession.insert(namespace +".insert",project);
		
	}

	@Override
	public void update(Project project) {
		sqlSession.update(namespace +".update",project);
		
	}

	@Override
	public void delete(int no) {
		sqlSession.delete(namespace +".delete",no);
		
	}

	@Override
	public Project SelectByNo(int no) {
		return sqlSession.selectOne(namespace +".SelectByNo",no);
		
		
	}
	

}

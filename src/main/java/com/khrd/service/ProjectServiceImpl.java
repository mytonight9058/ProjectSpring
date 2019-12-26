package com.khrd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.khrd.domain.Project;
import com.khrd.persistence.ProjectDao;


@Service
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectDao dao;
	

	@Override
	@Transactional 
	public List<Project> list() {
		return dao.list();
	}

	@Override
	public void insert(Project project) {
		
		dao.insert(project);
		
	}

	@Override
	public void update(Project project) {
		dao.update(project);
		
	}

	@Override
	public void delete(int no) {
		dao.delete(no);
		
	}

	@Override
	public Project SelectByNo(int no) {
		return dao.SelectByNo(no);
	}


	
	
}

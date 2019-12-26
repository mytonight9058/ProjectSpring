package com.khrd.service;

import java.util.List;

import com.khrd.domain.Project;

public interface ProjectService {

	public List<Project> list();
	public void insert(Project project);
	public void update(Project project);
	public void delete(int no);
	public Project SelectByNo(int no);
	
}

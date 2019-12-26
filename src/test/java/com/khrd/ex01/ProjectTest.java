package com.khrd.ex01;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.khrd.domain.Project;

import com.khrd.persistence.ProjectDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ProjectTest {

	@Autowired
	private ProjectDao dao;
		
//	@Test
	public void testListAll() {
		
		dao.list();
				
	}
//	@Test
	public void testInsert() {
		
		Project vo = new Project();
		vo.setNo(2);
		vo.setEnd_date(new Date());
		vo.setStart_date(new Date());
		vo.setTitle("d");
		vo.setState("a");
		vo.setContent("cc");

		
		
		dao.insert(vo);
	}
	
//	@Test
	public void testSelectById() {
		dao.SelectByNo(1);
	}
	
//	@Test
	public void modify() {
		
		Project vo = new Project();
		vo.setNo(1);
		vo.setEnd_date(new Date());
		vo.setStart_date(new Date());
		vo.setTitle("s");
		vo.setState("b");
		vo.setContent("xx");
		
		
		dao.update(vo);

	}
	@Test
	public void testDelete() {
		
		dao.delete(1);
	}

	
	
	
}

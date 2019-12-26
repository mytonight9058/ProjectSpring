package com.khrd.ex01;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.khrd.domain.BoardVo;
import com.khrd.domain.Criteria;
import com.khrd.domain.SearchCriteria;
import com.khrd.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardTest {

	@Autowired
	private BoardDAO dao;
	
//	@Test
	public void testListAll() {

		/*
		 * List<BoardVo> list = dao.list(); for(BoardVo vo : list) {
		 * System.out.println(vo); }
		 */
		
		dao.listAll();
		
		
	}
//	@Test
	public void testInsert() {
		
		BoardVo vo = new BoardVo();
		
		vo.setTitle("5");
		vo.setContent("6");
		vo.setWriter("7");
		
		dao.insert(vo);
	}
	
//	@Test
	public void testSelectById(int bno) {
		
		dao.selectById(2);
	}
	
	@Test
	public void modify() {
		
		BoardVo vo = new BoardVo();
		
		vo.setTitle("d");
		vo.setContent("s");
		vo.setWriter("1");
		
		dao.modify(vo);
	}
//	@Test
	public void testDelete(int bno) {
		
		dao.delete(2);
	}
//	@Test
	public void testPage() {
		
		dao.listPage(2, 10);
	}
	
//	@Test
	public void testListCri() {
		
		Criteria cri = new Criteria();
		
		cri.setPage(2);
		cri.setPerPageNum(10);
		
		dao.listCriteria(cri);
	
		
	}
	
//	@Test
	public void testListSearch() {
		
		SearchCriteria cri = new SearchCriteria();
	
		cri.setPage(2);
		cri.setPerPageNum(10);
		cri.setKeyword("2");
		cri.setSearchType("t");
		dao.listSearch(cri);
			
	}
	
	
};

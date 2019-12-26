package com.khrd.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.khrd.domain.BoardVo;
import com.khrd.domain.Criteria;

import com.khrd.domain.Project;
import com.khrd.domain.SearchCriteria;
import com.khrd.service.ProjectService;

@Controller
@RequestMapping("/project/*")
public class ProjectController {

	
	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	ProjectService service;
	
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public void insert(Project vo) {
		
		logger.info("-----------------------------------------------------get----------------------------------------"+ vo);
	}
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertPost(Project vo) {
		
		logger.info("-----------------------------------------------------post----------------------------------------" + vo);
		
		service.insert(vo);		
		
		return "redirect:/project/list";
		
	}

	@RequestMapping(value = "list" , method= RequestMethod.GET)
	public void registAll(Model model) {
		logger.info("--------------------------list-----------------------------------------");
		List<Project> list = service.list();
		model.addAttribute("list",list);
		
	}

	
	@RequestMapping(value = "update" , method= RequestMethod.POST)
	public String modify(Project vo,Model model) {
		
		logger.info("----------------modify- Post---------------"+vo);
		
		service.update(vo);
		model.addAttribute("boardVo",vo);
		
		return null;
	}	
	


	
	@RequestMapping(value = "delete" , method= RequestMethod.GET)
	public String removePage(int no,Model model,Criteria cri) {
		logger.info("----------------remove----------------"+no);
		service.delete(no);
		model.addAttribute("cri",cri);
		
		return null;
	}
	
	
	@RequestMapping(value = "detail" , method= RequestMethod.GET)
	public void readPage(int no, SearchCriteria cri, Model model) {
		logger.info("--------------------------readPage-----------------------------------------" + no);
		
		
		Project vo = service.SelectByNo(no);
		model.addAttribute("Project",vo);
		model.addAttribute("cri",cri);
		
	}
	
	
	@RequestMapping(value = "modify" , method= RequestMethod.GET)
	public String modifyGet(int no,Model model,Criteria cri) {
		logger.info("--------------------------modify-----------------------------------------" + no);
		
		Project vo = service.SelectByNo(no);
		model.addAttribute("Project",vo);
		model.addAttribute("cri",cri);
		return "/Project/modify?page="+cri.getPage();
	}
	
	@RequestMapping(value = "modify" , method= RequestMethod.POST)
	public String modifyPost(Project vo,Model model) {
		
		logger.info("----------------modify- Post---------------"+vo);
		
		service.update(vo);
		model.addAttribute("Project",vo);
		
		return "redirect:/project/detail?bno="+vo.getNo();
	}	
	

	

	
	
}

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
import com.khrd.domain.PageMaker;
import com.khrd.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardService service;
	
	@RequestMapping(value = "register" , method= RequestMethod.GET)
	public void registGet() {

	logger.info("-----------------------------------------------------get----------------------------------------");
		
	}
	@RequestMapping(value = "register" , method= RequestMethod.POST)
	public String registPost(BoardVo vo) {
		
		logger.info("--------------------------post-----------------------------------------");
		logger.info(vo.toString());
		
		service.regist(vo);
		
		return "redirect:/board/listAll";
	}	
	
	@RequestMapping(value = "listAll" , method= RequestMethod.GET)
	public void registAll(Model model) {
		logger.info("--------------------------listAll-----------------------------------------");
		List<BoardVo> list = service.listAll();
		model.addAttribute("list",list);
				
	}
	
	@RequestMapping(value = "listCri" , method= RequestMethod.GET)
	public void listCri(Criteria cri,Model model) {
		logger.info("--------------------------listCri----------------------------------------- "+ cri);
		List<BoardVo> list = service.listCriteria(cri);
		model.addAttribute("list",list);
		
	}
	
	@RequestMapping(value = "listPage" , method= RequestMethod.GET)
	public void listPage(Criteria cri,Model model) {
		logger.info("--------------------------listPage----------------------------------------- "+ cri);
		List<BoardVo> list = service.listCriteria(cri);
				
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCount());
		model.addAttribute("list",list);
		model.addAttribute("pageMaker",pageMaker);
	}
		
	@RequestMapping(value = "read" , method= RequestMethod.GET)
	public void read(int bno,Model model) {
		logger.info("--------------------------read-----------------------------------------" + bno);
			
		BoardVo vo = service.read(bno);
		model.addAttribute("boardVo",vo);
	}
	
	@RequestMapping(value = "readPage" , method= RequestMethod.GET)
	public void readPage(int bno, Criteria cri, Model model) {
		logger.info("--------------------------readPage-----------------------------------------" + bno);
				
		BoardVo vo = service.read(bno);
		model.addAttribute("boardVo",vo);
		model.addAttribute("cri",cri);
		
	}
	
	@RequestMapping(value = "modify" , method= RequestMethod.GET)
	public String pass(int bno,Model model,Criteria cri) {
		logger.info("--------------------------modify-----------------------------------------" + bno);
		
		BoardVo vo = service.read(bno);
		model.addAttribute("boardVo",vo);
		model.addAttribute("cri",cri);
		return "/board/modify?page="+cri.getPage();
	}
	
	@RequestMapping(value = "modifyPage" , method= RequestMethod.GET)
	public String passPage(int bno,Model model,Criteria cri) {
		logger.info("--------------------------modify-----------------------------------------" + bno);
		
		BoardVo vo = service.read(bno);
		model.addAttribute("boardVo",vo);
		model.addAttribute("cri",cri);
		return "/board/modifyPage?page="+cri.getPage();
	}
	
	@RequestMapping(value = "modify" , method= RequestMethod.POST)
	public String modify(BoardVo vo,Model model) {
		
		logger.info("----------------modify- Post---------------"+vo);
		
		service.modify(vo);
		model.addAttribute("boardVo",vo);
		
		return "redirect:/board/read?bno="+vo.getBno();
	}	
	
	@RequestMapping(value = "modifyPage" , method= RequestMethod.POST)
	public String modifyPage(BoardVo vo,Model model,Criteria cri) {
		
		logger.info("----------------modify- Post---------------"+vo);
		
		service.modify(vo);
		model.addAttribute("boardVo",vo);
		model.addAttribute("cri",cri);
		return "redirect:/board/read?bno="+vo.getBno();
	}
	
//	
//	@RequestMapping(value = "remove" , method= RequestMethod.GET)
//	public String remove(int bno,Model model) {
//		logger.info("----------------remove----------------"+bno);
//		service.remove(bno);
//		return "redirect:/board/listAll";
//	}

	
	@RequestMapping(value = "removePage" , method= RequestMethod.GET)
	public String removePage(int bno,Model model,Criteria cri) {
		logger.info("----------------remove----------------"+bno);
		service.remove(bno);
		model.addAttribute("cri",cri);
		return "redirect:/board/listPage?page="+cri.getPage();
	}

}

package com.khrd.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.khrd.domain.BoardVo;

import com.khrd.domain.PageMaker;
import com.khrd.domain.SearchCriteria;
import com.khrd.service.BoardService;
import com.khrd.util.UploadFileUtils;

@Controller
@RequestMapping("/sboard/*")
public class SerchBoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardService service;
	
	@Resource(name = "uploadPath")  // bean 아이디 값으로 주입 받음
	private String uploadPath;
	
	
	@RequestMapping(value = "listPageS" , method= RequestMethod.GET)
	public void listPage(Model model,SearchCriteria cri) {
		logger.info("--------------------------listPage----------------------------------------- "+ cri);
		List<BoardVo> list = service.listSearch(cri);
		
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));
		model.addAttribute("list",list);
		model.addAttribute("pageMaker",pageMaker);
		model.addAttribute("cri",cri);
	}
	
	
	@RequestMapping(value = "registerS" , method= RequestMethod.GET)
	public void registGet() {

	logger.info("-----------------------------------------------------get----------------------------------------");
		
	}
	@RequestMapping(value = "registerS" , method= RequestMethod.POST)
	public String registPost(BoardVo vo, List<MultipartFile> imageFiles) throws IOException, Exception {
		
		logger.info("--------------------------post-----------------------------------------");
		logger.info(vo.toString());
		
		ArrayList<String> files = new ArrayList<String>(); 
		
		for(MultipartFile file: imageFiles) {
			logger.info(file.getOriginalFilename());
			logger.info(file.getSize()+"");
			
			String savedName = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
			
			files.add(savedName);
			
		}
		
		vo.setFiles(files);
		
		service.regist(vo);
		
		return "redirect:/sboard/listPageS";
	}	
	
	@RequestMapping(value = "readS" , method= RequestMethod.GET)
	public void read(int bno,Model model) {
		logger.info("--------------------------read-----------------------------------------" + bno);
			
		BoardVo vo = service.read(bno);
		model.addAttribute("boardVo",vo);
	}
	
	@RequestMapping(value = "readPageS" , method= RequestMethod.GET)
	public void readPage(int bno, SearchCriteria cri, Model model) {
		logger.info("--------------------------readPage-----------------------------------------" + bno);

		BoardVo vo = service.selectByNo(bno);
		logger.info(vo.toString());
		
		logger.info("-------------------fuck!!!!!!!!!!-----------------------------" + vo);
		
		
		
		model.addAttribute("boardVo",vo);
		model.addAttribute("cri",cri);
		
	}
	
	
	
	
	@RequestMapping(value = "removePageS" , method= RequestMethod.GET)
	public String removePage(int bno,Model model,SearchCriteria cri) {
		logger.info("----------------remove----------------"+bno);
		service.remove(bno);
		model.addAttribute("cri",cri);
		return "redirect:/sboard/listPageS?page="+cri.getPage();
	}
	
	

	@RequestMapping(value="modifyPageSS", method=RequestMethod.GET)
	public void modifyPageGet(int bno, SearchCriteria cri, Model model) {
		logger.info("-----------------------modifyPage GET-------------");
		BoardVo vo = service.read(bno);
		model.addAttribute("boardVO", vo);
		model.addAttribute("cri", cri);
	}
	
	@RequestMapping(value="modifyPageSS", method = RequestMethod.POST)
	public String modifyPagePOST(BoardVo vo, SearchCriteria cri, Model model) {
		logger.info("-------------------- modifyPage POST --------------");
		logger.info(vo.toString());
		
		service.modify(vo);
		
		model.addAttribute("bno", vo.getBno());
		model.addAttribute("page", cri.getPage());
		model.addAttribute("searchType", cri.getSearchType());
		model.addAttribute("keyword", cri.getKeyword());
		
		
		return "redirect:/sboard/modifyS?bno="+vo.getBno();
	}
	
	@RequestMapping(value = "modifyS" , method= RequestMethod.GET)
	public String pass(int bno,Model model,SearchCriteria cri) {
		logger.info("--------------------------modify-----------------------------------------" + bno);
		
		BoardVo vo = service.read(bno);
		model.addAttribute("boardVo",vo);
		model.addAttribute("cri",cri);
		return "/sboard/modifyS?page="+cri.getPage();
				
	}
	
	@RequestMapping(value = "modifyS" , method= RequestMethod.POST)
	public String modify(BoardVo vo,Model model,SearchCriteria cri) {
		
		logger.info("----------------modify- Post---------------"+vo);
		
		service.modify(vo);
		model.addAttribute("boardVo",vo);
		model.addAttribute("cri",cri);
		return "redirect:/sboard/modifyS?bno="+vo.getBno();
	}
	
	
	@RequestMapping(value = "modifyPageS" , method= RequestMethod.GET)
	public String passPage(int bno,Model model,SearchCriteria cri) {
		logger.info("--------------------------modify-----------------------------------------" + bno);
		
		BoardVo vo = service.read(bno);
		model.addAttribute("boardVo",vo);
		model.addAttribute("cri",cri);
		return "/sboard/modifyPageS?page="+cri.getPage();
	}
	

	
	@RequestMapping(value = "modifyPageS" , method= RequestMethod.POST)
	public String modifyPage(BoardVo vo,Model model,SearchCriteria cri) {
		
		logger.info("----------------modify--Post---------------"+vo);
		
		service.modify(vo);
		model.addAttribute("boardVo",vo);
		model.addAttribute("cri",cri);
		return "/sboard/readS?bno="+vo.getBno();
	}
	
	
	
	
}

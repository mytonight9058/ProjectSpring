package com.khrd.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.khrd.domain.MemberVo;
import com.khrd.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberService service;
	
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public void insert(MemberVo vo) {
		
		logger.info("-----------------------------------------------------get----------------------------------------");
	}
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public void insertPost(MemberVo vo) {
		
		logger.info("-----------------------------------------------------get----------------------------------------");
		
		service.insert(vo);		
	}

	@RequestMapping(value = "list" , method= RequestMethod.GET)
	public void registAll(Model model) {
		logger.info("--------------------------list-----------------------------------------");
		List<MemberVo> list = service.list();
		model.addAttribute("list",list);
				
	}
	
	
	
}

package com.khrd.controller;

import java.awt.PageAttributes.MediaType;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.spi.http.HttpHandler;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.khrd.util.UploadFileUtils;

@Controller
@RequestMapping("/upload/*")
public class UploadController {

	@Resource(name ="uploadPath") // 아이디로 받음  (서블릿 beans) 
	private String uploadPath;
	
	
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	

	@RequestMapping(value = "displayFile", method = RequestMethod.GET)
	public ResponseEntity<byte[]> displayFile(String filename){
		ResponseEntity<byte[]> entity = null;
		
		logger.info("filename:" +filename);
		try {
			String formatName = filename.substring(filename.lastIndexOf(".")+ 1);
			org.springframework.http.MediaType type = null;
			if(formatName.equalsIgnoreCase("jpg")) {
				type =  org.springframework.http.MediaType.IMAGE_JPEG;	
			}else if(formatName.equalsIgnoreCase("png")) {
				type =  org.springframework.http.MediaType.IMAGE_PNG;
			}else if(formatName.equalsIgnoreCase("gif")) {
				type =  org.springframework.http.MediaType.IMAGE_GIF;
			}
						
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(type);
			// 파일을 읽어들임
			InputStream in = new FileInputStream(uploadPath + "/" +filename);
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers,HttpStatus.CREATED);
			
			in.close(); // inputstream은 사용 완료 후  close 해줘야 다른 곳에서 파일 접근 가능
			
			
			
		}catch(Exception e) {
			
		}
			
		return entity;
	}
	
	
	
	
	
}



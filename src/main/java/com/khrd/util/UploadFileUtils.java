package com.khrd.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {

	// upload 함수 = 원본 업로드, 썸네일 업로드, 년 월 일 폴더도 만듦
	// originalFileName 파일 이름
	// data : 이미지 데이타
	// return 값 : thumbnail 파일명
	
	
	public static String uploadFile(String uploadPath, String originalFileName, byte[] data) throws Exception {
		
		// 원본 업로드		
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() + "_" + originalFileName;		
		
		String datePath = calculatorPath(uploadPath); // 년 월 일 폴더 만든 후 경로 (/2019/05/01) 리턴

		
		File newFile = new File(uploadPath + datePath + "/" +savedName);
		FileCopyUtils.copy(data, newFile);
		
		// 썸네일 업로드
		
		String thumbName = makeThumbnail(uploadPath + datePath, savedName);

		
		return datePath + thumbName; //  /년/월/일/ 작은 이미지 
		
	}

	private static String makeThumbnail(String uploadPath, String filename) throws Exception {
		
		// BufferedImage : 실제 이미지가 아닌 메모리상의 이미지를 의미하는 객체
		
		//원본 이미지 가져와서 메모리에 넣음
		
		BufferedImage sourceImg = ImageIO.read(new File(uploadPath + "/"+ filename));
		
		//작은 이미지 용으로 리사이징 시킴. 높이 100을 기준으로 가로는 자동 조정
		
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT,100);
		
		// 작은 이미지 데이타가 들어갈 파일 만들기
		
		String thumbnailName = uploadPath + "/" + "s_" + filename;	
//		String thumbnailName = uploadPath + filename;	
		File newFile = new File(thumbnailName);
		
		// 파일 확장자
		
		String formatName = filename.substring(filename.lastIndexOf(".")+1);
		
		// 작은 이미지 데이타를 작은 이미지 파일에 복사 시킴. 파일 완성
		
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
		
		return thumbnailName.substring(uploadPath.length()); // thumbnail 이미지 파일명을 리턴
	}
	
	private static String calculatorPath(String uploadPath) {
		
		Calendar cal = Calendar.getInstance();
		String yearPath = "/" + cal.get(Calendar.YEAR);
		String monthPath = String.format("%s/%02d", yearPath ,cal.get(Calendar.MONTH)+1);  // %02d 달 두자리 05월  
		String datePath = String.format("%s/%02d",monthPath, cal.get(Calendar.DATE)); // /2019/05/01
			
		makeDir(uploadPath,yearPath,monthPath,datePath);
		return datePath; // c:/zzz/upload/2019/05/01
	}
	//paths = {"yearPath","monthPath","datePath"}
	
	private static void makeDir(String uploadPath, String...paths) {  // ... 몇개 넣을지 모를때 ...
		
		for(String path: paths) {
			File dir = new File(uploadPath + path);
			if(dir.exists() == false) {
				dir.mkdir();
			}
			
		}
		
	}
	
	
	
	
	
}

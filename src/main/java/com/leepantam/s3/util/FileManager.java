package com.leepantam.s3.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	
	public String save(String name, MultipartFile multipartFile, HttpSession session)throws Exception{
		// 1. 경로 설정
		String path = session.getServletContext().getRealPath("resources/upload/"+name);
		System.out.println(path);
		
		File file = new File(path);

		if(!file.exists()) {
			file.mkdirs();
		}
		
		// 2. 저장할 파일명
		String fileName="";
		// a. 시간
//		Calendar ca = Calendar.getInstance();
//		long time = ca.getTimeInMillis();
//		fileName=time+"_"+multipartFile.getOriginalFilename();
		
		// b. API
		fileName = UUID.randomUUID().toString()+"_"+multipartFile.getOriginalFilename();
		
		// 3. HDD에 저장
		file = new File(file,fileName);
		
		// a. FileCopyUtils
//		FileCopyUtils.copy(multipartFile.getBytes(), file);
		
		// b. MultipartFile
		multipartFile.transferTo(file);
		
		return fileName;
	}
	
	

	public File makePath(HttpSession session) throws Exception {
		// 1. 저장할 디렉토리 지정 resources/upload/member
		// 2. os에서 인식할 수 있는 실제 경로 찾기
		// jsp : application - server : ServletContext
		String path = session.getServletContext().getRealPath("resources/upload/member");

		// 3. 실제 경로에 폴더가 없으면 에러 발생 -> 해당 경로가 없으면 생성
		File file = new File(path);

		if(!file.exists()) {
			file.mkdirs();
		}

		return file;
	}



	// 4. 저장할 파일명 생성
	//   a. 시간
	public String makeTimeFileName() throws Exception {
		Calendar ca = Calendar.getInstance();
		long time = ca.getTimeInMillis();
		return String.valueOf(time);
	}

	//  b. UUID
	public String makeUUIDFileName() throws Exception{
		return UUID.randomUUID().toString();
	}
	
	
	// 5. 파일 저장
//	file = new File(file, name);
	//   1. FileCopyUtils 클래스의 copy 메서드 사용
	
	public void saveUseCopy(MultipartFile multipartFile, File file) throws Exception  {
		FileCopyUtils.copy(multipartFile.getBytes(), file);
	}
	//   2. MultipartFile 클래스의 메서드 사용
	
	public void saveUseTransfer(MultipartFile multipartFile, File file) throws Exception {
		multipartFile.transferTo(file);
	}
	
	
	public boolean Delete(String name,String fileName, HttpSession session) throws Exception{
		//1. 경로 설정
		String path = session.getServletContext().getRealPath("resources/upload/"+name);
		File file = new File(path, fileName);
		boolean check = false;
		if(file.exists()) {
			check = file.delete();
		}
		return check;
	}

}

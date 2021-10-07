package com.green.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.green.service.ProductService;
import com.green.vo.ImageVO;
import com.green.vo.ProductVO;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
@Slf4j
@RequestMapping("/product/*")
public class ProductController {

	@Setter(onMethod_=@Autowired)
	ProductService service;
	
	@GetMapping("/register")
	public String insert() {
		return "/product/insert";
	}
	@PostMapping("/register")
	public String postRegister(ProductVO vo, ImageVO ivo) {
		System.out.println("1) 컨트롤러 등록 post " +vo + " imageVO: " + ivo);
		Long pnoMaxLong = service.getMaxPno();
		System.out.println("가장 큰 pno 숫자 : " + pnoMaxLong);
		if(pnoMaxLong == null) {
			service.insertProduct(vo);
			ivo.setRefPno(1L);
			service.insertImage(ivo);
		}else {
			service.insertProduct(vo);
			ivo.setRefPno(pnoMaxLong+1);
			service.insertImage(ivo);
		}
		
		return "/product/list";
	}
	
	
	private String getFolder() { //오늘날짜를 이용하여 폴더 구조의 문자열을 반환하는 함수 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str =  sdf.format(date);
		return str.replace("-", File.separator);//문자열중 "-"를 파일의 구분자(separator)로 교체함 
	}
	@PostMapping(value = "/uploadAjaxAction",produces = MediaType.APPLICATION_JSON_UTF8_VALUE) //497page
	@ResponseBody
	public ResponseEntity<ImageVO> uploadAjaxPost(MultipartFile uploadFile) {
		String uploadFolder = "c:\\upload";
		//폴더 생성
		String uploadFolderPath = getFolder(); //변경 
		File uploadPath = new File(uploadFolder,uploadFolderPath); //변경
		log.info("파일 업로드된 경로 :" +  uploadPath);
		if(!uploadPath.exists()) uploadPath.mkdirs();//파일의 경로가 존재하지 않으면 폴더 새로 생성 
			log.info(".............컨트롤러에서의 파일 업로드 post ajax 이용  "  );
			ImageVO attachDTO = new ImageVO();
			String uploadFileName = uploadFile.getOriginalFilename();
			log.info("업로드 파일명: " +  uploadFileName);
			log.info("업로드 파일 크기: " +  uploadFile.getSize());
			attachDTO.setFileName(uploadFileName); //추가 
			UUID uuid = UUID.randomUUID();//고유한 키를 생성해주는 자바 util 
			uploadFileName= uuid.toString()+"_" + uploadFileName;//고유키 + "_" + 원래 파일명 
			try {
				File saveFile = new File(uploadPath,uploadFileName);
				uploadFile.transferTo(saveFile); 
				attachDTO.setUuid(uuid.toString()); //추가
				attachDTO.setUploadPath(uploadFolderPath); //추가 
					FileOutputStream thumbnail = new FileOutputStream(
							new File(uploadPath,"s_" + uploadFileName));
					Thumbnailator.createThumbnail(uploadFile.getInputStream(), thumbnail,200,200);//섬네일 이미지 생성 
					thumbnail.close();
			} catch (Exception e) {
				log.error(e.getMessage());
			} 
		return new ResponseEntity<>(attachDTO, HttpStatus.OK);
	}
	@GetMapping("/display")
	@ResponseBody
	public ResponseEntity<byte[]> getFile(String fileName){ //화면에 출력하는기능을 여기 컨트롤러에서 담당 
		log.info("컨트롤러의 display에서의 fileName:" + fileName);
		File file = new File("c:\\upload\\" + fileName);
		log.info("file:" + file);
		ResponseEntity<byte[]> result = null;
		try {
			HttpHeaders header = new HttpHeaders();
			header.add("Content-type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file),header,
					HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}

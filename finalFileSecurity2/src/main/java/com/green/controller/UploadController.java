package com.green.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.green.vo.AttachFileDTO;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
@Slf4j
public class UploadController {
	@GetMapping("/uploadForm")
	public void uploadForm() {
		log.info("파일 업로드 upload form 태그 이용" );
	}
	@PostMapping("/uploadFormAction") //497page
	public void uploadFormPost(MultipartFile[] uploadFile, Model model) {
		String uploadFolder = "c:\\upload";
		for(MultipartFile i : uploadFile) {
			log.info(".............컨트롤러에서의 파일 업로드 post form 태그 전송후 "  );
			log.info("업로드 파일명: " +  i.getOriginalFilename());
			log.info("업로드 파일 크기: " +  i.getSize());
			File saveFile = new File(uploadFolder,i.getOriginalFilename());
			try {
				i.transferTo(saveFile); 
				//사용자가 선택한 파일(i)을 위에서 생성한 파일 객체에 전송(transfer)하여 저장함 
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		} //end for 
	}
	
	@GetMapping("/uploadAjax")
	public void uploadAjax() {
		log.info("파일 업로드 ajax 컨틀롤러");
	}
	private String getFolder() { //오늘날짜를 이용하여 폴더 구조의 문자열을 반환하는 함수 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str =  sdf.format(date);
		return str.replace("-", File.separator);//문자열중 "-"를 파일의 구분자(separator)로 교체함 
	}
	private boolean checkImageType(File file) {
		try {
			String contentType= Files.probeContentType(file.toPath());
			return contentType.startsWith("image");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	@PreAuthorize("isAuthenticated()")
	@PostMapping(value = "/uploadAjaxAction",produces = MediaType.APPLICATION_JSON_UTF8_VALUE) //497page
	@ResponseBody
	public ResponseEntity<List<AttachFileDTO>> uploadAjaxPost(MultipartFile[] uploadFile) {
		List<AttachFileDTO> list = new ArrayList<>();//추가 
		String uploadFolder = "c:\\upload";
		//폴더 생성
		String uploadFolderPath = getFolder(); //변경 
		File uploadPath = new File(uploadFolder,uploadFolderPath); //변경
		log.info("파일 업로드된 경로 :" +  uploadPath);
		if(!uploadPath.exists()) uploadPath.mkdirs();//파일의 경로가 존재하지 않으면 폴더 새로 생성 
		for(MultipartFile i : uploadFile) {
			log.info(".............컨트롤러에서의 파일 업로드 post ajax 이용  "  );
			AttachFileDTO attachDTO = new AttachFileDTO();
			String uploadFileName = i.getOriginalFilename();
			log.info("업로드 파일명: " +  uploadFileName);
			log.info("업로드 파일 크기: " +  i.getSize());
			attachDTO.setFileName(uploadFileName); //추가 
			UUID uuid = UUID.randomUUID();//고유한 키를 생성해주는 자바 util 
			uploadFileName= uuid.toString()+"_" + uploadFileName;//고유키 + "_" + 원래 파일명 
			try {
				File saveFile = new File(uploadPath,uploadFileName);
				i.transferTo(saveFile); 
				attachDTO.setUuid(uuid.toString()); //추가
				attachDTO.setUploadPath(uploadFolderPath); //추가 
				if(checkImageType(saveFile)) {//image 파일인지 확인함 
					attachDTO.setImage(true); //추가 
					FileOutputStream thumbnail = new FileOutputStream(
							new File(uploadPath,"s_" + uploadFileName));
					Thumbnailator.createThumbnail(i.getInputStream(), thumbnail,200,200);//섬네일 이미지 생성 
					thumbnail.close();
				}
				list.add(attachDTO);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		} //end for 
		return new ResponseEntity<>(list, HttpStatus.OK);
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
	@GetMapping(value = "/download" ,produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody 
	public ResponseEntity<Resource> downloadFile(String fileName){
		log.info("컨트롤러 파일 다운로드 file : " +  fileName);
		Resource resource = new FileSystemResource("c:\\upload\\" + fileName);
		//if(resource.exists()==false) return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		String resourceName = resource.getFilename();
		log.info("resource: " +resource);

		HttpHeaders headers = new HttpHeaders();
		String downloadName = null;
		try {
			log.info("크롬 브라우저");
			downloadName = new String(resourceName.getBytes("UTF8"),"ISO-8859-1");
			headers.add("Content-Disposition" , "attachment; fileName=" + downloadName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Resource>(resource,headers , HttpStatus.OK);
	}
	
	@PostMapping("/deleteFile")
	@ResponseBody
	public ResponseEntity<String> deleteFile(String fileName, String type){
		log.info("deletFile: " + fileName);
		
		File file;
		try {
			file = new File("c:\\upload\\" + URLDecoder.decode(fileName,"UTF-8"));
			file.delete();//thumbnail 파일 삭제
			if(type.equals("image")) {
				String largeFileName = file.getAbsolutePath().replace("s_", "");
				//thumbnail 파일을 의미하는  s_를 제거하여 원래 파일명 구함 
				log.info("원래 파일 이름 :" +  largeFileName);
				file = new File(largeFileName);
				file.delete();//원래 크기의 파일 삭제 
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}
}

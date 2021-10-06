package com.green.task;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.green.mapper.BoardAttachMapper;
import com.green.vo.BoardAttachVO;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@Component
public class FileCheckTask {
	@Setter(onMethod_=@Autowired)
	private BoardAttachMapper attachMapper;
	
	private String getFolderYesterday() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar cal = Calendar.getInstance();//timezone을 가져오는데
		//getInstance라고 하면 singleton 을 말합니다
		
		cal.add(Calendar.DATE,-1);
		String str = sdf.format(cal.getTime());
		return str.replace("-",File.separator);
	}
	@Scheduled(cron="* * 3 * * *")
	public void checkFiles() throws Exception{
		log.warn("File Check Task run................");
		log.warn("======================================");
		//데이터 베이스에 있는 파일 목록 구하기
		List<BoardAttachVO> fileList = attachMapper.getOldFiles();
		//데이터 베이스의 파일 목록(문자열)을 파일 저장하고 있는 서버의 폴더에 파일이 있는지 체크함
		List<Path> fileListPaths = fileList.stream()
				.map(vo -> Paths.get("c:\\upload",vo.getUploadPath(),vo.getUuid()+ "_" + vo.getFileName()))
				.collect(Collectors.toList());
		//이미지는 썸네일 이미지를 가지고 있으므로 파일 타입이 이미지인것을 골라서 map을 이용하여 썸네일을 얻고 filePath에 추가
		fileList.stream().filter(vo->vo.isFileType()==true)
			.map(vo->Paths.get("c:\\upload" ,vo.getUploadPath(),"s_"+ vo.getUuid()+"_"+vo.getFileName()))
			.forEach(i->fileListPaths.add(i)); //accept(Consumer) 반환타입 없음
		//stream에서 중간 연산자(map,filter)
		//마지막(terminal) 연산자 => collect, reduce, forEach
		log.warn("================");
		fileListPaths.forEach(i->log.warn(""+i));
		//어제 디렉토리에 파일이 있으면
		File targetDir = Paths.get("c:\\upload",getFolderYesterday()).toFile();//어제 날짜의 파일을 가져와서
		File[] removeFiles = targetDir.listFiles(i->fileListPaths.contains(i.toPath())==false);
		//데이터 베이스에 없는 파일 삭제하기 위한 배열
		//서버의 파일이 저장되어 있는 targetDir(upload//2021/10/01/asdfsafsa 의파일이  db에서  getOldFiles 이용해서 가져온 문자열에 포함되지 않으면 
		//삭제 
		log.warn("===============");
		for (File file : removeFiles) {
			log.warn("여기서 실행 : " + file.getAbsolutePath());
			file.delete();//데이터 베이스에 없는 파일들 삭제함
		}
	}
}

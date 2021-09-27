package com.green.controller;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.green.vo.SampleVO;
import com.green.vo.Ticket;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/sample/*")
@Slf4j
public class SampleController {
	@GetMapping(value="/getText" ,produces = "text/plain; charset=UTF-8")
	public String getTest() {
		log.info("Mime Type:" + MediaType.TEXT_PLAIN_VALUE);
		return "안녕하세요";
	}
	
	@GetMapping(value="/getSample",
			produces= {MediaType.APPLICATION_JSON_UTF8_VALUE,
					MediaType.APPLICATION_XML_VALUE	}
			)
	public SampleVO getSample() {
		return new SampleVO(112,"스타","월드");//sample/getSample.json
	}
	
	@GetMapping(value = "/getList")
	public List<SampleVO> getList(){
		return IntStream.range(1, 19).mapToObj(i->new SampleVO(i, i+"first" , i +"last"))
				.collect(Collectors.toList());
	}
	//문제 2)  스트림으로 하지 않고 반복문으로 하세요 /sample/getList2
	@GetMapping(value = "/getList2")
	public List<SampleVO> getList22(){
		
		List<SampleVO> vo = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			vo.add(new SampleVO(i+1 , i +" first " , i+" last"));
		}
		return vo;
	}
	@GetMapping(value="/getMap")
	public Map<String ,SampleVO> getMap(){
		Map<String,SampleVO> map = new HashMap<>();
		map.put("first" , new SampleVO(111,"그린 " ,"컴퓨터") );
		return map;
	}
	
	@GetMapping(value="/getMap2")
	public List<Map<String ,SampleVO>> getMap222(){
		Map<String,SampleVO> map = new HashMap<>();
		Map<String,SampleVO> map2 = new HashMap<>();
		Map<String,SampleVO> map3 = new HashMap<>();
		List<Map<String ,SampleVO>> listOfMap = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			map.put("first" +i  , new SampleVO(i+100,"그린" +i+1 ,"컴퓨터" +i+1));
		}
		listOfMap.add(map);
		for (int i = 0; i < 5; i++) {
			map2.put("second" +i  , new SampleVO(i+200,"그린" +i+11 ,"컴퓨터" +i+15));
		}
		listOfMap.add(map2);
		
		for (int i = 0; i < 15; i++) {
			map3.put("third" +i  , new SampleVO(i+200,"그린 000" +i+11 ,"컴퓨터000" +i+15));
		}
		listOfMap.add(map3);
		return listOfMap;
	}
	@GetMapping(value = "/check" , params = {"height","weight"})
	public ResponseEntity<SampleVO> check(Double height, Double weight){
		SampleVO vo = new SampleVO(0,""+height, "" +weight);
		ResponseEntity<SampleVO> result =null;
		if(height<150)
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		else
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		return result;
		//check는반드시 height와 weight를 파라미터로 받습니다. 
		//이때 만일 height값이ㅣ 150보다 작으면  502(bad gateway)  상태 코드와 데이터를 전송
		//그렇지 않다면 200(ok) 코드와 데이터를 전송 
		// sample/check.json?height=140&weight=60
	}
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(
			@PathVariable("cat") String cat, @PathVariable("pid") Integer pid
			){
		return new String[] {"category: " +cat,"productId: " + pid};
	}// sample/product/bags/1234
	
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		log.info("convert ... ticket "+  ticket);
		return ticket;
	}
}

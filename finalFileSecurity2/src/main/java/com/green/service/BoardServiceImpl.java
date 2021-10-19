package com.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.green.mapper.BoardAttachMapper;
import com.green.mapper.BoardMapper;
import com.green.vo.BoardAttachVO;
import com.green.vo.BoardVO;
import com.green.vo.Criteria;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService{
	
	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;
	
	@Setter(onMethod_=@Autowired)
	private BoardAttachMapper attachMappper;

	@Transactional
	@Override
	public void register(BoardVO board) {
		log.info("2) 서비스 등록 :" +  board);
		mapper.insertSelectKey(board);
		if(board.getAttachList() ==null || board.getAttachList().size()<=0) {
			return;
		}
		//매우 유용하고 중요한 로직 
		//attachList에는 첨부파일이 여러개 있고 
		// 그 첨부 파일을 하나씩 꺼내어 각각의 첨부 파일에는 bno가 있고 그 bno를 
		//BoardVO에서 가져와서 각각의 첨부파일의 bno의 값에 대입(저장하고)
		// mapper에 각각의 첨부 파일을 추가함 
		board.getAttachList().forEach(i->{
			i.setBno(board.getBno());
			attachMappper.insert(i);
		});
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("2) 서비스에서 데이터 하나 가져오기 ......." +bno);
		return mapper.read(bno);
	}

	@Transactional
	@Override
	public boolean modify(BoardVO board) {
		log.info("2) 서비스에서 수정 " + board);
		//추가 -> 첨부파일 전체 삭제
		attachMappper.deleteAll(board.getBno()); 
		boolean modifyResult = mapper.update(board)==1;
		// && 연산자 앞의 값이 true이면 오른쪽 연산을 실행
		// false이면 오른쪽 실행하지 않음 ,short circuit 기능 
		if(modifyResult && board.getAttachList() !=null && board.getAttachList().size()>0) {
			board.getAttachList().forEach(attach->{
				attach.setBno(board.getBno());
				attachMappper.insert(attach);
			});
		}
		return modifyResult;
	}

	@Transactional
	@Override
	public boolean remove(Long bno) {
		log.info("2) 서비스에 데이터 삭제 :" +  bno);
		attachMappper.deleteAll(bno);//추가  p579
		return mapper.delete(bno)==1;
	}

//	@Override
//	public List<BoardVO> getList() {
//		log.info("2) 서비스에서 전체 목록 가져오기 ........." );
//		return mapper.getList();
//	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		log.info("2) 서비스에서 Criteria를 이용하여 전체 목록 가져오기 ........."  +cri);
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		log.info("2) 서비스에서 전체 데이터 갯수 가져오기 ........."  +cri);
		return mapper.getTotalCount(cri);
	}

	@Override
	public List<BoardAttachVO> getAttachList(Long bno) {
		log.info("2) 서비스에서 bno에 해당하는 첨부 파일 전체 목록 가져오기 ........."  +bno);
		return attachMappper.findByBno(bno);
	}

}

package com.green.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.green.vo.Criteria;
import com.green.vo.ReplyVO;

public interface ReplyMapper {
	public int insert(ReplyVO vo);
	public ReplyVO read(Long rno);
	public int delete (Long rno); // xml은 여러분이 안보고 
	public int update(ReplyVO reply);
	public List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri,@Param("bno") Long bno);
	public int getCountByBno (Long bno);//xml 을 안보고 작성 및 test 코드 작성 
	//권태수 이혜원 여지혜 김영진 김채현 
}

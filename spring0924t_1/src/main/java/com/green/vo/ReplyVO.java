package com.green.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ReplyVO {
	  private Long rno; //댓글 번호 
	  private Long  bno; // 게시글 번호(primary key)  와 foreign key로 연결되어 있음 
	  private String  reply; //댓글 
	  private String  replyer; //댓글 작성자
	  private Date  replyDate; //댓글 등록일
	  private Date  updateDate; //댓글 수정일 
}

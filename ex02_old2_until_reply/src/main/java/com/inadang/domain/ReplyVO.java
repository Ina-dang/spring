package com.inadang.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;
		//리절트 타입쓸때 쓸 별칭부여
@Data @Alias("reply")
public class ReplyVO {
	private Long rno;
	private Long bno;
	private String reply;
	private String replyer;
	private Date replyDate;
	private Date updateDate;
}

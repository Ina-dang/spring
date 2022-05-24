package com.inadang.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("board")
public class BoardVO {
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date RegDate;
	private Date updateDate;
	private String replyCnt;
	
	List<BoardAttachVO> attachs = new ArrayList<>();
}

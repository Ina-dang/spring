package com.inadang.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter @Setter
@ToString(callSuper=true) //조상필드 정보
public class ReplyAttachVO extends AttachFileDTO{
	private Long rno;
	
	
	//uploadController 생성자 5개를 받기위해 allargsConstructor 대신 직접생성
	
	public ReplyAttachVO(String origin, String uuid, String path, boolean image, Long rno) {
		super(origin, uuid, path, image);
		this.rno = rno;
	}
	
	public ReplyAttachVO(AttachFileDTO dto, Long rno){
		this(dto.getOrigin(), dto.getUuid(), dto.getPath(), dto.isImage(), rno);
	}
	
	
}

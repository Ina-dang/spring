package com.inadang.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter @Setter
@ToString(callSuper=true) //조상필드 정보
public class BoardAttachVO extends AttachFileDTO{
	private Long bno;
	
	
	//uploadController 생성자 5개를 받기위해 allargsConstructor 대신 직접생성
	
	public BoardAttachVO(String origin, String uuid, String path, boolean image, Long bno) {
		super(origin, uuid, path, image);
		this.bno = bno;
	}
	
	public BoardAttachVO(AttachFileDTO dto, Long bno){
		this(dto.getOrigin(), dto.getUuid(), dto.getPath(), dto.isImage(), bno);
	}
}

package com.inadang.task;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.inadang.domain.BoardAttachVO;
import com.inadang.mapper.BoardAttachMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Component
@AllArgsConstructor

public class FileCheckTask {
	private BoardAttachMapper mapper;
	
	
	@Scheduled(cron="0 0 2 * * *")
    public void checkFiles() {
        log.warn("File check Task");
        log.warn("===============================");
        log.warn(getFolderYesterday());

        File file = new File("c:/upload", getFolderYesterday());
        if(!file.exists()) {
            return;
        }
//        localFiles.forEach(log::warn);
        
        log.warn("===============================");
        List<BoardAttachVO> dbFiles = mapper.getOldFiles(); // DB 내의 파일들
        //db List<BoardAttachVO> >>> Lsst<File> 리터럴로 바꾸는 작업
        List<File> dbFiles2 = 
        		dbFiles.stream()
        		.map(attach -> 	new File(file, attach.getUuid()))
        		.collect(Collectors.toList());
//        dbFiles2.forEach(log::warn);
        
        //dbFiles. 한번더 스트림함
        dbFiles.stream()
        //조건탐색
//        .filter(attach->attach.isImage()) 
        // :: 메서드 참조 이미지
        .filter(BoardAttachVO::isImage)
        .map(attach->new File(file, "s_"+attach.getUuid()))
        .forEach(dbFiles2::add); //종결연산 forEach 참인연산만 나오게 함
        
        dbFiles.forEach(log::warn);
        
//        List<File> localFiles =
        //db에 존재하지 않는 파일 삭제
		Arrays.asList(file.listFiles(f->!dbFiles2.contains(f))).forEach(File::delete); //업로드 폴더 내 파일들
		
		 boolean b = true;
		 if(b == true == true == true != false){
			 
		 }
    }
	
	public void  test(){
		
	}
	
	public String getFolderYesterday(){
		return new SimpleDateFormat("yyyy/MM/dd").format(new Date().getTime() - 1000 * 60 * 60 * 24 );
	}
}

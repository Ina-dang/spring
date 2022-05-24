package com.inadang.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inadang.domain.BoardAttachVO;
import com.inadang.domain.BoardVO;
import com.inadang.domain.Criteria;
import com.inadang.mapper.BoardAttachMapper;
import com.inadang.mapper.BoardMapper;
import com.inadang.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service @AllArgsConstructor @Log4j
public class BoardServiceImpl implements BoardService{
	private BoardMapper boardMapper;
	private BoardAttachMapper boardAttachMapper;
	private ReplyMapper replyMapper;
	
	
	@Transactional
	public int register(BoardVO boardVO) {
		log.info("register(" + boardVO + ")");
		//boardVO.bno == null
		int result = boardMapper.insertSelectKey(boardVO);
		log.info(boardVO.getBno());
		
		boardVO.getAttachs().forEach((attach)->{
			attach.setBno(boardVO.getBno());
			boardAttachMapper.insert(attach);
		});
		//boardVO.bno == not null
		
		return result;
	}

	@Override
	@Transactional
	public BoardVO get(Long bno) {
		return boardMapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO boardVO) {
		//첨부파일 일괄삭제
		boardAttachMapper.deleteAll(boardVO.getBno());
		
		//첨부파일 재등록
		boardVO.getAttachs().forEach((attach)->{
			attach.setBno(boardVO.getBno());
			boardAttachMapper.insert(attach);
		});
		
		//업데이트
		return boardMapper.update(boardVO) > 0;
	}

	@Transactional
	public boolean remove(Long bno) {
		replyMapper.deleteAll(bno);
		boardAttachMapper.deleteAll(bno);
		return boardMapper.delete(bno) > 0;
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		return boardMapper.getListWithPaging(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		// TODO Auto-generated method stub
		return boardMapper.getTotalCount(cri);
	}

	@Override
	public List<BoardAttachVO> getAttaches(long bno) {
		// TODO Auto-generated method stub
		return boardAttachMapper.findBy(bno);
	}
	
	
	
}

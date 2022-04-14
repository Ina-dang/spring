package com.inadang.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.inadang.domain.BoardVO;

public interface BoardMapper {
//	@Select("SELECT * FROM TBL_BOARD WHERE BNO > 0")
	public List<BoardVO> getList();

	//193페이지 read(select처리)
	public BoardVO read(Long bno);
	
	// 189 페이지 DML은 void 노노해
	public int insert(BoardVO boardVO);
	public int insertSelectKey(BoardVO boardVO);

}

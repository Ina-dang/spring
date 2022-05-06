package com.inadang.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.inadang.domain.BoardVO;
import com.inadang.domain.Criteria;

public interface BoardMapper {
//	@Select("SELECT * FROM TBL_BOARD WHERE BNO > 0")
	public List<BoardVO> getList();

	//193페이지 read(select처리)
	public BoardVO read(Long bno);
	
	// 189 페이지 DML은 void 노노해
	//갯수를 세온다같은거는 여기서 @Select처리해도됨
//	@Select("INSERT INTO TBL_BOARD(BNO, TITLE, CONTENT, WRITER)"
//			+ "VALUES (SEQ.BOARD.NEXTVAL, #{title}, #{content}, #{writer})"
//			)	
	public int insert(BoardVO boardVO);
	public int insertSelectKey(BoardVO boardVO);
	
	//196페이지
	public int update (BoardVO boardVO);
	//194페이지
	public int delete (Long Bno);
	
	public List<BoardVO> getListWithPaging(Criteria cri);

	public int getTotalCount(Criteria cri);
	
	public List<BoardVO> getListDynamicTest(Criteria cri);
}

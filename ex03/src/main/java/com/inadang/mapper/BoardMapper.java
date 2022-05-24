package com.inadang.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.inadang.domain.Board;

public interface BoardMapper {
	@Select("SELECT * FROM TBL_BOARD")
	public List<Board> getList();
}

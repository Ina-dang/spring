package com.inadang.mapper;

import java.util.List;

import com.inadang.domain.OrderMenu;

/**
 * @author 이나현
 * 
 */
public interface OrderMenuMapper {
	//주문내역
	public List<OrderMenu> getList();
	//주문추가
	public int insert(OrderMenu om); 
	//메뉴찾기
	List<OrderMenu> findBy(String ono);
	//주문삭제
	public int delete(Long mno);
	//메뉴전체삭제
	public List<OrderMenu> deleteAll(String ono);
}

package com.inadang.webtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.inadang.webtest.domain.Board;

@Service
public class BoardDao {
	public List<Board> list(){
		List<Board> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@np.inadang.com:1521/xe", "ODOUNG", "1234");
			ResultSet rs = 
					conn.prepareStatement("SELECT BNO, TITLE, CONTENT FROM TBL_BOARD WHERE ROWNUM <= 10").executeQuery();
			while(rs.next()){
				int idx = 1;
				Board board = new Board(rs.getLong(idx++), rs.getString(idx++), rs.getString(idx++));
				list.add(board);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

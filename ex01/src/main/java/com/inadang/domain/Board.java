package com.inadang.domain;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data @NoArgsConstructor @AllArgsConstructor
@Component @ToString @Getter @Setter
public class Board {
	private Long bno;
	private String title;
}

package com.inadang.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data @NoArgsConstructor @RequiredArgsConstructor
//@ToString @RequiredArgsConstructor @Getter
@Component 
public class Restaurant {
	@NonNull @Autowired
	private Chef chef;
}

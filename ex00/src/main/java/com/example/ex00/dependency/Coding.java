package com.example.ex00.dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Coding {
@Autowired
	private Computer computer;

}

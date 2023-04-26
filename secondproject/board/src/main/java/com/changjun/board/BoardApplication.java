package com.changjun.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 폴더 기본구조
// controller, config, service-implement, repository, dto, entity, 

// client > controller>service> repository>database
// client -> service dto
// service->database Entity



@SpringBootApplication
public class BoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardApplication.class, args);
	}

}

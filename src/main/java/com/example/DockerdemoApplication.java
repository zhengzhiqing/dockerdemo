package com.example;

import com.example.mapper.PersonMapper;
import com.example.model.Person;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@MapperScan("com.example.mapper")
public class DockerdemoApplication {

	@Autowired
	PersonMapper personMapper;

	@RequestMapping("/")
	public String getPersonName() {
		Person person = personMapper.selectByPrimaryKey(1);
		return "Hi, I'm " + person.getName();
	}

	public static void main(String... args) {
		SpringApplication.run(DockerdemoApplication.class, args);
	}

}

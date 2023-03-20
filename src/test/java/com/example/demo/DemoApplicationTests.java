package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Value("${info.app.name}")
	private String myAppName;

	@Test
	void myTest() {
		System.out.println(myAppName);
	}

}

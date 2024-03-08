package com.hamburg.springtests.logintest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.hamburg.springtests.logintest")
public class LottoAppForGitTest {

	public static void main(String[] args) {
		SpringApplication.run(LottoAppForGitTest.class, args);
		System.out.println("On app MyTestApplication");
	}
}
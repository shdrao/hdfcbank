package com.capgemini.hdfcbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.capgemini.hdfcbank" })
//@EnableAutoConfiguration
public class HdfcbankApplication {
	public static void main(String[] args) {
		SpringApplication.run(HdfcbankApplication.class, args);
	}
}

package com.example.demoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class DemoappApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoappApplication.class, args);
		// Beans
		String[] names = context.getBeanDefinitionNames();
		System.out.println();
		System.out.println("----- forEach -----");
		for (String name : names) {
			System.out.println(name);
		}
		System.out.println();
		System.out.println("----- Stream forEach -----");
		Arrays.stream(names).forEach(System.out::println);
		System.out.println();
		System.out.println("----- Count all beans -----");
		System.out.println(context.getBeanDefinitionCount());
	}

}

package com.springmvcdemo.web;

import org.springframework.stereotype.Component;


@Component
public class autotest {
	
	int age;
	String name;
	
	
	public autotest() {
		
		age = 10;
	    name = "luoyu";
		
	}


	public void say()
	{
		System.out.println(age+name);
	}

}

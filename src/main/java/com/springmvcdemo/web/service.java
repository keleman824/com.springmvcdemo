package com.springmvcdemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/luoyu")
public class service {
	
	
	
public service() {
		
		System.out.println("controller init.....................");
	}

@RequestMapping("/action")
@ResponseBody
public String hello() 
{

     return "hello";
}

}

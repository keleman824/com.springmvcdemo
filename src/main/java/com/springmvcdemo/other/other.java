package com.springmvcdemo.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.springmvcdemo.web.autotest;

@Component("myother")
public class other {
	
	public autotest getAuto() {
		return auto;
	}

	public void setAuto(autotest auto) {
		this.auto = auto;
	}

	@Autowired
	autotest  auto;
	
	public void testauto()
	{
		auto.say();
	}

}

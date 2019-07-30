package com.qa.curdoperation.test;

import org.apache.log4j.Logger;
import org.junit.Test;

public class TestDriver {
	
	Logger logger = Logger.getLogger(TestDriver.class);
	
	@Test()
	public void testing() {
		logger.info("I am from Test");
	}

}

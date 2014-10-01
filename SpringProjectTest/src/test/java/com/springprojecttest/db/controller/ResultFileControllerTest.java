package com.springprojecttest.db.controller;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.springprojecttest.db.domain.Result;
import com.springprojecttest.properties.PropertyManager;

public class ResultFileControllerTest {

	private String filename;
	
	@Before
	public void before() throws Exception{
		filename = PropertyManager.getInstance().getResultDBPath();
	}
	
	@Test
	public void testGetResultByPollId() throws IOException{
		ResultFileController rfc = new ResultFileController(filename);
		rfc.readFile();
		List<Result> results = rfc.getResultsByPollId(1);
		assertEquals(results.size(), 2);
		
	}
	
	@After
	public void after() throws Exception{
		
	}

}

package com.springprojecttest.db.controller;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
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
		ResultFileController rfc = new ResultFileController(filename);
		rfc.writeToFile("id, userId, pollId, choiceNumber\n1, 1, 1, 4\n2, 3, 1, 3\n3, 2, 3, 1", false);	
	}
	
	@Test
	public void testGetResultByPollId() throws IOException{
		ResultFileController rfc = new ResultFileController(filename);
		rfc.readFile();
		List<Result> results = rfc.getResultsByPollId(1);
		assertEquals(results.size(), 2);
		
	}
	
	@Test
	public void testAddResult() throws IOException{
		ResultFileController rfc = new ResultFileController(filename);
		rfc.addResult(new Result(4, 2, 2, 1));
		rfc.readFile();
		assertEquals(1, rfc.getResultsByPollId(3).size()); //there should only be 1 result with poll id: 3
	}
	
	@Test
	public void testJSON() throws JsonGenerationException, JsonMappingException, IOException{
		ResultFileController rfc = new ResultFileController(filename);
		rfc.readFile();
		List<Result> results = rfc.getResultsByPollId(1);
		ObjectWriter obj = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = obj.writeValueAsString(results);
		System.out.println(json);
	}
	
	@After
	public void after() throws Exception{
		
	}

}

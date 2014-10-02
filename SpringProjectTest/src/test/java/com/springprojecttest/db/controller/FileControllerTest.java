package com.springprojecttest.db.controller;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.springprojecttest.properties.PropertyManager;

public class FileControllerTest {

	private String filename;
	
	@Before
	public void before() throws Exception{
		filename = PropertyManager.getInstance().getUserDBPath();
	}
	
	@Test
	public void testReadFile() throws IOException{
		FileController fc = new FileController(filename);
		fc.readFile();
		assertTrue(fc.getList().size() >= 2);
	}

	@Test
	public void testAppendDataToFile() throws IOException{
		FileController fc2 = new FileController(filename);
		fc2.writeToFile("1, bruce, grove, bruce@gmail.com", true);
	}
	
	@Ignore
	@Test
	public void testDeleteContentsInFile() throws IOException{
		FileController fc2 = new FileController(filename);
		fc2.writeToFile("", false);
	}
	
	
	@After
	public void after() throws Exception{
		
	}
	
	
	
}

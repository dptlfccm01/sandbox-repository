package com.springprojecttest.db.controller;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;

public class FileControllerTest {
	
	@Test
	public void testReadFile() throws IOException{
		FileController fc = new FileController("src/resources/usersdb.txt");
		fc.readFile();
		assertTrue(fc.getList().size() >= 2);
	}

	@Test
	public void testAppendDataToFile() throws IOException{
		FileController fc2 = new FileController("src/resources/usersdb.txt");
		fc2.writeToFile("Testing", true);
	}
	
	@Ignore
	@Test
	public void testDeleteContentsInFile() throws IOException{
		FileController fc2 = new FileController("src/resources/usersdb.txt");
		fc2.writeToFile("", false);
	}
}

package com.springprojecttest.db.controller;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class FileControllerTest {

	@Test
	public void testReadFile() throws IOException{
		FileController fc = new FileController();
		fc.readFile();
		assertEquals(fc.getUserList().size(), 2);
	}

}

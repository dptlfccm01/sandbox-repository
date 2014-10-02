package com.springprojecttest.db.controller;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.springprojecttest.db.domain.User;
import com.springprojecttest.properties.PropertyManager;

public class UserFileControllerTest {

	private String filename;
	
	@Before
	public void before() throws Exception{
		filename = PropertyManager.getInstance().getUserDBPath();
		UserFileController ufc = new UserFileController(filename);
		ufc.writeToFile("id, firstname, lastname, email\n1, Dan, Ford, danford@dan.com\n2, Ed, Shaw, ed@ed.com\n3, Dave, Smith, dave@dave.com\n4, Abi, Tom, abi@abi.com\n5, Marty, Fall, marty@marty.com", false);
	
	}
	
	
	@Test
	public void testGetUsers() throws IOException{
		UserFileController ufc = new UserFileController(filename);
		ufc.readFile();
		List<User> userList = ufc.getUsers();
		assertTrue(userList.size()> 0);
	}
	
	
	@Test
	public void testAddUser() throws IOException{
		UserFileController ufc = new UserFileController(filename);
		User user = new User(6, "James", "Mansion", "james@james.com");
		ufc.addUser(user);
		assertEquals("6, James, Mansion, james@james.com", user.toString());
	}
	
	
	@After
	public void after() throws Exception{
		
	}
	
	
}

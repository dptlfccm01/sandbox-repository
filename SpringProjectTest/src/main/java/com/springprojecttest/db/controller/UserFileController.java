package com.springprojecttest.db.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.springprojecttest.db.domain.User;

public class UserFileController extends FileController{

	public UserFileController(String filename) throws IOException{
		super(filename);
	}
	
	public List<User> getUsers(){
		List<User> userList = new ArrayList<User>();
		List<String> fileRecords = getList();
		for(Iterator<String> it = fileRecords.iterator(); it.hasNext();){
			String[] fields = it.next().split(", ");
			userList.add(new User(Integer.parseInt(fields[0]), fields[1], fields[2], fields[3]));
		}
		return userList;
	}
	
	
}

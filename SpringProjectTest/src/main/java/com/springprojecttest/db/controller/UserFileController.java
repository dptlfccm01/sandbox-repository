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
	
	public void addUser(User user) throws IOException{
		writeToFile(user.toString(), true);
	}
	
	/*This method could either return a user or return null*/
	public User getUserById(int id){
		List<String> fileRecords = getList();
		User user = null;
		for(Iterator<String> it = fileRecords.iterator(); it.hasNext();){
			String[] fields = it.next().split(", ");
			if(Integer.parseInt(fields[0]) == id){
				user = new User(Integer.parseInt(fields[0]), fields[1], fields[2], fields[3]);
				break;
			}
		}
		return user;
	}
}

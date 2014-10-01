package com.springprojecttest.db.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.springprojecttest.db.domain.User;

public class FileController {

	private List<User> userList;
	
	public FileController(){}
	
	public void readFile() throws IOException{
		
		userList = new ArrayList<User>();
		
		try{
			BufferedReader reader = new BufferedReader(new FileReader("src/resources/usersdb.txt"));
			String line;
			int iteration = 0;
			while((line = reader.readLine())!= null){
				if(iteration==0){
					iteration++;
					continue;
				}
				System.out.println("OUT> "+line);
				String[] fields = line.split(", ");
				userList.add(new User(Integer.parseInt(fields[0]), fields[1], fields[2], fields[3]));
			}
			reader.close();
		}
		
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	
	
	
}

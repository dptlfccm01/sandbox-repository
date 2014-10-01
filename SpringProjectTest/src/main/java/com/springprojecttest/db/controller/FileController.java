package com.springprojecttest.db.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.springprojecttest.db.domain.User;

public class FileController {
	
	List<String> list;
	
	public FileController(){}
	
	public void readFile() throws IOException{
		
		list = new ArrayList<String>();
		
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
				list.add(line);
			}
			reader.close();
		}
		
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}
	
	

	
	
	
	
}

package com.springprojecttest.db.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileController {
	
	private List<String> list;
	private String filename;
	
	
	public FileController(String filename) throws IOException{
		this.filename = filename;
	}
	
	public void readFile() throws IOException{	
		list = new ArrayList<String>();
		try{
			BufferedReader reader = new BufferedReader(new FileReader(getFilename()));
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
	
	public void writeToFile(String value) throws IOException{
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
			writer.write(value);
			writer.newLine();
			writer.close();
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	

	
	
	
	
}

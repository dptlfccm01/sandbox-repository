package com.springprojecttest.db.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.springprojecttest.db.domain.Poll;
import com.springprojecttest.db.domain.Result;

public class ResultFileController extends FileController{

	public ResultFileController(String filename) throws IOException{
		super(filename);
	}
	
	public List<Result> getPolls(){
		List<Result> resultList = new ArrayList<Result>();
		List<String> fileRecords = getList();
		for(Iterator<String> it = fileRecords.iterator(); it.hasNext();){
			String[] fields = it.next().split(", ");
			resultList.add(new Result(Integer.parseInt(fields[0]), Integer.parseInt(fields[1]), Integer.parseInt(fields[2]), Integer.parseInt(fields[3])));
		}
		return resultList;
	}
	
	public void addResult(Result result) throws IOException{
		writeToFile(result.toString(), true);
	}
	
	public List<Result> getResultsByPollId(int id){
		List<Result> resultList = new ArrayList<Result>();
		List<String> fileRecords = getList();
		for(Iterator<String> it = fileRecords.iterator(); it.hasNext();){
			String[] fields = it.next().split(", ");
			if(Integer.parseInt(fields[2]) == id){
				resultList.add(new Result(Integer.parseInt(fields[0]), Integer.parseInt(fields[1]), Integer.parseInt(fields[2]), Integer.parseInt(fields[3])));
			}
		}
		return resultList;	
	}
	
	
}
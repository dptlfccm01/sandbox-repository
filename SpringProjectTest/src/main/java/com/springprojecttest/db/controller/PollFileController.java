package com.springprojecttest.db.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.springprojecttest.db.domain.Poll;


public class PollFileController extends FileController{

	public PollFileController(String filename) throws IOException{
		super(filename);
	}
	
	public List<Poll> getPolls(){
		List<Poll> pollList = new ArrayList<Poll>();
		List<String> fileRecords = getList();
		for(Iterator<String> it = fileRecords.iterator(); it.hasNext();){
			String[] fields = it.next().split(", ");
			pollList.add(new Poll(Integer.parseInt(fields[0]), fields[1], fields[2], fields[3], fields[4], fields[5], fields[6]));
		}
		return pollList;
	}
	
	public void addPoll(Poll poll) throws IOException{
		writeToFile(poll.toString(), true);
	}
	
	/*This method could either return a user or return null*/
	public Poll getPollById(int id){
		List<String> fileRecords = getList();
		Poll poll = null;
		for(Iterator<String> it = fileRecords.iterator(); it.hasNext();){
			String[] fields = it.next().split(", ");
			if(Integer.parseInt(fields[0]) == id){
				poll = new Poll(Integer.parseInt(fields[0]), fields[1], fields[2], fields[3], fields[4], fields[5], fields[6]);
				break;
			}
		}
		return poll;
	}	
	
	
	
	
	
	
}

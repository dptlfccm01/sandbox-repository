package com.springprojecttest.db.domain;

public class Result {

	private int id;
	private int userId;
	private int pollId;
	private int choiceNumber;
	
	public Result(){}
	
	public Result(int id, int userId, int pollId, int choiceNumber){
		this.id = id;
		this.userId = userId;
		this.pollId = pollId;
		this.choiceNumber = choiceNumber;
	}

	public int getId() {
		return id;
	}

	public int getUserId() {
		return userId;
	}

	public int getPollId() {
		return pollId;
	}

	public int getChoiceNumber() {
		return choiceNumber;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setPollId(int pollId) {
		this.pollId = pollId;
	}

	public void setChoiceNumber(int choiceNumber) {
		this.choiceNumber = choiceNumber;
	}
	
	@Override
	public String toString(){
		return getId()+", "+getUserId()+", "+getPollId()+", "+getChoiceNumber();
	}
	
}

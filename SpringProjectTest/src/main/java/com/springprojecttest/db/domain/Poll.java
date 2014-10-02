package com.springprojecttest.db.domain;

public class Poll {

	private int id;
	private String title;
	private String question;
	private String choice1;
	private String choice2;
	private String choice3;
	private String choice4;
	
	public Poll(){}
		
	public Poll(int id, String title, String question, String choice1, String choice2, String choice3, String choice4){
		this.id = id;
		this.title = title;
		this.question = question;
		this.choice1 = choice1;
		this.choice2 = choice2;
		this.choice3 = choice3;
		this.choice4 = choice4;
	}
	
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getQuestion() {
		return question;
	}
	public String getChoice1() {
		return choice1;
	}
	public String getChoice2() {
		return choice2;
	}
	public String getChoice3() {
		return choice3;
	}
	public String getChoice4() {
		return choice4;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}
	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}
	public void setChoice3(String choice3) {
		this.choice3 = choice3;
	}
	public void setChoice4(String choice4) {
		this.choice4 = choice4;
	}
	
	@Override
	public String toString(){
		return getId()+", "+getTitle()+", "+getQuestion()+", "+getChoice1()+", "+getChoice2()+", "+getChoice3()+", "+getChoice4();
	}
	
	
	
}

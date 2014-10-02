package com.springprojecttest.db.controller;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.springprojecttest.db.domain.Poll;
import com.springprojecttest.db.domain.User;
import com.springprojecttest.properties.PropertyManager;

public class PollFileControllerTest {

	String filename;
	
	@Before
	public void before() throws Exception{
			filename = PropertyManager.getInstance().getPollDBPath();
			PollFileController pfc = new PollFileController(filename);
			pfc.writeToFile("id, poll_title, poll_question, choice1, choice2, choice3, choice4\n1, General Knowledge, Who do you think will win the election?, Labour, Conservative, Liberal Democrats, UKIP", false);
	}
	
	@Test
	public void testGetPolls() throws Exception{
		PollFileController pfc = new PollFileController(filename);
		pfc.readFile();
		List<Poll> pollList = pfc.getPolls();
		assertTrue(pollList.size()> 0);		
	}
	
	@Test
	public void testAddPoll() throws Exception{
		PollFileController pfc = new PollFileController(filename);
		Poll poll = new Poll(2, "Title", "Question", "choice1", "choice2", "choice3", "choice4");
		pfc.addPoll(poll);
		assertEquals("2, Title, Question, choice1, choice2, choice3, choice4", poll.toString());
	}
	
	@Test
	public void testGetPollById() throws Exception{
		PollFileController pfc = new PollFileController(filename);
		pfc.readFile();
		Poll poll = pfc.getPollById(1);
		//1, General Knowledge, Who do you think will win the election?, Labour, Conservative, Liberal Democrats, UKIP"
		assertEquals(1, poll.getId());
		assertEquals("General Knowledge", poll.getTitle());
		assertEquals("Who do you think will win the election?", poll.getQuestion());
		assertEquals("Labour", poll.getChoice1());
		assertEquals("Conservative", poll.getChoice2());
		assertEquals("Liberal Democrats", poll.getChoice3());
		assertEquals("UKIP", poll.getChoice4());
	}

}

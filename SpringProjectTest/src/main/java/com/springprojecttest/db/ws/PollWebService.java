package com.springprojecttest.db.ws;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.springprojecttest.db.controller.PollFileController;
import com.springprojecttest.db.domain.Poll;
import com.springprojecttest.properties.PropertyManager;

@Path("/polls")
public class PollWebService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getpolls")
	public String getListOfPollsJSON() throws IOException{
		//URL to invoke: http://localhost:8080/SpringProjectTest/rest/polls/getpolls
		ObjectWriter wrapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
		PollFileController pollFileController = new PollFileController(PropertyManager.getInstance().getPollDBPath());
		pollFileController.readFile();
		List<Poll> pollsList = pollFileController.getPolls();
		String json = wrapper.writeValueAsString(pollsList);
		return json;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getpoll/{id}")
	public String getPollByIdJSON(@PathParam("id") int id) throws IOException{
		// URL to invoke: http://localhost:8080/SpringProjectTest/rest/polls/getpoll/1, where 1 = {id}
		ObjectWriter wrapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
		PollFileController pollFileController = new PollFileController(PropertyManager.getInstance().getPollDBPath());
		pollFileController.readFile();
		Poll poll = pollFileController.getPollById(id);
		String json = wrapper.writeValueAsString(poll);
		return json;	
	}
	
	
	
}

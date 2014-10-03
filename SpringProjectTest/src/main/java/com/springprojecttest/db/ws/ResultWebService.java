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

import com.springprojecttest.db.controller.ResultFileController;
import com.springprojecttest.db.domain.Poll;
import com.springprojecttest.db.domain.Result;
import com.springprojecttest.properties.PropertyManager;

@Path("/results")
public class ResultWebService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getresults/{id}")
	public String getResultsByPollJSON(@PathParam("id") int id) throws IOException{
		//URL to invoke: http://localhost:8080/SpringProjectTest/rest/results/getresults/1, where 1 = {id}
		ObjectWriter wrapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
		ResultFileController resultFileController = new ResultFileController(PropertyManager.getInstance().getResultDBPath());
		resultFileController.readFile();
		List<Result> pollsList = resultFileController.getResultsByPollId(id);
		String json = wrapper.writeValueAsString(pollsList);
		return json;
	}
	
}

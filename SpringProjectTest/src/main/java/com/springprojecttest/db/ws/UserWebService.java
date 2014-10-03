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

import com.springprojecttest.db.controller.UserFileController;
import com.springprojecttest.db.domain.User;
import com.springprojecttest.properties.PropertyManager;

@Path("/users")
public class UserWebService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getusers")
	public String getListOfUsersJSON() throws IOException{
		//URL to invoke: http://localhost:8080/SpringProjectTest/rest/users/getusers
		ObjectWriter wrapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
		UserFileController userFileController = new UserFileController(PropertyManager.getInstance().getUserDBPath());
		userFileController.readFile();
		List<User> usersList = userFileController.getUsers();
		String json = wrapper.writeValueAsString(usersList);
		return json;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getuser/{id}")
	public String getUserByIdJSON(@PathParam("id") int id) throws IOException{
		// URL to invoke: http://localhost:8080/SpringProjectTest/rest/users/getuser/1, where 1 = {id}
		ObjectWriter wrapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
		UserFileController userFileController = new UserFileController(PropertyManager.getInstance().getUserDBPath());
		userFileController.readFile();
		User user = userFileController.getUserById(id);
		String json = wrapper.writeValueAsString(user);
		return json;	
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/demo")
	public String getDemoString(){
		//URL to invoke: http://localhost:8080/SpringProjectTest/rest/users/demo
		return "{\"name\":\"String\"}";
	}
	
}

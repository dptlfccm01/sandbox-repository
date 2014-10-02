package com.springprojecttest.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

	private static PropertyManager instance = new PropertyManager();
	
	private String userDBPath;
	private String pollDBPath;
	private String resultDBPath;
	
	private PropertyManager() {
		try{
			Properties prop = new Properties();
			prop.load(new FileInputStream("src/resources/prop.properties"));
			setUserDBPath(prop.getProperty("USERDB"));
			setPollDBPath(prop.getProperty("POLLDB"));
			setResultDBPath(prop.getProperty("RESULTDB"));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static PropertyManager getInstance(){
		if(instance==null){
			instance = new PropertyManager();
		}
		return instance;
	}

	public String getUserDBPath() {
		return userDBPath;
	}

	public String getPollDBPath() {
		return pollDBPath;
	}

	public String getResultDBPath() {
		return resultDBPath;
	}

	public void setUserDBPath(String userDBPath) {
		this.userDBPath = userDBPath;
	}

	public void setPollDBPath(String pollDBPath) {
		this.pollDBPath = pollDBPath;
	}

	public void setResultDBPath(String resultDBPath) {
		this.resultDBPath = resultDBPath;
	}
	
	
	
}

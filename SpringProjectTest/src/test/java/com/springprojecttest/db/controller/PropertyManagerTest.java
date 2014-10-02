package com.springprojecttest.db.controller;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import com.springprojecttest.properties.PropertyManager;

public class PropertyManagerTest {

	@Test
	public void testPropertyManager() throws FileNotFoundException, IOException{
		PropertyManager p = PropertyManager.getInstance();
		System.out.println("OUT> "+p.getPollDBPath());
		System.out.println("OUT> "+p.getUserDBPath());
		System.out.println("OUT> "+p.getResultDBPath());
				
	}

}

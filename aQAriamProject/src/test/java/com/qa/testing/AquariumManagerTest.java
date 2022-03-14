package com.qa.testing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.qa.aQAriamProject.AquariumManager;
import com.qa.aQAriamProject.DBManager;
import com.qa.aQAriamProject.Fish;

public class AquariumManagerTest {
	
	AquariumManager testManager = new AquariumManager();
	DBManager dbManager = new DBManager();
	
	Connection testConn = dbManager.connectDB();
	
	PreparedStatement testState;
	
	// These objects can be used for any tests
	Fish fish1 = new Fish("type1", "colour1", 1, 1.1f);
	Fish fish2 = new Fish("type2", "colour2", 2, 2.1f);
	Fish fish1ID = new Fish(1,"type1", "colour1", 1, 1.1f);
	Fish fish2ID = new Fish(2,"type2", "colour2", 2, 2.1f);
	Fish testFish = new Fish("test-type", "test-colour", 5, 5.0f);
	
	ArrayList<Fish> testList = new ArrayList<Fish>();
	
	@BeforeEach
	public void setup() throws SQLException {
		testList.clear(); // Remove ALL data from our testList
		testState = testConn.prepareStatement("TRUNCATE fish;");
		testState.execute();
		testManager.addFish(fish1);
		testManager.addFish(fish2);
	}
	
	@Test
	public void addFishTest() {
		// Arrange
		
		// Act 
		boolean result = testManager.addFish(testFish);
		
		// Assert
		Assertions.assertTrue(result);
		
	}
	
	// getFishId returns an object of type fish
	@Test
	public void getFishIdTest() {
		
		// Arrange
		int id = 1;
		
		// Act
		Fish result = testManager.getFishId(id);
		
		// Assert - Data FROM a database has an ID
		// Data before pushing to a database has no ID
		System.out.println("***********************************");
		System.out.println(fish1ID);
		System.out.println(result);
		Assertions.assertEquals(fish1ID, result);
//		Assertions.assertTrue(true); DON'T DO THIS. BAD TEST :(
	}
	
	// Returns an arrayList of fish - A public arrayList to use
	@Test
	public void getAllFishTest() {
		
		// Arrange - Generally used when the method takes in a paramater
		// Adding the fish we expect to be in the DB to our arrayList
		testList.add(fish1ID);
		testList.add(fish2ID);
		
		// Act 
		ArrayList<Fish> result = testManager.getAllFish();
		
		// Assert
		Assertions.assertEquals(testList, result);
		
	}

}

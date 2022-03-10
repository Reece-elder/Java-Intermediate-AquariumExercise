package com.qa.testing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.qa.aQAriamProject.AquariumManager;
import com.qa.aQAriamProject.DBManager;
import com.qa.aQAriamProject.Fish;

public class AquariumManagerTest {
	
	AquariumManager testManager = new AquariumManager();
	DBManager dbManager = new DBManager();
	
	Connection testConn = dbManager.connectDB();
	
	PreparedStatement testState;
	
	Fish fish1 = new Fish("type1", "colour1", 1, 1.1f);
	Fish fish2 = new Fish("type2", "colour2", 2, 2.1f);
	
	@BeforeAll
	public void setup() throws SQLException {
		testState = testConn.prepareStatement("TRUNCATE aquarium;");
		testState.execute();
		testManager.addFish(fish1);
		testManager.addFish(fish2);
	}
	
	@Test
	public void addFish() {
		
	}

}

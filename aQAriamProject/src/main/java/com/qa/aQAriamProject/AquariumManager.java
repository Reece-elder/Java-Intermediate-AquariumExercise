package com.qa.aQAriamProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class AquariumManager {

	DBManager manager = new DBManager();

	Connection conn = manager.connectDB();

	PreparedStatement preState;

	private ArrayList<Fish> orderBasket = new ArrayList<Fish>();

	public boolean addFish(Fish fish) {
		try {
			String query = "INSERT INTO fish (type, colour, length, cost) VALUES (?,?,?,?);";
			preState = conn.prepareStatement(query);

			preState.setString(1, fish.getType());
			preState.setString(2, fish.getColour());
			preState.setInt(3, fish.getLength());
			preState.setFloat(4, fish.getCost());
			preState.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public Fish getFishId(int id) {
		try {

			String query = "SELECT * FROM fish WHERE id = ?";
			preState = conn.prepareStatement(query);
			preState.setInt(1, id);

			ResultSet result = preState.executeQuery();
			// Without using result.next() the first line of result are the headers "type", "colour", "length", "cost"
			result.next();
			return manager.convertResults(result);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Fish> getAllFish() {

		// Empty arrayList to be populated with fish
		ArrayList<Fish> fishList = new ArrayList<Fish>();

		try {
			String query = "SELECT * FROM fish";
			preState = conn.prepareStatement(query);
			ResultSet result = preState.executeQuery();

			while (result.next()) {
				// Creating a fish object by converting current line of result to a fish
				Fish newFish = manager.convertResults(result);
				// Add this fish object to the arraylist 
				fishList.add(newFish);
			}
			return fishList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean updateFishById(Fish fish, int id) {
		try {
			String query = "UPDATE fish SET type = ?, colour = ?, length = ?, cost = ? WHERE id = ?";
			preState = conn.prepareStatement(query);
			preState.setString(1, fish.getType());
			preState.setString(2, fish.getColour());
			preState.setInt(3, fish.getLength());
			preState.setFloat(4, fish.getCost());
			preState.setInt(5, id);
			preState.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	// Taking in the object we want to replace everything with 
	// The header we're querying (colour, type, cost etc.) 
	// What we're saying the header equal (WHERE colour = "red")
	public boolean updateFishByQuery(Fish fish, String queryHeader, String value) {

		try {
			String query = "UPDATE fish SET type = ?, colour = ?, length = ?, cost = ? WHERE " + queryHeader + " = ?";
			preState = conn.prepareStatement(query);
			preState.setString(1, fish.getType());
			preState.setString(2, fish.getColour());
			preState.setInt(3, fish.getLength());
			preState.setFloat(4, fish.getCost());
			preState.setString(5, value);
			preState.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean deleteFishById(int id) {
		try {
			String query = "DELETE FROM fish WHERE id = ?";
			preState = conn.prepareStatement(query);
			// executeQuery() - used to return data (querying the database) SELECT * FROM fish..
			// executeUpdate() - used when you're changing the data INSERT INTO, UPDATE, DELETE etc
			preState.setInt(1, id); // setting the value of ? to our id
			preState.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteAllFish() {
		try {
			// What is true of the id value of ALL of my fish (id greater than or equal to 0)
			String query = "DELETE FROM fish where id >= 0"; 
			preState = conn.prepareStatement(query);
			preState.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void addFishToOrderBasket(int id) {
		// TODO - Takes in an ID, finds a fish with that ID and adds it to the
		// orderBasket ArrayList
	}

	public void buyFish() {
		// TODO - Returns the total cost of all fish in the basket and clears the basket
		// STRETCH - Removes the bought fish from the aquarium
	}
	
	// Use 'scanners' to get the user to enter their name, and it will return their name
	// Scanners watch a specific location (console) and wait for input, saving input as a variable
	public String returnUserName() {
		String name;
		
		// Create new scanner called demoScanner
		// demoScanner watches / scans System.in (our console, similar to System.out.printLn("something")) 
		Scanner demoScanner = new Scanner(System.in);
		System.out.println("Please enter a name: ");
		name = demoScanner.nextLine(); // Whatever the next text entered is, save it as variable name
		
		return "hello " + name;
	}
	
	// Do the addFish method, but uses a scanner to get the data
	public void addFishScanner() {
		
		Scanner fishScanner = new Scanner(System.in);
		
		String type;
		String colour;
		int length;
		float cost;
		
		// You don't need to do a system out 
		// If you don't prompt the user to enter data, console would wait for user to do 'something' 
		System.out.println("Please enter type: ");
		type = fishScanner.nextLine();
		
		// inbetween scans do fishScanner.nextLine(); to make sure it stops waiting for input
		fishScanner.nextLine();
		
		System.out.println("Please enter colour: ");
		colour = fishScanner.nextLine();
		
		fishScanner.nextLine();
		
		System.out.println("Please enter length: ");
		length = fishScanner.nextInt(); // converts the text (generally a String) into an int
		
		fishScanner.nextLine();
		
		System.out.println("Please enter cost: ");
		cost = fishScanner.nextFloat();
		
		fishScanner.nextLine();
		
		// making a new fish with the variables we grabbed
		Fish fishToAdd = new Fish(type, colour, length, cost);
		
		// Passing that fish to the addFish method
		addFish(fishToAdd);
		
	}

}

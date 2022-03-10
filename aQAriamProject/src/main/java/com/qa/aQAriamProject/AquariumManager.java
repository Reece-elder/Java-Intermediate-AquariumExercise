package com.qa.aQAriamProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AquariumManager {

	DBManager manager = new DBManager();

	Connection conn = manager.connectDB();

	PreparedStatement preState;

	private ArrayList<Fish> orderBasket = new ArrayList<Fish>();

	public boolean addFish(Fish fish) {
		try {
			String query = "INSERT INTO aquarium (type, colour, length, cost) VALUES (?,?,?,?);";
			preState = conn.prepareStatement(query);

			preState.setString(1, fish.getType());
			preState.setString(2, fish.getColour());
			preState.setInt(3, fish.getLength());
			preState.setFloat(4, fish.getCost());
			preState.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public Fish getFishId(int id) {
		try {

			String query = "SELECT * aquarium WHERE id = ?";
			preState = conn.prepareStatement(query);
			preState.setInt(1, id);

			ResultSet result = preState.executeQuery();
			result.next();
			return manager.convertResults(result);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void getAllFish() {
		// TODO - Returns an arrayList of all fish from DB
	}

	public void updateFishById() {
		// TODO - Updates a fish by ID
	}

	public void updateFishByQuery() {
		// TODO - Updates all fish that match criteria
	}

	public void deleteFishById() {
		// TODO - Deletes a fish by ID
	}

	public void deleteAllFish() {
		// TODO - Deletes all fish
	}

	public void addFishToOrderBasket(int id) {
		// TODO - Takes in an ID, finds a fish with that ID and adds it to the
		// orderBasket ArrayList
	}

	public void buyFish() {
		// TODO - Returns the total cost of all fish in the basket and clears the basket
		// STRETCH - Removes the bought fish from the aquarium
	}

}

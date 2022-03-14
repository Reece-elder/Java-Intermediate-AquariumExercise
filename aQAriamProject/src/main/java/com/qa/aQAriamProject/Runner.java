package com.qa.aQAriamProject;

public class Runner {
	
	public static void main(String[] args) {
		AquariumManager manager = new AquariumManager();
		
//		manager.addFish(new Fish("clown fish", "orange", 12, 2.45f));
//		manager.addFish(new Fish("SeaFoam Splashtail", "ruby red", 8, 2.2f));
		System.out.println(manager.getFishId(1));
		System.out.println(manager.getAllFish());
		manager.updateFishByQuery(new Fish("Trophy BattleGill", "Green", 21, 21.50f), "colour", "orange");
		System.out.println(manager.getFishId(1).getColour());
		System.out.println(manager.getFishId(1).getType());
		
		System.out.println(manager.returnUserName());
		
		manager.addFishScanner();
	}

}

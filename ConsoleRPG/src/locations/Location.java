package locations;

import java.util.Scanner;

import core.Player;

public abstract class Location {
	protected Player player; 
	protected String name;
	public static Scanner input = new Scanner(System.in);
	
	public Location(Player player, String name) {
		this.player = player;
		this.name = name;
	}
	
	// True dönerse oyun devam eder. False dönerse oyuncu ölür.
	public abstract boolean onLocation();

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

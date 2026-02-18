package core;

public class Inventory {
	private Weapon weapon;
	private Armor armor;
	private int bandageCount;
	
	// ödüller
	private boolean water = false;
	private boolean food = false;
	private boolean wood = false;
	
	public Inventory() {
		this.weapon = new Weapon(-1, "Yumruk", 0, 0);
		this.armor = new Armor(-1, "Paçavra", 0, 0);
		this.bandageCount = 1;
		this.water = water;
		this.food = food;
		this.wood = wood;
	}

	// Getters and Setters
	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	public int getBandageCount() {
		return bandageCount;
	}

	public void setBandageCount(int bandageCount) {
		this.bandageCount = bandageCount;
	}

	public boolean isWater() {
		return water;
	}

	public void setWater(boolean water) {
		this.water = water;
	}

	public boolean isFood() {
		return food;
	}

	public void setFood(boolean food) {
		this.food = food;
	}

	public boolean isWood() {
		return wood;
	}

	public void setWood(boolean wood) {
		this.wood = wood;
	}
}

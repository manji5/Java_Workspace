package locations;


import core.Armor;
import core.Player;
import core.Weapon;

public class ToolStore extends Location {
	public ToolStore(Player player) {
		super(player, "Mağaza");
	}
	
	@Override
	public boolean onLocation() {
		System.out.println("--- Mağazaya Hoşgeldiniz! ---");
		boolean showMenu = true;
		while (showMenu) {
			System.out.println("1 - Silahlar");
			System.out.println("2 - Zırhlar");
			System.out.println("3 - Bandaj (5 para)");
			System.out.println("0 - Çıkış Yap");
			System.out.print("Seçiminiz: ");
			int selectCase = Location.input.nextInt();
			
			while (selectCase < 0 || selectCase > 3) {
				System.out.print("Geçersiz değer, tekrar giriniz: ");
				selectCase = Location.input.nextInt();
			}
			
			switch (selectCase) {
				case 1:
					printWeapon();
					buyWeapon();
					break;
					
				case 2:
					printArmor();
					buyArmor();
					break;
					
				case 3:
					buyBandage();
					break;
					
				case 0:
					System.out.println("Bir daha bekleriz!");
					showMenu = false;
					break;
					
				default:
					System.out.println("Lütfen geçerli bir seçim yapınız...");
					break;
			}
		}
		return true;
	}
	
	public void printWeapon() {
		System.out.println("--- Silahlar ---");
		for (Weapon w : Weapon.weapons()) {
			System.out.println(w.getId() + " - " + w.getName() + 
					" <Para: " + w.getPrice() + " | Hasar: " + w.getDamage() + ">");
		}
		
		System.out.println("0 - Çıkış Yap");
	}
	
	public void buyWeapon() {
		System.out.print("Bir silah seçiniz:");
		int selectWeaponID = Location.input.nextInt();
		while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
			System.out.print("Geçersiz değer, tekrar giriniz: ");
			selectWeaponID = Location.input.nextInt();
		}
		
		if (selectWeaponID != 0) {
			Weapon selectedWeapon = Weapon.getWeaponById(selectWeaponID);
			
			if (selectedWeapon != null) {
				if(selectedWeapon .getPrice() > this.getPlayer().getMoney()) {
					System.out.println("Yetersiz bakiye!");
				}
				else {
					System.out.println(selectedWeapon.getName() + " silahini satın aldın.");
					int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
					this.getPlayer().setMoney(balance);
					System.out.println("Kalan Paranız: " + this.getPlayer().getMoney());
					this.getPlayer().getInventory().setWeapon(selectedWeapon);
				}
			}
		}
	}
	
	public void printArmor() {
		System.out.println("--- Silahlar ---");
		for (Armor a : Armor.armors()) {
			System.out.println(a.getId() + " - " + a.getName() + 
					" <Para: " + a.getPrice() + " | Zırh: " + a.getBlock() + ">");
		}
		
		System.out.println("0 - Çıkış Yap");
	}
	
	public void buyArmor() {
		System.out.print("Bir silah seçiniz:");
		int selectArmorID = Location.input.nextInt();
		while (selectArmorID < 0 || selectArmorID > Weapon.weapons().length) {
			System.out.print("Geçersiz değer, tekrar giriniz: ");
			selectArmorID = Location.input.nextInt();
		}
		
		if (selectArmorID != 0) {
			Weapon selectedArmor = Weapon.getWeaponById(selectArmorID);
			
			if (selectedArmor != null) {
				if(selectedArmor .getPrice() > this.getPlayer().getMoney()) {
					System.out.println("Yetersiz bakiye!");
				}
				else {
					System.out.println(selectedArmor.getName() + " silahini satın aldın.");
					int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
					this.getPlayer().setMoney(balance);
					System.out.println("Kalan Paranız: " + this.getPlayer().getMoney());
					this.getPlayer().getInventory().setWeapon(selectedArmor);
				}
			}
		}
	}
	
	public void buyBandage() {
		int bandagePrice = 5;
		if (this.getPlayer().getMoney() >= bandagePrice) {
			this.getPlayer().setMoney(this.getPlayer().getMoney() - bandagePrice);
			this.getPlayer().getInventory().setBandageCount(this.getPlayer().getInventory().getBandageCount() + 1);
			System.out.println("Bandaj satın alındı! Mevcut Bandaj Sayısı: " + this.getPlayer().getInventory().getBandageCount());
		}
		else {
			System.out.println("Yetersiz bakiye!");
		}
	}
}

package locations;

import core.Player;

public class SafeHouse extends Location{
	public SafeHouse(Player player) {
		super(player, "Güvenli Ev");
	}

	@Override
	public boolean onLocation() {
		System.out.println("--------------------------------");
		System.out.println("Güvenli Evdesiniz !");
		System.out.println("Canınız yenilendi !");
		System.out.println("--------------------------------");
		
		this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
		
		if (this.getPlayer().getInventory().isFood() &&
				this.getPlayer().getInventory().isWood() &&
				this.getPlayer().getInventory().isWater()) {
			
			System.out.println("==========================================");
            System.out.println("TEBRİKLER! TÜM ÖDÜLLERİ TOPLADINIZ!");
            System.out.println("ADADAN KURTULDUNUZ VE OYUNU KAZANDINIZ!");
            System.out.println("==========================================");
            
            System.exit(0);;
		}
		
		return true;
	}
}

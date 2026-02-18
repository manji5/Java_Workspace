package locations;

import core.Player;
import obstacles.Obstacle;

public abstract class BattleLoc extends Location {
	private Obstacle obstacle;
	private String awarad;
	private int maxObstacle;
	
	public BattleLoc(Player player, String name, Obstacle obstacle, String awarad, int maxObstacle) {
		super(player, name);
		this.obstacle = obstacle;
		this.awarad = awarad;
		this.maxObstacle = maxObstacle;
	}
	
	@Override
	public boolean onLocation() {
		int obsCount = this.randomObstacleNumber();
		System.out.println("Şuan buradasınız: " + this.getName());
		System.out.println("Dikkatli ol! Burada " + obsCount + " tane " + this.obstacle.getName() + " yaşıyor!");
		System.out.println("<S>avaş veya <K>aç");
		String selectCase = input.nextLine().toUpperCase();
		
		if (selectCase.equals("S") && combat(obsCount)) {
			System.out.println(this.getName() + " bölgesindeki tüm düşmanları yenifiniz!");
			return true;
		}
		
		if (this.getPlayer().getHealth() <= 0) {
			System.out.println("Öldünüz!");
			return false;
		}
		
		return true;
	}
	
	public boolean combat(int obsNumber) {
		for (int i = 1; i <= obsNumber; i++) {
			//her canaver için canavarın canını full'le
			this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
			
			playerStats();
			enemyStats(i);
			
			//savaş döngüsü
			while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
				System.out.println("<V>ur veya <K>aç");
				
				// bandaj gösterme
				if (this.getPlayer().getInventory().getBandageCount() > 0) {
					System.out.println("Sağlık için <B>andaj kullan (Kalan: " + this.getPlayer().getInventory().getBandageCount() + ")");
				}
				
				String selectCombat = input.nextLine().toUpperCase();
				
				if (selectCombat.equals("V")) {
					//%50 şansla ilk vurak kişi
					boolean firstPlayer = Math.random() > 0.5;
					
					if (firstPlayer) {
						//İlk oyuncu
						System.out.println("\nSiz vurdunuz!");
						this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage()); 
						afterHit();
						
						//canavar ölmediyse
						if (this.getObstacle().getHealth() > 0) {
							System.out.println("\nCanavar size vurdu!");
							int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
							if (obstacleDamage < 0) obstacleDamage = 0;
							this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
							afterHit();
						}
					}
					else {
						//ilk canavar
						System.out.println("\nCanavar size vurdu!");
						int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
						if (obstacleDamage < 0) obstacleDamage = 0;
						this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
						afterHit();
						
						//oyuncu ölmediyse
						if(this.getPlayer().getHealth() > 0) {
							System.out.println("\nSiz vurdunuz!");
							this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
							afterHit();
						}
					}
				}
				else if (selectCombat.equals("B")) {
					if (this.getPlayer().getInventory().getBandageCount() > 0) {
						this.getPlayer().setHealth(this.getPlayer().getHealth() + 20);
						if (this.getPlayer().getHealth() > this.getPlayer().getOriginalHealth()) {
							this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
						}
						this.getPlayer().getInventory().setBandageCount(this.getPlayer().getInventory().getBandageCount() - 1);
						System.out.println("Bandaj kullanıldı! Yeni Can: " + this.getPlayer().getHealth());
					}
					else {
						System.out.println("Bandaj yok!");
					}
				}
				else {
					return false;
				}
			}
			
			if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
				System.out.println("--- Düşamnı yendiniz! ---");
				System.out.println(this.getObstacle().getAward() + " para kazandınız!");
				this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
				System.out.println("Güncel Paranız: " + this.getPlayer().getMoney());
			}
			else {
				return false;
			}
			
		}
		
		System.out.println("\n" + this.getName() + " bölgesindeki tüm düşmanları temizledin!");
		
		// Mağara -> Yemek
	    if (this.getName().equals("Mağara") && !this.getPlayer().getInventory().isFood()) {
	        System.out.println("Tebrikler! Ödül: <YEMEK> kazandınız!");
	        this.getPlayer().getInventory().setFood(true);
	    } 
	    // Orman -> Odun
	    else if (this.getName().equals("Orman") && !this.getPlayer().getInventory().isFood()) {
	        System.out.println("Tebrikler! Ödül: <ODUN> kazandınız!");
	        this.getPlayer().getInventory().setFood(true);
	    } 
	    // Nehir -> Su
	    else if (this.getName().equals("Nehir") && !this.getPlayer().getInventory().isWater()) {
	        System.out.println("Tebrikler! Ödül: <SU> kazandınız!");
	        this.getPlayer().getInventory().setWater(true);
	    }

	    return true;
	}
	
	public int randomObstacleNumber() {
		return (int) (Math.random() * this.getMaxObstacle() + 1);
	}
	
	public void afterHit() {
		System.out.println("Canınız: " + this.getPlayer().getHealth());
		System.out.println(this.getObstacle().getName() + " Canı: " + this.getObstacle().getHealth());
		System.out.println("---------------");
	}
	
	public void playerStats() {
        System.out.println("Oyuncu Değerleri");
        System.out.println("-------------------------");
        System.out.println("Sağlık : " + this.getPlayer().getHealth());
        System.out.println("Silah : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Hasar : " + this.getPlayer().getTotalDamage());
        System.out.println("Zırh : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Para : " + this.getPlayer().getMoney());
        System.out.println();
	}
	
	public void enemyStats(int i) {
		System.out.println(i + ". " + this.getObstacle().getName() + " Değerleri");
		System.out.println("-------------------------");
		System.out.println("Sağlık: " + this.getObstacle().getHealth());
		System.out.println("Hasar: " + this.getObstacle().getDamage());
		System.out.println("Ödül: " + this.getObstacle().getAward());
		System.out.println();
	}

	//Getters and Setters
	public Obstacle getObstacle() {
		return obstacle;
	}

	public void setObstacle(Obstacle obstacle) {
		this.obstacle = obstacle;
	}

	public String getAwarad() {
		return awarad;
	}

	public void setAwarad(String awarad) {
		this.awarad = awarad;
	}

	public int getMaxObstacle() {
		return maxObstacle;
	}

	public void setMaxObstacle(int maxObstacle) {
		this.maxObstacle = maxObstacle;
	}
	
}

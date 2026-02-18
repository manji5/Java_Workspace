package core;
import java.util.Scanner;
import locations.*;

public class Game {
	private Scanner input = new Scanner(System.in);
	
	public void start() {
		System.out.println("Macera Oyununa Hoşgeldiniz!");
		System.out.print("Lütfen bir isim giriniz: ");
		
		String playerName = input.nextLine();
		
		Player player = new Player(playerName);
		System.out.println("Sayın " + player.getName() + ", bu karanlık ve sisli adaya hoşgeldiniz!");
		System.out.println("Burada yaşananların hepsi gerçek...");
		
		//Karakter seçimi
		player.selectChar();
		
		//Lokasyon seçimi
		Location location = null;
		
		//Ana döngü
		while (true) {
			System.out.println("\n##### BÖLGELER #####");
			System.out.println("\n1 - Güvenli Ev --> Burası sizin için güvenli bir mekan, düşman yok!" +
					"\n2 - Mağaza --> Silah veya Zırh alabilirsiniz!" +
					"\n3 - Mağara --> Ödül: <Yemek> Dikkatli ol Zombi çıkabilir!" +
					"\n4 - Orman --> Ödül: <Odun> Dikkatli ol Vampir çıkabilir!" +
					"\n5 - Nehir --> Ödül: <Su> Dikkatli ol Ayı çıkabilir!" +
					"\n0 - Çıkış Yap --> Oyun sonlandırır.");
			System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz: ");
			int selectLoc = input.nextInt();
			
			switch (selectLoc) {
				case 0:
					location = null;
					break;
					
				case 1:
					location = new SafeHouse(player);
					break;
					
				case 2:
					//location = new ToolStore(player);
					System.out.println("Mağaza henüz açılmadı");
					location = new ToolStore(player);
					break;
					
				case 3:
					location = new Cave(player);
					break;
					
				case 4:
					location = new Forest(player);
					break;
					
				case 5:
					location = new River(player);
					break;
					
				default:
					System.out.println("Lütfen geçerli bir bölge giriniz!");
					location = new SafeHouse(player);
				
			}
			
			if (location == null) {
				System.out.println("Bu karanlık ve sisli adadan çabuk vazgeçtin!");
				break;
			}
			if (!location.onLocation()) {
				System.out.println("ÖLDÜNÜZ OYUN BİTTİ!");
				break;
			}
		}
		
	}
}

package locations;

import core.Player;
import obstacles.Zombie;

public class Cave extends BattleLoc{
	public Cave(Player player) {
		super(player, "Mağara", new Zombie(), "Yemek", 3);
	}
}

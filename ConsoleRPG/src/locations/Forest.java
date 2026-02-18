package locations;

import core.Player;
import obstacles.Vampire;

public class Forest extends BattleLoc {
	public Forest(Player player) {
		super(player, "Orman", new Vampire(), "Odun", 3);
	}
}

package locations;

import core.Player;
import obstacles.Bear;

public class River extends BattleLoc {
	public River(Player player) {
		super(player, "Nehir", new Bear(), "Su", 2);
	}
}

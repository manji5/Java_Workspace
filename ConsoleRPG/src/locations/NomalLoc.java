package locations;

import core.Player;

public class NomalLoc extends Location {
	public NomalLoc(Player player, String name) {
		super(player, name);
	}
	
	@Override
	public boolean onLocation() {
		return true;
	}
}

package api.java.checker.api;

import com.checker.diamondlink.vars.Values;

public class ValuesRetriever {
	public boolean isOnHypixel() {
		return Values.isOnHypixel;
	}
	public boolean isOnSinglePlayer() {
		return Values.isOnSinglePlayer;
	}
	public String getHypixelGame() {
		return Values.onWhichHypixelGame;
	}
	public boolean isInAWorld() {
		return Values.inAWorld;
	}

}

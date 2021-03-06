package api.java.checker.api;

import java.util.Optional;

import com.checker.diamondlink.module.TriggerConnects;
import com.checker.diamondlink.module.TriggersCheckings;

import net.minecraft.client.multiplayer.ServerData;

public class Manager {
	
	public void autoReconnect(String serverIpToReconnectTo) {
		TriggerConnects.autoConnect(serverIpToReconnectTo);
	}
	
	public void disconnectFromServer(boolean isOnTheServer) {
		TriggerConnects.disconnectFromCurrentServer(isOnTheServer);
	}
	
	public void connectToAServer(Optional<ServerData> serverConnexion) {
		TriggerConnects.connectToServerFromMenu(serverConnexion);
	}
	@Deprecated
	public void upateMapValue() {	//now automatically done so this method is useless now
		TriggersCheckings.triggerHypixelMapUpdate();
	}

}

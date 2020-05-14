package com.checker.diamondlink.module;

import java.util.Optional;

import com.checker.diamondlink.utils.MCUtils;

import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraftforge.fml.client.FMLClientHandler;

public class TriggerConnects {
	
	public static Optional<ServerData> pendingConnection = Optional.empty();
	public static boolean reconnectTriggered = false;
	
	public static void autoConnect(String ip) {
		pendingConnection = Optional.of(new ServerData("Minecraft Server", ip, false));
		reconnectTriggered = true;
	}
	
	public static void disconnectFromCurrentServer(boolean isOnTheServer) {
		if (isOnTheServer) {
			MCUtils.mc.world.sendQuittingDisconnectingPacket();
		}
		MCUtils.mc.loadWorld(null);
		MCUtils.mc.displayGuiScreen(new GuiMainMenu());
	}
	
	public static void connectToServerFromMenu(Optional<ServerData> connexion) {
		if (connexion.isPresent()) {
			final ServerData serverData = connexion.get();

			FMLClientHandler.instance().setupServerList();
			FMLClientHandler.instance().connectToServer(new GuiMainMenu(), serverData);
		}
	}

}

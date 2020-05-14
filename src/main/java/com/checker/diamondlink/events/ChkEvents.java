package com.checker.diamondlink.events;

import java.util.Optional;

import com.checker.diamondlink.module.TriggerConnects;
import com.checker.diamondlink.utils.MCUtils;
import com.checker.diamondlink.vars.*;

import net.minecraft.client.Minecraft;
import net.minecraft.util.StringUtils;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent.ClientConnectedToServerEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent.ClientDisconnectionFromServerEvent;

public class ChkEvents {
	@SubscribeEvent
	public void onChatReceived(ClientChatReceivedEvent event) {
		if (Values.isOnHypixel) {
			
			String receivedMessage = event.getMessage().getFormattedText();
    		String	unformattedReceivedMessage = StringUtils.stripControlCodes(receivedMessage);
    		if (unformattedReceivedMessage.equals(ModVars.lobbyOutput)) {
    			Values.onWhichHypixelGame = "lobby";
    		} else if (unformattedReceivedMessage.equals(ModVars.pitCastleOutput)) {
    			Values.onWhichHypixelGame = "pit castle";
    		} else if (unformattedReceivedMessage.equals(ModVars.pitOutput)) {
    			Values.onWhichHypixelGame = "pit";
    		} else if (unformattedReceivedMessage.equals(ModVars.skyblockHubOutput)) {
    			Values.onWhichHypixelGame = "skyblock hub";
    		} else if (unformattedReceivedMessage.equals(ModVars.skyblockIslandOutput)) {
    			Values.onWhichHypixelGame = "skyblock island";
    		} else if (unformattedReceivedMessage.contains(ModVars.mapOutput)) {
    			Values.onWhichHypixelGame = "unknown";			
    		} else {
    			return;
    		}
    		event.setCanceled(true);
		}
	}
	
	@SubscribeEvent
	public void onServerJoin(ClientConnectedToServerEvent event) {
		Values.inAWorld = true;
		Values.isOnHypixel = false;
		Values.isOnSinglePlayer = false;
		Values.onWhichHypixelGame = null;
		try {
			if (Minecraft.getMinecraft().getCurrentServerData().serverIP.toLowerCase().contains(ModVars.hypixelIPMustContains)) {
				System.out.println("hypixel");
				Values.isOnHypixel = true;
			}
		} catch (Exception e) {
			System.out.println("single");
			Values.isOnSinglePlayer = true;
		}
	}
	
	@SubscribeEvent
	public void onServerLeave(ClientDisconnectionFromServerEvent event) {
		Values.inAWorld = false;
	
		MCUtils.mc.addScheduledTask(() -> {
			TriggerConnects.connectToServerFromMenu(TriggerConnects.pendingConnection);
			TriggerConnects.pendingConnection = Optional.empty();
		});
	}

	@SubscribeEvent
	public void onTick(TickEvent.ClientTickEvent event) {
		if (TriggerConnects.reconnectTriggered) {
			TriggerConnects.reconnectTriggered = false;
			if (Values.inAWorld) {
				TriggerConnects.disconnectFromCurrentServer(true);
			} else {
				TriggerConnects.disconnectFromCurrentServer(false);
				TriggerConnects.connectToServerFromMenu(TriggerConnects.pendingConnection);
				TriggerConnects.pendingConnection = Optional.empty();
			}
		}
	}
}

package com.checker.diamondlink.module;

import com.checker.diamondlink.utils.MCUtils;
import com.checker.diamondlink.vars.Values;

public class TriggersCheckings {

	public static void triggerHypixelMapUpdate() {
		if (Values.isOnHypixel) {
			sendToChatAsClient("/map");
		}
	}
	
	public static void sendToChatAsClient(String messageToSend) {
		MCUtils.getPlayer().sendChatMessage(messageToSend);
	}
}

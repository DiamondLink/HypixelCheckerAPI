package com.checker.diamondlink.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;

public final class MCUtils
{

	public static final Minecraft mc = Minecraft.getMinecraft();
	
	public static EntityPlayerSP getPlayer()
	{
		return mc.player;
	}
	
	public static WorldClient getWorld()
	{
		return mc.world;
	}
	
	public static NetHandlerPlayClient getConnection()
	{
		return getPlayer().connection;
	}
	
	public static boolean isRunningOnMac()
	{
		return Minecraft.IS_RUNNING_ON_MAC;
	}
}

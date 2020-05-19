package com.checker.diamondlink;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.checker.diamondlink.events.ChkEvents;
import com.checker.diamondlink.vars.*;

@Mod(modid = ModVars.MODID, name = ModVars.NAME, version = ModVars.VERSION)
public class HypixelChecker
{
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new ChkEvents());
    }
}

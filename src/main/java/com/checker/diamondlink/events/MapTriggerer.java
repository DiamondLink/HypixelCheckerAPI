package com.checker.diamondlink.events;

import com.checker.diamondlink.module.TriggerConnects;
import com.checker.diamondlink.module.TriggersCheckings;
import com.checker.diamondlink.vars.Values;

public class MapTriggerer extends Thread{
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ChkEvents.allowJoinWorldListener = true;
		Values.gotHypixelMap = false;
		if (Values.isOnHypixel) {
		while (!Values.gotHypixelMap && Values.isOnHypixel) {
			TriggersCheckings.triggerHypixelMapUpdate();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
	}

}

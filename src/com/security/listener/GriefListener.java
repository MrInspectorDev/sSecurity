package com.security.listener;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import com.security.plugin.sSecurity;

public class GriefListener implements Listener {

	sSecurity plugin;

	public GriefListener(sSecurity instance) {
		this.plugin = instance;
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e){		
		plugin.getConfig().getBoolean("DisableBreak");

		if(plugin.getConfig().getBoolean("DisableBreak") == true) {
			e.setCancelled(true);
			e.getPlayer().sendMessage(ChatColor.GREEN + "Breaking / Placing has been disabled!");
		}
		
		if(plugin.getConfig().getBoolean("DisableBreak") == false) {
			e.setCancelled(false);
		}
		
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e){		
		plugin.getConfig().getBoolean("DisablePlace");

		if(plugin.getConfig().getBoolean("DisablePlace") == true) {
			e.setCancelled(true);
			e.getPlayer().sendMessage(ChatColor.GREEN + "Breaking / Placing has been disabled!");
		}
		
		if(plugin.getConfig().getBoolean("DisablePlace") == false) {
			e.setCancelled(false);
		}
		
	}
	
}

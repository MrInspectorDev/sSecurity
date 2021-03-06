package com.security.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

import com.security.plugin.sSecurity;

public class ExplodeListener implements Listener {

	sSecurity plugin;

	public ExplodeListener(sSecurity instance) {
		this.plugin = instance;
	}
	
	@EventHandler
	public void onExplode(EntityExplodeEvent e){
		plugin.getConfig().getBoolean("DisableExplosion");

		if(plugin.getConfig().getBoolean("DisableExplosion") == true) {
			e.setCancelled(true);
			Bukkit.broadcastMessage(ChatColor.RED + "Creeper explosions has been disabled!");
		}
		
		if(plugin.getConfig().getBoolean("DisableExplosion") == false) {
			e.setCancelled(false);
		}
	}
	
}

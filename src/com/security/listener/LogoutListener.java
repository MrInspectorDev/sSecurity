package com.security.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.security.list.AntiLog;
import com.security.plugin.sSecurity;

public class LogoutListener implements Listener {

	sSecurity plugin;

	public LogoutListener(sSecurity instance) {
		this.plugin = instance;
	}
		
	@EventHandler
	public void leaveListener(PlayerQuitEvent event){
		Player p = event.getPlayer();
		if (AntiLog.antilog.contains(p.getName())){
			Bukkit.getServer().broadcastMessage(ChatColor.GRAY + p.getName() + " has combat logged and a villager has been spawned!");
			p.damage(21.0);
			Bukkit.getServer().getWorld("world").spawnEntity(p.getLocation(), EntityType.VILLAGER);
		}
	}
	
}

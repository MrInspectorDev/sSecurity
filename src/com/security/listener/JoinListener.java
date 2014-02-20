package com.security.listener;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.security.plugin.sSecurity;
import com.security.util.Util;

public class JoinListener implements Listener {

	sSecurity plugin;

	public JoinListener(sSecurity instance) {
		this.plugin = instance;
	}

	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
	String blacklist = plugin.getConfig().getString("Blacklist");
		if(e.getPlayer().getName().contains(blacklist)){
			e.getPlayer().kickPlayer(ChatColor.RED + "You have been blacklisted from this server!");
		}
	}
	
	@EventHandler
	public void onJoinIP(PlayerJoinEvent e){
		if(e.getPlayer().hasPermission("ssecurity.joinip")){
			e.getPlayer().sendMessage(ChatColor.GRAY + e.getPlayer().getName() + " has joined with the IP " + ChatColor.GOLD + Util.getPlayerIp(e.getPlayer()));
		}
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		String path = "Joins";
		plugin.getConfig().set(path, plugin.getConfig().getInt(path) + 1);
		plugin.saveConfig();
	}
	
}

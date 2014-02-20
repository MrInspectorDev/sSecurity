package com.security.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;

import com.security.plugin.sSecurity;

public class ExpListener implements Listener {
	
	sSecurity plugin;

	public ExpListener(sSecurity instance) {
		this.plugin = instance;
	}

	@EventHandler
	public void onExpChange(PlayerExpChangeEvent e){
		plugin.getConfig().getBoolean("DisableEXP");

		if(plugin.getConfig().getBoolean("DisableEXP") == true) {
			e.setAmount(0);
			Bukkit.broadcastMessage(ChatColor.RED + "EXP has been disabled!");
		}
		
		if(plugin.getConfig().getBoolean("DisableEXP") == false) {
			int exp = e.getAmount();
			e.setAmount(exp);
			Bukkit.broadcastMessage(ChatColor.GREEN + "EXP has been enabled!");
		}
	}
}
	


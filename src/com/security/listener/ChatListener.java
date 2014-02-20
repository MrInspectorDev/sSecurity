package com.security.listener;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.security.plugin.sSecurity;

public class ChatListener implements Listener {

	sSecurity plugin;

	public ChatListener(sSecurity instance) {
		this.plugin = instance;
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
	
	String blockedwords = plugin.getConfig().getString("BlockedWords");
		
	if(e.getMessage().contains(blockedwords)){
		e.setCancelled(true);
		e.getPlayer().sendMessage(ChatColor.RED + "That word has been blocked!");
	}
		
	}
	
}

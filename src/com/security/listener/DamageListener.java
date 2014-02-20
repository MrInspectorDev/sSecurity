package com.security.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.security.list.AntiLog;
import com.security.plugin.sSecurity;

public class DamageListener extends JavaPlugin implements Listener {

	sSecurity plugin;

	public DamageListener(sSecurity instance) {
		this.plugin = instance;
	}
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent event){
		if ((event.getDamager() instanceof Player) && ((event.getEntity() instanceof Player))){
			final Player player = (Player)event.getEntity();
			final Player target = (Player)event.getDamager();
			
			if ((!AntiLog.antilog.contains(player.getName())) && (!AntiLog.antilog.contains(target.getName()))) {
				AntiLog.antilog.add(player.getName());
				AntiLog.antilog.add(target.getName());
				player.sendMessage(ChatColor.GOLD + "You're now in " + ChatColor.UNDERLINE + "Combat!");
				target.sendMessage(ChatColor.GOLD + "You're now in " + ChatColor.UNDERLINE + "Combat!");
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					public void run() {
						if ((AntiLog.antilog.contains(player.getName())) && (AntiLog.antilog.contains(target.getName()))) {
							AntiLog.antilog.remove(player.getName());
							AntiLog.antilog.remove(target.getName());
							target.sendMessage(ChatColor.GREEN + "You can now log out safely.");
							player.sendMessage(ChatColor.GREEN + "You can now log out safely.");
							
					}
		}
	}
	, 1000L);
	}
		}
}
}
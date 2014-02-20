package com.security.plugin;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.security.listener.ChatListener;
import com.security.listener.DamageListener;
import com.security.listener.ExpListener;
import com.security.listener.ExplodeListener;
import com.security.listener.GriefListener;
import com.security.listener.JoinListener;
import com.security.listener.LogoutListener;

public class sSecurity extends JavaPlugin implements Listener {

	public void onEnable() {
		
		// Enabling
		
		System.out.println("Loading plugin...");
		
		// Register events
			
		System.out.println("Registering events...");
		
		Bukkit.getPluginManager().registerEvents(new JoinListener(this), this);
		Bukkit.getPluginManager().registerEvents(new ChatListener(this), this);
		Bukkit.getPluginManager().registerEvents(new GriefListener(this), this);
		Bukkit.getPluginManager().registerEvents(new ExplodeListener(this), this);
		Bukkit.getPluginManager().registerEvents(new ExpListener(this), this);
		Bukkit.getPluginManager().registerEvents(new LogoutListener(this), this);
		Bukkit.getPluginManager().registerEvents(new DamageListener(this), this);

		// Generate config
		
	    getConfig().options().copyDefaults(true);
	    saveConfig();
	    
	    System.out.println("Generated config...");

		// Loaded plugin
		
		System.out.println("sSecurity loaded in!");
		
	}
		
}

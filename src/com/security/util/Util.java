package com.security.util;

import org.bukkit.entity.Player;

public class Util {

	public static String getPlayerIp(Player p){
	    return p.getAddress().getAddress().getHostAddress();
	}
	
	public static String getServerIp(Player p){
	    return p.getServer().getIp();
	}
}

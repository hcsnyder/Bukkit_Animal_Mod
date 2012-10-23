package com.github.hsnyder1.BukkitPlugin1;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.Listener;

public class BukkitPluginListener implements Listener{

	private final BukkitPlugin1 plugin;
	
	public BukkitPluginListener(BukkitPlugin1 plugin) {
		
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		String p = event.getPlayer().getName();
		int players = event.getPlayer().getServer().getOfflinePlayers().length;
		event.getPlayer().sendMessage("Hello " + p +"!");
		if(players > 1) {
			event.getPlayer().sendMessage("There are " + players + " players on this server.");
		}
		else {
			event.getPlayer().sendMessage("Aww, you're the only player on this server!");
		}
	}
	
	@EventHandler
	public void tombstone(PlayerRespawnEvent event) {
		if(event.getPlayer().getKiller() != null) {
			Block grave = event.getPlayer().getLocation().getBlock().getRelative(0, 1, 0);
			String dead = event.getPlayer().getName();
			String killer = event.getPlayer().getKiller().getName();
			if( grave != null) {
				grave.setType(Material.SIGN_POST);
				Sign message = (Sign) grave.getLocation().getBlock();
				message.setLine(0, "Here lies");
				message.setLine(1, dead);
				message.setLine(2, "Killed By" + killer);
				message.setLine(3, "RIP");
			}
			
		}
	}
}

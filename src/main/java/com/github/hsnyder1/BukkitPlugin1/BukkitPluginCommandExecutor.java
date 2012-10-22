package com.github.hsnyder1.BukkitPlugin1;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class BukkitPluginCommandExecutor implements CommandExecutor{

private final BukkitPlugin1 plugin;
	
	public BukkitPluginCommandExecutor(BukkitPlugin1 plugin) {
		this.plugin = plugin;		
	}
	
	public boolean onCommand(CommandSender sender, Command command, 
			String label, String[] args) {
		if(args.length ==0) {
			return false;
		}
		else if(!(sender instanceof Player)){
			return false;
		}
		//returns position of player
		else if (args[0].equalsIgnoreCase("position")) {
			Player p = (Player) sender;
			Location loc = p.getLocation();
			p.sendMessage("You are at X: " + loc.getX() + " Y: " + 
			loc.getY() + " Z: " + loc.getZ());
			return true;
		}
		//tells player num,ber of players on server
		else if(args[0].equalsIgnoreCase("numPlayers")) {
			Player p = (Player) sender;
			int players = p.getServer().getOnlinePlayers().length;
			if(players > 1) {
				p.sendMessage("There are " + players + " players on this server");
			}
			else {
				p.sendMessage("Aww, you're the only player on this server!");
			}
			return true;
		}
		//heals the player to full health
		else if(args[0].equalsIgnoreCase("heal")) {
			Player p = (Player) sender;
			p.setHealth(p.getMaxHealth());
			return true;
		}
		else {
			return false;
		}
	}
}

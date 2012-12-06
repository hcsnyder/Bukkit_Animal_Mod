package com.github.hsnyder1.Bukkit_Animal_Mod;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class BukkitPluginCommandExecutor implements CommandExecutor{

private final Bukkit_Animal_Mod plugin;
	
	public BukkitPluginCommandExecutor(Bukkit_Animal_Mod plugin) {
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
		else if (args[0].equalsIgnoreCase("give_me_leash")) {
			Player p = (Player) sender;
			int isNumber;
			String num = args[1].toString();
			try {
				isNumber = Integer.parseInt(num);
				ItemStack I = new ItemStack(Material.IRON_INGOT, isNumber);
				ItemStack L = new ItemStack(Material.LEATHER, (isNumber*2));
				p.getInventory().addItem(I);
				p.getInventory().addItem(L);
				p.sendMessage("Go make it yourself");
			}
			catch (NumberFormatException e) {
				isNumber = 0;
				p.sendMessage("That is not a number");
			}
			return true;
		}	
		else if(args[0].equalsIgnoreCase("give_me_saddle")) {
			Player p = (Player) sender;
			int isNumber;
			String num = args[1].toString();
			try {
				isNumber = Integer.parseInt(num);
				ItemStack S = new ItemStack(Material.SADDLE, isNumber);
				p.getInventory().addItem(S);
				p.sendMessage("Here you go!");
			}
			catch (NumberFormatException e){
				isNumber = 0;
				p.sendMessage("That is not a number");
			}
			return true;
		}
		else if(args[0].equalsIgnoreCase("give_me_bone")) {
			Player p = (Player) sender;
			int isNumber;
			String num = args[1].toString();
			try {
				isNumber = Integer.parseInt(num);
				ItemStack S = new ItemStack(Material.BONE, isNumber);
				p.getInventory().addItem(S);
				p.sendMessage("Here you go! Dogs are awesome");
			}
			catch (NumberFormatException e){
				isNumber = 0;
				p.sendMessage("That is not a number");
			}
			return true;
		}
		else if(args[0].equalsIgnoreCase("give_me_fish")) {
			Player p = (Player) sender;
			int isNumber;
			String num = args[1].toString();
			try {
				isNumber = Integer.parseInt(num);
				ItemStack S = new ItemStack(Material.RAW_FISH, isNumber);
				p.getInventory().addItem(S);
				p.sendMessage("Here you go, but you should reevaluate your options.");
				p.sendMessage("You know, because cats are stupid.");
			}
			catch (NumberFormatException e){
				isNumber = 0;
				p.sendMessage("That is not a number");
			}
			return true;
		}
		else if(args[0].equalsIgnoreCase("number_of_entities")) {
			Player p = (Player) sender;
			List<Entity> e = p.getNearbyEntities(30, 5, 30);
			int numEnt = e.size();
			p.sendMessage("There are " + numEnt + " entities around you");
			return true;
		}
		else {
			return false;
		}
	}
}

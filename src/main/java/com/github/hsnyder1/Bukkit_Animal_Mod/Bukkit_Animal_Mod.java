package com.github.hsnyder1.Bukkit_Animal_Mod;

import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.inventory.SpoutShapedRecipe;
import org.getspout.spoutapi.material.MaterialData;

public class Bukkit_Animal_Mod extends JavaPlugin{
	public Leash_item Leash;

	
	@Override
	public void onEnable() {
		
		SpoutManager.getFileManager().addToPreLoginCache(this, "http://server.drewproctor.com/holly/leash.png");
		Leash = new Leash_item(this);
		addLeashRecipe();
		
		saveDefaultConfig();
		
		new BukkitPluginListener(this);
		
		this.getCommand("plugin").setExecutor(new BukkitPluginCommandExecutor(this));
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public void addLeashRecipe() {
		SpoutItemStack item = new SpoutItemStack(Leash);
		SpoutShapedRecipe recipe = new SpoutShapedRecipe(item);
		recipe.shape("  I", " L ", "L  ");
		recipe.setIngredient('I', MaterialData.ironIngot);
		recipe.setIngredient('L', MaterialData.leather);
		SpoutManager.getMaterialManager().registerSpoutRecipe(recipe);
	}
}

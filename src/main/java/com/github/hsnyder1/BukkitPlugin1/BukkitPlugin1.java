package com.github.hsnyder1.BukkitPlugin1;

import org.bukkit.plugin.java.JavaPlugin;

public class BukkitPlugin1 extends JavaPlugin{

	BukkitPluginLogger logger;
	
	@Override
	public void onEnable() {
		
		logger = new BukkitPluginLogger(this);
		logger.info("plugin enabled!");
		
		saveDefaultConfig();
		
		new BukkitPluginListener(this);
		
		this.getCommand("plugin").setExecutor(new BukkitPluginCommandExecutor(this));
	}
	
	@Override
	public void onDisable() {
		logger.info("plugin Disabled!");
	}
}

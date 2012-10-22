package com.github.hsnyder1.BukkitPlugin1;

import org.bukkit.plugin.java.JavaPlugin;

public class BukkitPlugin1 extends JavaPlugin{

	@Override
	public void onEnable() {
		
		saveDefaultConfig();
		
		this.getCommand("plugin").setExecutor(new BukkitPluginCommandExecutor(this));
	}
}

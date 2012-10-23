package com.github.hsnyder1.BukkitPlugin1;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;

public class BukkitPluginLogger {

	private final BukkitPlugin1 plugin;
	private final Logger logger;
	
	public BukkitPluginLogger(BukkitPlugin1 plugin) {
		this.plugin = plugin;
		logger = Logger.getLogger("Minecraft");
	}
	
	private String buildMessage(String message) {
		PluginDescriptionFile yml = plugin.getDescription();
		String output = yml.getName() + yml.getVersion() + ": " + message;
		return output;
	}
	
	public void info(String msg) {
		logger.info(this.buildMessage(msg));
	}
	
	public void warn(String msg) {
		logger.warning(this.buildMessage(msg));
	}
	
	public void severe(String msg) {
		logger.severe(this.buildMessage(msg));
	}
}

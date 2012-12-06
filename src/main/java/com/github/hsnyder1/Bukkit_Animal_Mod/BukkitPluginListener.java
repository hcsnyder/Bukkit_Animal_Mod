package com.github.hsnyder1.Bukkit_Animal_Mod;


import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;;

public class BukkitPluginListener implements Listener{

	private final Bukkit_Animal_Mod plugin;
	
	public BukkitPluginListener(Bukkit_Animal_Mod plugin) {
		
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		
		this.plugin = plugin;
	}
	
	@EventHandler
	public void rideAnimal(PlayerInteractEntityEvent event) {
		Player p = event.getPlayer();
		ItemStack i = p.getItemInHand();
		Entity e = event.getRightClicked();
		if(i.getType() == Material.SADDLE) {
			if(e.getType() == EntityType.SHEEP) {
				e.setPassenger(p);
			}
			else if(e.getType() == EntityType.COW) {
				e.setPassenger(p);
			}
			else if(e.getType() == EntityType.CHICKEN) {
				e.setPassenger(p);
			}
			else if(e.getType() == EntityType.SQUID) {
				e.setPassenger(p);
			}
			else if(e.getType() == EntityType.WOLF) {
				e.setPassenger(p);
			}
			else if(e.getType() == EntityType.MUSHROOM_COW) {
				e.setPassenger(p);
			}
			else if(e.getType() == EntityType.OCELOT) {
				e.setPassenger(p);
			}
			else if(e.getType() == EntityType.IRON_GOLEM) {
				e.setPassenger(p);
			}
			else if(e.getType() == EntityType.VILLAGER) {
				e.setPassenger(p);
			}
		}
	}
	
}

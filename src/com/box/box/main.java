package com.box.box;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {

		ConsoleCommandSender consol = Bukkit.getConsoleSender();

		consol.sendMessage(ChatColor.AQUA + "durayMailBox Starting..! Loading mailbox");
		getServer().getPluginManager().registerEvents(this, this);
		
		this.saveDefaultConfig();
		loadConfig();
	}
	
	public static void loadConfig() {
		main.getPlugin(main.class).getConfig().options().copyDefaults(true);
		main.getPlugin(main.class).saveConfig();
	}
	
	@Override
	public void onDisable() {
		
	}
	
	@EventHandler
	public void OnCHestOpen(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(e.getClickedBlock().getType() == Material.CHEST) {
				MailBox.GetMyBox(p);
				e.setCancelled(true);
			}
		}
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		

		if(cmd.getName().equalsIgnoreCase("tec")) {

			MailBox.Test123(Bukkit.getPlayer(sender.getName()));
			Bukkit.broadcastMessage(ChatColor.WHITE + "test successful");
		}
		
		if(cmd.getName().equalsIgnoreCase("wan")) {
			Display.ShowBox(Bukkit.getPlayer(sender.getName()));
		}
		
		
		
		return false;
		
	}
}

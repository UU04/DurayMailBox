package com.box.box;

import java.util.stream.Stream;

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
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
		    @Override
		    public void run() {
		        datetime.getdatetime();
		    }
		}, 0L, 10L);
		
		ConsoleCommandSender consol = Bukkit.getConsoleSender();

		consol.sendMessage(ChatColor.AQUA + "durayMailBox Enabled");
		getServer().getPluginManager().registerEvents(this, this);
		
		this.saveDefaultConfig();
		loadConfig();
		String[] leng = this.getConfig().toString().split("\n");
		if(this.getConfig().toString().length() <= 1) {
			consol.sendMessage(ChatColor.RED + "DurayMailBox has loaded no data from history file. Maybe data loss? Administrator recommended to take a look.");
		} else {
			consol.sendMessage(ChatColor.YELLOW + "DurayMailBox loaded " + leng.length + " lines from saved data file.");
		}
	}
	
	public static void loadConfig() {
		main.getPlugin(main.class).getConfig().options().copyDefaults(true);
		main.getPlugin(main.class).saveConfig();
	}
	
	@Override
	public void onDisable() {
	}
	
	@EventHandler
	public void OnChestOpen(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(e.getClickedBlock().getType() == Material.CHEST) {
				e.setCancelled(true);
//				MailBox.GetMyBox(p);
				Display.ShowBox(p);
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
	
	@EventHandler
	public void OnInvenClick(InventoryClickEvent e) {
		Player p = Bukkit.getPlayer(e.getWhoClicked().getName());
		if(e.getInventory().getName().contains("MAIL")) {
			e.setCancelled(true);
		}
	}
}

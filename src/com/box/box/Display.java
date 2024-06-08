package com.box.box;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.*;


public class Display {
	public static Inventory box = Bukkit.createInventory(null, 27, ChatColor.RED + "¡á " + ChatColor.GREEN + "MAIL BOX" + ChatColor.RED +  " ¡á");
	public static FileConfiguration config = MailBox.config;
	
	
	public static void ShowBox(Player p) {
		if(config.get("NetService."+p.getUniqueId()+".RecentMailID") == null) return;
		String a = config.get("NetService."+p.getUniqueId()+".RecentMailID").toString();
		int inboxcount = Integer.parseInt(a);
		
		box.clear();
		
		for (int i = 1; i < inboxcount + 1; i++) {
			String FromWhoName = config.getString("MailBox." + p.getUniqueId()+ "." + i).split("/")[1]; // SYSTEM
			String DateTime = config.getString("MailBox." + p.getUniqueId() + "." + i).split("/")[2]; //20220101
			String msg = config.getString("MailBox." + p.getUniqueId() + "." + i).split("/")[3]; //¾È³çÇÏ¼¼¿ä
			
			ItemStack item = new ItemStack(Material.PAPER);
            ItemMeta meta = item.getItemMeta();
            
            meta.setDisplayName("MAIL FROM :: " + ChatColor.AQUA +FromWhoName);
            meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.setLore(Arrays.asList(ChatColor.GRAY + DateTime, " ", 
            					ChatColor.WHITE + msg, " ", " ",
            							ChatColor.YELLOW + "Left Click to dismiss this message"));
            item.setItemMeta(meta);
            
            box.setItem(i*2 -2, item);
		}
		
		p.openInventory(box);
	}
}

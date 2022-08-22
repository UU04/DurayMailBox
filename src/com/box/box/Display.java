package com.box.box;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import net.minecraft.server.v1_12_R1.ItemStack;

public class Display {
	public static Inventory box = Bukkit.createInventory(null, 18, ChatColor.RED + "бс " + ChatColor.GREEN + "MAIL BOX" + ChatColor.RED +  " бс");
	
	public static void ShowBox(Player p) {
		p.openInventory(box);
	}
}

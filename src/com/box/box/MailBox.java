package com.box.box;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class MailBox {
	public static String date = datetime.TotalDate;
	public static String time = datetime.TotalTime;
	public static FileConfiguration config = main.getPlugin(main.class).getConfig();
	public static int a = 0;
	public static void Test123(Player p) {
		a++;
		config.set("MailBox." + p.getUniqueId() + "."+a, "<"+p.getDisplayName()+">/SYSTEM/20220101/æ»≥Á«œººø‰");
		config.set("NetService."+p.getUniqueId()+".RecentMailID", a);
		
		main.getPlugin(main.class).saveConfig();
	}
	
	public static void GetMyBox(Player p) {
		//MailBox . UUID . ID. <NAME>/FROM(UUID)/DATETIME/MESSAGE
		//MailBox : 543aa95c-b830-4f8a-9fdb-c28232ec659e : '1' : <UU_04>/SYSTEM/20220101/æ»≥Á«œººø‰
		
		String msgID = config.getString("NetService."+p.getUniqueId()+".RecentMailID"); // 1
		
		String howMany = msgID;
		
		p.sendMessage(howMany + " messages inbox.");
		
		
		for (int i = 1; i < Integer.parseInt(msgID)+ 1; i++) {
			String ToWhoName = config.getString("MailBox." + p.getUniqueId()+ "." + i).split("/")[0].replace("<", "").replace(">",""); //UU_04
			String ToWhoUUID = p.getUniqueId().toString(); // 543aa95c-b830-4f8a-9fdb-c28232ec659e
			
			String FromWhoUUID = config.getString("MailBox." + p.getUniqueId()+ "." + i).split("/")[1]; // SYSTEM
			String DateTime = config.getString("MailBox." + p.getUniqueId() + "." + i).split("/")[2]; //20220101
			String msg = config.getString("MailBox." + p.getUniqueId() + "." + i).split("/")[3]; //æ»≥Á«œººø‰
			
			p.sendMessage("");
			p.sendMessage(ChatColor.WHITE + "To " + ToWhoName + ": ");
			p.sendMessage("              " + ChatColor.WHITE + msg);
			p.sendMessage(ChatColor.WHITE + "From " + FromWhoUUID + ChatColor.GRAY + "[" + DateTime + "] - " + i + " of " + msgID);
			p.sendMessage("");
			
			
		}
	}
}

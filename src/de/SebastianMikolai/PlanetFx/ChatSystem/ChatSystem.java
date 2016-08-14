package de.SebastianMikolai.PlanetFx.ChatSystem;

import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.SebastianMikolai.PlanetFx.ChatSystem.Channels.AdminCommandListener;

public class ChatSystem extends JavaPlugin {

	private static ChatSystem instance;
	public boolean enable_chat;
	public String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "Chat" + ChatColor.DARK_GRAY + "] ";

	public static ChatSystem getInstance() {
		return instance;
	}
	
	@Override
	public void onEnable() {
		instance = this;
		saveDefaultConfig();
		getCommand("chat").setExecutor(new CommandListener());
		getCommand("a").setExecutor(new AdminCommandListener());
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new EventListener(), this);
		enable_chat = true;
	}
}
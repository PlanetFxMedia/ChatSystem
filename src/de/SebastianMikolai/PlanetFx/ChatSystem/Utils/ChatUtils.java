package de.SebastianMikolai.PlanetFx.ChatSystem.Utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ChatUtils {

	public static void broadcastMessage(String msg) {
		Bukkit.broadcastMessage(msg);
	}
	
	public static void broadcastWorldMessage(Player p, String msg) {
		for (Player player : p.getWorld().getPlayers()) {
			player.sendMessage(msg);
		}
	}
	
	public static void broadcastAdminChannel(String msg) {
		for (Player player : Bukkit.getOnlinePlayers()) {
			if (player.hasPermission("pfx.chatsystem.channel.admin")) {
				player.sendMessage(msg);
			}
		}
	}
}
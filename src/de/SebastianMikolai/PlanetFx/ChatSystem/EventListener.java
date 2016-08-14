package de.SebastianMikolai.PlanetFx.ChatSystem;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class EventListener implements Listener {

	@EventHandler
	public void onAsyncPlayerChatEvent(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if (ChatSystem.getInstance().enable_chat == true) {
			e.setFormat(ChatColor.GRAY + "%1$s: %2$s");
			if (p.hasPermission("pfx.chatsystem.prefix.vip")) {
				e.setFormat(ChatColor.AQUA + "Vip" + ChatColor.GRAY + "| " +  ChatColor.WHITE  + "%1$s: %2$s");
			}
			
			if (p.hasPermission("pfx.chatsystem.prefix.tribut")) {
				e.setFormat(ChatColor.GREEN + "Tribut" + ChatColor.GRAY + "| " +  ChatColor.WHITE  + "%1$s: %2$s");
			}
			if (p.hasPermission("pfx.chatsystem.prefix.favorit")) {
				e.setFormat(ChatColor.BLUE + "Favorit" + ChatColor.GRAY + "| " +  ChatColor.WHITE  + "%1$s: %2$s");
			}
			if (p.hasPermission("pfx.chatsystem.prefix.sieger")) {
				e.setFormat(ChatColor.LIGHT_PURPLE + "Sieger" + ChatColor.GRAY + "| " +  ChatColor.WHITE  + "%1$s: %2$s");
			}
			if (p.hasPermission("pfx.chatsystem.prefix.champion")) {
				e.setFormat(ChatColor.GOLD + "Champion" + ChatColor.GRAY + "| " +  ChatColor.WHITE  + "%1$s: %2$s");
			}
			
			if (p.hasPermission("pfx.chatsystem.prefix.team")) {
				e.setFormat(ChatColor.GOLD + "[" + ChatColor.DARK_GREEN + "Team" + ChatColor.GOLD + "] " + ChatColor.DARK_GREEN + "%1$s: " + ChatColor.WHITE + "%2$s");
			}
			if (p.hasPermission("pfx.chatsystem.prefix.mod")) {
				e.setFormat(ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + "Mod" + ChatColor.DARK_GRAY + "] " + ChatColor.BLUE + "%1$s: " + ChatColor.WHITE + "%2$s");
				e.setMessage(ChatColor.translateAlternateColorCodes('&', e.getMessage()));
			}
			if (p.hasPermission("pfx.chatsystem.prefix.smod")) {
				e.setFormat(ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + "SMod" + ChatColor.DARK_GRAY + "] " + ChatColor.BLUE + "%1$s: " + ChatColor.WHITE + "%2$s");
				e.setMessage(ChatColor.translateAlternateColorCodes('&', e.getMessage()));
			}
			if (p.hasPermission("pfx.chatsystem.prefix.admin")) {
				e.setFormat(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "Admin" + ChatColor.GOLD + "] " + ChatColor.DARK_RED + "%1$s: " + ChatColor.RED + "%2$s");
				e.setMessage(ChatColor.translateAlternateColorCodes('&', e.getMessage()));
			}
			if (p.hasPermission("pfx.chatsystem.prefix.leitung")) {
				e.setFormat(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "Leitung" + ChatColor.GOLD + "] " + ChatColor.DARK_RED + "%1$s: %2$s");
				e.setMessage(ChatColor.translateAlternateColorCodes('&', e.getMessage()));
			}
		} else {
			if (!p.hasPermission("pfx.chatsystem.deaktiviert.canchat")) {
				e.setCancelled(true);
				p.sendMessage(ChatColor.RED + "Der Chat ist deaktiviert!");
			} else {
				p.sendMessage(ChatColor.RED + "[Deaktiviert] Normale Spieler können nicht schreiben!");
				e.setFormat(ChatColor.GRAY + "%1$s: %2$s");
				if (p.hasPermission("pfx.chatsystem.prefix.vip")) {
					e.setFormat(ChatColor.AQUA + "Vip" + ChatColor.GRAY + "| " +  ChatColor.WHITE  + "%1$s: %2$s");
				}
				if (p.hasPermission("pfx.chatsystem.prefix.team")) {
					e.setFormat(ChatColor.GOLD + "[" + ChatColor.DARK_GREEN + "Team" + ChatColor.GOLD + "] " + ChatColor.DARK_GREEN + "%1$s: " + ChatColor.WHITE + "%2$s");
				}
				if (p.hasPermission("pfx.chatsystem.prefix.mod")) {
					e.setFormat(ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + "Mod" + ChatColor.DARK_GRAY + "] " + ChatColor.BLUE + "%1$s: " + ChatColor.WHITE + "%2$s");
					e.setMessage(ChatColor.translateAlternateColorCodes('&', e.getMessage()));
				}
				if (p.hasPermission("pfx.chatsystem.prefix.smod")) {
					e.setFormat(ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + "SMod" + ChatColor.DARK_GRAY + "] " + ChatColor.BLUE + "%1$s: " + ChatColor.WHITE + "%2$s");
					e.setMessage(ChatColor.translateAlternateColorCodes('&', e.getMessage()));
				}
				if (p.hasPermission("pfx.chatsystem.prefix.admin")) {
					e.setFormat(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "Admin" + ChatColor.GOLD + "] " + ChatColor.DARK_RED + "%1$s: " + ChatColor.RED + "%2$s");
					e.setMessage(ChatColor.translateAlternateColorCodes('&', e.getMessage()));
				}
				if (p.hasPermission("pfx.chatsystem.prefix.leitung")) {
					e.setFormat(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "Leitung" + ChatColor.GOLD + "] " + ChatColor.DARK_RED + "%1$s: %2$s");
					e.setMessage(ChatColor.translateAlternateColorCodes('&', e.getMessage()));
				}
			}
		}
	}
	
	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent e) {
		e.setJoinMessage("");
	}
	
	@EventHandler
	public void onPlayerQuitEvent(PlayerQuitEvent e) {
		e.setQuitMessage("");
	}
}
package de.SebastianMikolai.PlanetFx.ChatSystem.Channels;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.SebastianMikolai.PlanetFx.ChatSystem.Utils.ChatUtils;

public class AdminCommandListener implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (cs instanceof Player) {
			Player p = (Player) cs;
			if (p.hasPermission("pfx.chat.channel.admin")) {
				if (args.length > 0) {
					String msg = "";
					for (String arg : args) {
						if (msg == "") {
							msg = arg;
						} else {
							msg = msg + " " + arg;
						}
					}
					if (p.hasPermission("pfx.chat.prefix.admin")) {
						if (p.hasPermission("pfx.chat.prefix.leitung")) {
							ChatUtils.broadcastAdminChannel(ChatColor.DARK_RED + "[A] " + ChatColor.GOLD + "[" + ChatColor.DARK_RED + "Leitung" + ChatColor.GOLD + "] " + ChatColor.DARK_RED + p.getName() + ": " + ChatColor.translateAlternateColorCodes('&', msg));
						} else {
							ChatUtils.broadcastAdminChannel(ChatColor.DARK_RED + "[A] " + ChatColor.GOLD + "[" + ChatColor.DARK_RED + "Admin" + ChatColor.GOLD + "] " + ChatColor.DARK_RED + p.getName() + ": " + ChatColor.RED + ChatColor.translateAlternateColorCodes('&', msg));
						}
					} else {
						ChatUtils.broadcastAdminChannel(ChatColor.DARK_RED + "[A] " + ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + "Mod" + ChatColor.DARK_GRAY + "] " + ChatColor.BLUE + p.getName() + ": " + ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', msg));
					}
				} else {
					p.sendMessage(ChatColor.DARK_RED + "Admin Chat: '/a <Nachricht>'");
				}
			} else {
				p.sendMessage(ChatColor.RED + "Du hast keine Rechte diesen Befehl zu nutzen.");
			}
		} else {
			cs.sendMessage(ChatColor.RED + "Du musst ein Spieler sein!");
		}
		return true;
	}
}
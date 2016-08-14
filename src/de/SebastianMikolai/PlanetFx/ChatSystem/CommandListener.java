package de.SebastianMikolai.PlanetFx.ChatSystem;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.SebastianMikolai.PlanetFx.ChatSystem.Utils.ChatUtils;

public class CommandListener implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (cs instanceof Player) {
			Player p = (Player) cs;
			if (args.length == 0) {
				p.sendMessage("§6= = = = §a§lPlanet-Fx ChatSystem §6= = = =");
				p.sendMessage("§6Optionen: §f/chat");
				p.sendMessage("");
				p.sendMessage("§6Chat on/off: §f/chat (on/off)");
			} else {
				if (args[0].equalsIgnoreCase("on") == true) {
					ChatSystem.getInstance().enable_chat = true;
					ChatUtils.broadcastMessage(ChatSystem.getInstance().prefix + ChatColor.GOLD + "Der Chat ist nun aktiviert!");
				} else if (args[0].equalsIgnoreCase("off") == true) {
					ChatSystem.getInstance().enable_chat = false;
					ChatUtils.broadcastMessage(ChatSystem.getInstance().prefix + ChatColor.GOLD + "Der Chat ist nun deaktiviert!");
				}
			}
		} else {
			cs.sendMessage(ChatColor.RED + "Du musst ein Spieler sein!");
		}
		return true;
	}
}
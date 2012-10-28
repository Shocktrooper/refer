package com.empclan.refer; 

import java.sql.SQLException;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReferCommandExecutor implements CommandExecutor 

{
	public static refer plugin;

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		Player player = null;
		if ((sender instanceof Player)) {
			player = (Player)sender;
		}
		if (cmd.getName().equalsIgnoreCase("refer"))
		{
		}if (args[0].equals("check")) {
			ReferCheckCommandExecutor.command(args, player, sender);
			return true;
		}if (args[0].equals("enter")) {
			try {
				ReferEnterCommandExecutor.command(args, player, sender);
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}if (args[0].equals("get")) {
			ReferGetCommandExecutor.command(args, player, sender);
			return true;
		}if (args[0].equals("set")) {
			ReferSetCommandExecutor.command(args, player, sender);
			return true;
		}
		return true;
	}	
	
	public ReferCommandExecutor(refer instance)
	{
		plugin = instance;
	}
	
}
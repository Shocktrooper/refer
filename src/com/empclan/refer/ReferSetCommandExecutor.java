package com.empclan.refer;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReferSetCommandExecutor extends ReferCommandExecutor {


	public ReferSetCommandExecutor(refer instance) {
		super(instance);
	}

	public static boolean command(String[] args, Player player, CommandSender sender) 
	{
		if(args.length==2)
		{
			if(player.hasPermission("refer.set"))
			{
				if(args[1]=="set")
				{
					
				}
			}
		}
		return false;
	}
	private static String setEntry(Player player,String arg)
	{
		
		return "success";
	}
}


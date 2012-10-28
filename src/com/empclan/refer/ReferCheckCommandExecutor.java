package com.empclan.refer;

import java.sql.ResultSet;
import java.sql.SQLException;
import lib.PatPeter.SQLibrary.MySQL;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReferCheckCommandExecutor extends ReferCommandExecutor{
//initiates class variables
	private static MySQL mysql;
	Player player = null;
	
	//initiates on command. First checks args length then checks if sender is a player then checks permissions node
	//then tries to use getReferrals to see if user has any referrals and sends to player how many refferals
	
	public static boolean command(String[] args, Player player, CommandSender sender) 
	{
		if(args.length==2)
		{
			if ((sender instanceof Player)) 
			{
//does something with the player(wish it could be explaned to me)
				player = (Player)sender;
				//checks if player has permission to check their own referrals 
				if(player.hasPermission("refer.check")) 
				{
					String name = args[1];
					
					//TODO do all my stuff here
					//maybe the right argument im not sure if this will even get a argument
					
					try {
						
//						uses getReferrals to set the referrals variable to the players variable count 
//						then sends the player a message telling them how many they have 
						
						String referrals = ReferCheckCommandExecutor.getReferrals(name);
						sender.sendMessage("you have "+ referrals + "refferals");
						
					} catch (SQLException e) {
						e.printStackTrace();
						//prints what goes wrong if anythign
					}

				}
				else
				{
					sender.sendMessage(ChatColor.RED + "You don't have permission to do that!");
				}	

			}
			
		}		
		//returns false if player did not send the correct amount of arguments
		return false;
	}	

	public ReferCheckCommandExecutor(refer instance) {
		super(instance);
		//constructor(don't really know what to do with this if anything)
	}

	private static String getReferrals(String name) throws SQLException
	{
		ResultSet rs = mysql.query("SELECT referrals FROM refer_db1 WHERE playername=" + name);
		try{
			if(rs.first())
				return rs.getString("referrals");
		} catch (SQLException e){
		}
		throw new SQLException("Error getting " + name + "'s referrals");
	}
	/**
	 * Method getRefferrals gets the referrals from the db for the player who requested it and sends it back
	 * to the command method in the class
	 */

}

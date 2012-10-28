package com.empclan.refer; 

import java.sql.ResultSet;
import java.sql.SQLException;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import lib.PatPeter.SQLibrary.MySQL;

public class ReferGetCommandExecutor extends ReferCommandExecutor {

	private static MySQL mysql;	

	public ReferGetCommandExecutor(refer instance) {
		super(instance);
		// TODO Auto-generated constructor stub
	}

	private static String getCode(Player player) throws SQLException

	{
		ResultSet rs = mysql.query("SELECT refer_code FROM refer_db WHERE playername=" + player);
		try{
			if(rs.first())
				return rs.getString("referrals");

		} catch (SQLException e){
		}
		throw new SQLException("Error getting " + player + "'s refferals");
	}

	//gets the players own code and returns it to the player that wanted it 
	public static boolean command(String[] args, Player player, CommandSender sender) 
	{
		if (args.length == 1) 
		{
			if (player.hasPermission("refer.get")) 
			{
				try 
				{

					String returncode = ReferGetCommandExecutor.getCode(player);
					player.sendMessage(returncode);
					return true;
				}	
				 catch (SQLException e) 
				{
					e.printStackTrace();
					return false;
				}
			}
		}

		return false;
	}
}
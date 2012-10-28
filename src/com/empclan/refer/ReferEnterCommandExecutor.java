package com.empclan.refer;

import java.sql.ResultSet;
import java.sql.SQLException;
import lib.PatPeter.SQLibrary.MySQL;
import org.apache.commons.lang.RandomStringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReferEnterCommandExecutor extends ReferCommandExecutor {

	private static MySQL mysql;

	// on command see if the code has been used already and if not credit the player in database 
	//
	// fix all of this its messed up
	public static boolean command(String[] args, Player player,CommandSender sender) throws SQLException 
	{
		if (args.length == 2) 
		{
			if (player.hasPermission("refer.enter")) 
			{
				if (args[0] == "enter") 
				{
					if (ReferEnterCommandExecutor.checkEntry(player) == true) 
					{
//there is a playerentry with the code the player entered then error the player is already referred
					}
				}
			}
		}
		return false;
	}

	// constructor
	public ReferEnterCommandExecutor(refer instance) {
		super(instance);

	}

	// checks if player has a entry in sql database returns true of there is and
	// false if not
	private static boolean checkEntry(Player player) throws SQLException

	{
		ResultSet rs = mysql
				.query("SELECT COUNT(Player)FROM refer_db1 where Player="
						+ player);
		try {
			if (rs.first())

				return true;
			else if (!rs.first())

				return false;

		} catch (SQLException e) {
		}
		throw new SQLException("Error " + player + "does not exist in Database");
	}

	// creates a entry for the player in the SQL database
	private static void createEntry(Player player) throws SQLException {

		MySQL mysql = null;

		String playerstring = player.toString();

		String randomCode = RandomStringUtils.random(8, true, true);

		byte Zero = 0;

		String entry = ("INSERT INTO refer_db1 (Player, Code, Refferals) VALUES ('"
				+ playerstring + "','" + randomCode + "','" + Zero + "')");

		mysql.query(entry);
	}

}
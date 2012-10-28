package com.empclan.refer; 

import java.io.File;
import java.io.IOException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;

public class Config {

	refer plugin;
	PluginDescriptionFile pluginInfo;
	public static String pluginName;
	public static String pluginVersion;
	public static String pluginTitle;
	public static String pluginAuthor;
	public static File dataPath;
	public static String host;
	public static int port;
	public static String user;
	public static String pass;
	public static String database;

	public static void loadConfig(refer plugin) throws IOException
	{
		dataPath = new File(plugin.getDataFolder() + File.separator);
		FileConfiguration config = plugin.getConfig();
		if(!dataPath.exists())
			dataPath.mkdirs();
		host = config.getString("mySQL.host", "127.0.0.1");
		port = config.getInt("mySQL.port", 3306);
		database = config.getString("mySQL.database", "antimulti");
		user = config.getString("mySQL.user", "root");
		pass = config.getString("mySQL.pass", "");
		config.set("mySQL.host", host);
		config.set("mySQL.port", port);
		config.set("mySQL.database", database);
		config.set("mySQL.user", user);
		config.set("mySQL.pass", pass);
		config.set("version", plugin.getDescription().getVersion());
		config.save(dataPath + File.separator + "config.yml");
	}

}